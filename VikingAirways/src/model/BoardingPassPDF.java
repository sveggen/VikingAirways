package model;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import DBConnection.*;

public class BoardingPassPDF {

    private int bNumber;
    private int flightNumber;
    private String passengerName;
    private String departureDate;
    private String departureTime;
    private String arrivalTime;
    private String generatedPDFName;
    private boolean PDFGenerated = false;

    private static Font headlineFont = new Font(Font.FontFamily.HELVETICA, 24, Font.BOLD);
    private static Font subheaderFont = new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD);
    private static Font contentFont = new Font(Font.FontFamily.HELVETICA, 12, Font.NORMAL);

    private String importantInfoText = "All passengers must carry valid identification and travel documents for alle flights. For specific information about "
            +"these requirements, contact the appropriate authorities (i.e. embassy/consulate).\n"+
            "All baggage must be marked with name, address and phone number of the passenger.\n"+
            "Check in opens at least 2 hours before departure on all flights and closes 1 hour before departure on international flights "
            +"to/from USA, Canada, Thailand, Singapore, Israel, Jordan, Morocco, "
            +"Dubai and Argentina, 30 minutes before departure on all domestic flights within the Nordics and 45 minutes before departure on all other flights.\n"+
            "PS: Passengers with special needs, special baggage og children traveling alone, have to check in at least 1 hour before original departure time.\n"+
            "Boarding closes 20 minutes before departure on all flights.";

    private String bookingChangesText = "Changes have to be submitted at least 30 minutes before planned departure time for a fee. "
            +"Changes can be done online at My Booking. A service fee will incur for changes done via our contact center or at the airport.\n" +
            "Tickets booked as part of a hotel/flight package and/or through a travel agency might be subject to other rules.";



    public void makePDF(String booknr, String tomcatPath) {
        try {
            createPDF(booknr, tomcatPath);
        } catch (DocumentException | FileNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void createPDF(String bookingNumber, String tomcatPath) throws DocumentException, FileNotFoundException, SQLException {

        String passengerFirstName = null;
        String passengerLastName = null;
        //String baseDirectory = "C:\\Users\\fredr\\java\\github.com\\jorgenl95\\VikingAirways\\VikingAirways\\web\\boardingpasses";
        String baseDirectory = tomcatPath;

        //Connect to database
        Connection conn;
        DBConnect dbconnect = new DBConnect();
        conn = dbconnect.connectToDB();

        String strSelect = "SELECT * FROM Flight, Customer, Booking WHERE booking_number="+ bookingNumber
                +" AND Booking.flight_number_fk = Flight.flight_number AND Booking.customer_id_fk = Customer.customer_id";

        Statement stmt;
        stmt = conn.createStatement();
        ResultSet rset = stmt.executeQuery(strSelect);

        //Extract data from resultset and save in appropriate class variables
        if(rset.next()) {
            bNumber = rset.getInt("booking_number");
            flightNumber = rset.getInt("flight_number");
            passengerFirstName = rset.getString("first_name");
            passengerLastName = rset.getString("last_name");
            passengerName = passengerFirstName + " " + passengerLastName;
            departureDate = rset.getString("departure_date");
            departureTime = rset.getString("departure_time");
            arrivalTime = rset.getString("arrival_time");
        }

        Document document = new Document();

        //Check if directories where boarding passes will be stored exists, if not create them
        Path storageDirectory = Paths.get(baseDirectory);
        if(!Files.isDirectory(storageDirectory)) {
            try {
                Files.createDirectories(storageDirectory);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        File newPDF = new File(baseDirectory+"\\VA-Boarding-Card-"+passengerFirstName+"-"+passengerLastName+"-"+bNumber+".pdf");

        if(!newPDF.isFile()) {

            // Check to see if file already exists, if so add a simple appendix to the end of the file name
            int i = 1;
            while (newPDF.isFile()) {
                String appendix = "new" + i;
                newPDF = new File(baseDirectory + "\\VA-Boarding-Card-" + passengerFirstName + "-" + passengerLastName + "-" + bNumber + "-" + appendix + ".pdf");
                //System.out.println("File already exists. New file name: " + newPDF.getName());
                i++;
            }

            PdfWriter.getInstance(document, new FileOutputStream(newPDF));

            document.open();

            Paragraph title = new Paragraph("Boarding Pass", headlineFont);
            title.setAlignment(Paragraph.ALIGN_CENTER);
            title.setSpacingAfter(25);
            document.add(title);

            createTable(document);
            addEmptyLine(document, 2);

            Paragraph importantInfoHeader = new Paragraph("Important Info", subheaderFont);
            importantInfoHeader.setAlignment(Paragraph.ALIGN_CENTER);
            importantInfoHeader.setSpacingAfter(25);
            document.add(importantInfoHeader);

            Paragraph importantInfo = new Paragraph(importantInfoText, contentFont);
            importantInfo.setAlignment(Paragraph.ALIGN_LEFT);
            importantInfo.setSpacingAfter(50);
            document.add(importantInfo);

            Paragraph bookingChangesHeader = new Paragraph("Booking changes", subheaderFont);
            bookingChangesHeader.setAlignment(Paragraph.ALIGN_CENTER);
            bookingChangesHeader.setSpacingAfter(25);
            document.add(bookingChangesHeader);

            Paragraph bookingChanges = new Paragraph(bookingChangesText, contentFont);
            bookingChanges.setAlignment(Paragraph.ALIGN_LEFT);
            bookingChanges.setSpacingAfter(50);
            document.add(bookingChanges);

            document.close();
        }
        generatedPDFName = newPDF.getName();
        PDFGenerated = true;
    }

    // Create a table with two columns and fill with necessary info
    private void createTable(Document document) throws DocumentException {
        PdfPTable table = new PdfPTable(2);

        table.addCell("Booking Number");
        table.addCell(""+bNumber);
        table.addCell("Passenger");
        table.addCell(passengerName);
        table.addCell("Flight number:");
        table.addCell(""+flightNumber);
        table.addCell("Departure date:");
        table.addCell(departureDate);
        table.addCell("Departure time:");
        table.addCell(departureTime);
        table.addCell("Arrival time:");
        table.addCell(arrivalTime);
        table.addCell("Seat:");
        table.addCell("No seat reservation");
        table.addCell("Class:");
        table.addCell(" ");

        table.setWidthPercentage(100);
        document.add(table);
    }

    //Add a specified number of empty paragraphs
    private void addEmptyLine(Document document, int number) throws DocumentException {
        for (int i = 0; i < number; i++) {
            document.add(new Paragraph(" "));
        }
    }

    //Returns absolute filepath of PDF generated by this class if created, if not return message stating no PDF
    public String getFileName() {
        if(PDFGenerated)
            return generatedPDFName;
        else
            return "No PDF generated yet";
    }

}