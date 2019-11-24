package model;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * This class extends the Email-class, and sends an email with booking information to a customer.
 *
 * @author Markus Sveggen
 * @version 23.11.2019
 */

public class BookingNumberEmail extends Email{

    protected String recipient; //The addressee's email address.
    protected String subject; //The subject of the Email.
    protected String content; //The content of the Email.

    /**
     * This method collects the customers booking information from the database, and sends an email
     * to the customer with the customers booking information.
     *
     * @param conn             connection to the database
     * @param bookingNumber    the customers bookingnumber
     */
    public void sendEmail(Connection conn, String bookingNumber)  {

            String strSelect = "SELECT * FROM Customer, Flight, Booking WHERE Booking.customer_id_fk = Customer.customer_id " +
                    "AND Booking.flight_number_fk = Flight.flight_number AND Booking.booking_number= "+bookingNumber;

            try {
                Statement stmnt = conn.createStatement();
                ResultSet rset = stmnt.executeQuery(strSelect);

                while (rset.next()) {
                    //Retrieves values from the database, and creates variables.
                    String firstName = rset.getString("first_name");
                    String lastName = rset.getString("last_name");
                    String departureAirport = rset.getString("departure_airport");
                    String arrivalAirport = rset.getString("arrival_airport");
                    String departure_date = rset.getString("departure_date");

                    //Creates variables to be passed to the Email-superclass-object, in order to send an email.
                    recipient = rset.getString("email");
                    subject = "Booking confirmation";
                    content = "Hello " + firstName + " " + lastName + ". <br>" +
                            "Your bookingnumber is " + bookingNumber + ", for your flight from " + departureAirport +
                            " to " + arrivalAirport + " on the "+ departure_date + "."+"<br>" + "You can retrieve your boarding pass <a href=\"http://localhost:8080/VikingAirways/checkIn.jsp\">here.</a><br><br>" +
                            "Have a nice flight! <br>" +
                            "<b>Viking Airways</b> <br>" +
                            "NO-4635 Kristiansand, Norway <br>" +
                            "Tel. +47 38 04 55 38 <br>";

                    //Initiates the sendEmail method from the Email-superclass, and passes the previously set variables.
                    super.sendEmail(recipient, subject, content);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }
}