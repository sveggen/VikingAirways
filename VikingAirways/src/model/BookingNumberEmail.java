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

    protected String recipient;
    protected String subject;
    protected String content;

    /**
     * This method sends an email to the customer with booking information.
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
                    //Creates variables from values collected from Database
                    String firstName = rset.getString("first_name");
                    String lastName = rset.getString("last_name");
                    String departureAirport = rset.getString("departure_airport");
                    String arrivalAirport = rset.getString("arrival_airport");
                    String departure_date = rset.getString("departure_date");

                    //Creates variables to be used when sending an email.
                    recipient = rset.getString("email");
                    subject = "Booking confirmation";
                    content = "Hello " + firstName + " " + lastName + ". <br>" +
                            "Your bookingnumber is " + bookingNumber + ", for your flight from " + departureAirport +
                            " to " + arrivalAirport + " on the "+ departure_date + "."+"<br><br>" +
                            "Have a nice flight! <br>" +
                            "<b>Viking Airways</b> <br>" +
                            "NO-4635 Kristiansand, Norway <br>" +
                            "Tel. +47 38 04 55 38 <br>";

                    super.sendEmail(recipient, subject, content);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }
}