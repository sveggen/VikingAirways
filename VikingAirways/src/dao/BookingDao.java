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

    /**
     *
     * @param bookingnumber
     */
    //Makes a connection to the database and deletes booking
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

    /**
     *
     * @param bookingnumber
     * @param customerID
     */
    //Makes a connection to the database and deletes customer and booking
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
