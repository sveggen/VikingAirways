package dao;

import DBConnection.DBConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Optional;

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


    public void deleteBooking(String bookingnumber) {
        try {
            Connection conn = dbconnect.connectToDB();

            String dlt = "DELETE FROM Booking WHERE booking_number = (?);";

            try (PreparedStatement deleteBooking = conn.prepareStatement(dlt)) {
                deleteBooking.setString(1, bookingnumber);
                deleteBooking.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteBookingandCustomerID(String bookingnumber, String customerID){
        try {
            Connection conn = dbconnect.connectToDB();

            String cstmrDlt = "DELETE FROM Customer, Booking WHERE customer_id =  (?)"
                    +"AND booking_number = (?);";

            try (PreparedStatement deleteBookingandID = conn.prepareStatement(cstmrDlt)){
                deleteBookingandID.setString(1, customerID);
                deleteBookingandID.setString(2, bookingnumber);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
