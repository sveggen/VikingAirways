package dao;

import DBConnection.DBConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Optional;

/**
 *
 * This class makes a connection to the database and deletes entries.
 *
 * @author magnusneergaard
 * @author Markus Sveggen
 * @version 24.11.2019
 */

public class BookingDao implements Dao {

    private DBConnect dbconnect = new DBConnect();

    @Override
    public Optional get(long id) {
        return Optional.empty();
    }

    @Override
    public List getAll() {
        return null;
    }

<<<<<<< HEAD
    /**
     *
     * @param bookingnumber
     */
    //Makes a connection to the database and deletes booking
=======
    /**Deletes booking from the DB.
     *
     * @param bookingnumber     The customers booking number.
     */
>>>>>>> 004ccf31645364819958ab65175edc1901870221
    public void deleteBooking(String bookingnumber) {
        try {
            Connection conn = dbconnect.connectToDB();

            String dlt = "DELETE FROM Booking WHERE booking_number = (?);";

            try (PreparedStatement deleteBooking = conn.prepareStatement(dlt)) {
                deleteBooking.setString(1, bookingnumber);
                deleteBooking.executeUpdate();
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

<<<<<<< HEAD
    /**
     *
     * @param bookingnumber
     * @param customerID
     */
    //Makes a connection to the database and deletes customer and booking
=======
    /**Deletes the booking and the linked customer from the DB.
     *
     * @param bookingnumber     The customers booking number.
     * @param customerID        The customers unique ID.
     */
>>>>>>> 004ccf31645364819958ab65175edc1901870221
    public void deleteBookingandCustomerID(String bookingnumber, String customerID){
        try {
            Connection conn = dbconnect.connectToDB();

            String cstmrDlt = "DELETE FROM Customer, Booking WHERE customer_id =  (?)"
                    +"AND booking_number = (?);";

            try (PreparedStatement deleteBookingandID = conn.prepareStatement(cstmrDlt)){
                deleteBookingandID.setString(1, customerID);
                deleteBookingandID.setString(2, bookingnumber);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
