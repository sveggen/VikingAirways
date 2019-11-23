package dao;

import DBConnection.DBConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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

    @Override
    public void create(Object o) {

    }

    @Override
    public void update(Object o) {

    }

    @Override
    public void delete(Object o) {

    }

    public void deleteBooking(String bookingnumber){
        try {
            Connection conn = dbconnect.connectToDB();

            String dlt = "DELETE FROM Booking WHERE booking_number = (?);";

            try (PreparedStatement deleteBooking = conn.prepareStatement(dlt)){
                deleteBooking.setString(1, bookingnumber);
                deleteBooking.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void newBooking(String extraLuggage, String extraCarryon, String specialEquipment, String petCarryon, String foodonflight, String wifiOnFlight, String flightnumber, String classID ) {
        try {
            Connection conn = dbconnect.connectToDB();

            String bookinginfo = "INSERT INTO Booking (customer_paid, checked_in_baggage, extra_carryon, " +
                    "special_equipment, pet_carryon, food_on_flight, wifi_on_flight, flight_number_fk, customer_id_fk, class_id_fk, registered_user_fk) " +
                    "VALUES('1', ?, ?, ?, ?, ?, ?, ?, LAST_INSERT_ID(), ?, ?);";

            try (PreparedStatement insertBookingInfo = conn.prepareStatement(bookinginfo)) {
                insertBookingInfo.setString(1, extraLuggage);
                insertBookingInfo.setString(2, extraCarryon);
                insertBookingInfo.setString(3, specialEquipment);
                insertBookingInfo.setString(4, petCarryon);
                insertBookingInfo.setString(5, foodonflight);
                insertBookingInfo.setString(6, wifiOnFlight);
                insertBookingInfo.setString(7, flightnumber);
                insertBookingInfo.setString(8, classID);

            } catch (SQLException ex) {
                ex.printStackTrace();
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
