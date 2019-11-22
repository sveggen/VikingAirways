package dao;

import DBConnection.DBConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Optional;

public class MultipleTablesDao implements Dao {
    DBConnect dbconnect = new DBConnect();

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

    public void deleteBooking(String bookingnumber, String customerID){
        try {
            Connection conn = dbconnect.connectToDB();

            String cstmrDlt = "DELETE FROM Customer, Booking WHERE customer_id =  (?)"
                    +"AND booking_number = (?);";

            try (PreparedStatement deleteBooking = conn.prepareStatement(cstmrDlt)){
                deleteBooking.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
