package dao;

import DBConnection.DBConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class FlightDao implements Dao {
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

    public void deleteFlight(String selectedFlight) {

        Connection conn = dbconnect.connectToDB();

        String dlFlight = "delete from Flight where flight_number=(?);";
        String dlClass = "delete from Class where class_flight_fk=(?);";

        try (PreparedStatement dlClassStmt = conn.prepareStatement(dlClass)) {
            dlClassStmt.setString(1, selectedFlight);
            dlClassStmt.executeUpdate();

            try( PreparedStatement dlFlightstmt = conn.prepareStatement(dlFlight)) {
                dlFlightstmt.setString(1, selectedFlight);
                dlFlightstmt.executeUpdate();
            }

        } catch (
                SQLException ex) {
        }
    }
}

