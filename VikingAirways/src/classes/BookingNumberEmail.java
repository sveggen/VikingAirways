package classes;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BookingNumberEmail {
    Statement stmnt;


    public static void main(String[] args){
        BookingNumberEmail bn = new BookingNumberEmail();
        bn.sendEmail("3");

    }
    public void sendEmail(String bookingNumber) {
            //Koble til database
            Connection conn;
            DBConnect dbconnect = new DBConnect();
            conn = dbconnect.connectToDB();

            String strSelect = "SELECT * FROM Customer WHERE customer_id = " + bookingNumber;
            try {
                stmnt = conn.createStatement();
                ResultSet rset = stmnt.executeQuery(strSelect);

                if (rset.next()) {
                    String firstName = rset.getString("first_name");
                    String lastName = rset.getString("last_name");
                    String departureAirport = "";
                    String arrivalAirport = "";

                    //Declare variables to be used when sending an email.
                    String recipient = "m.sveggen@gmail.com";
                    String subject = "Booking confirmation";
                    String content = "Hello " + firstName + " " + lastName + ". <br>" +
                            "Your bookingnumber is " + bookingNumber + ", for your flight from " + departureAirport +
                            " to " + arrivalAirport + "." + "<br><br>" +
                            "Have a nice flight! <br>" +
                            "<b>Viking Airways</b> <br>" +
                            "NO-4635 Kristiansand, Norway <br>" +
                            "Tel. +47 38 04 55 38 <br>";

                    //Creates an email object.
                    Email email = new Email();
                    email.sendEmail(recipient, subject, content);

                } else {
                    System.out.println("Email was not sent");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }
}