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


    public void deleteFlight(String selectedFlight) throws SQLException {

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
        conn.close();
    }

    /**
     *
     * @param flight_number The number of the flight
     * @param departure_date The date of departure
     * @param departure_time The time of departure
     * @param arrival_airport Which airport the plane arrives at
     * @param departure_airport Which airport the plane departs from
     * @param arrival_time The time of arrival
     *
     *This method connects to the database and inserts the input data directly into the database.
     */

    public void addFlight(String flight_number, String departure_date, String departure_time, String arrival_airport, String departure_airport, String arrival_time) {

        try {
            //Connects to the database and creates a variable to insert data into the given table and columns in the database
            Connection conn = dbconnect.connectToDB();
            String sql1 = "INSERT INTO Flight (flight_number, departure_date, departure_time, arrival_airport, departure_airport, arrival_time) VALUES (? ,? ,? ,? ,? ,? )";

            PreparedStatement statement1 = conn.prepareStatement(sql1);
            statement1.setString(1, flight_number);
            statement1.setString(2, departure_date);
            statement1.setString(3, departure_time);
            statement1.setString(4, arrival_airport);
            statement1.setString(5, departure_airport);
            statement1.setString(6, arrival_time);

            statement1.executeUpdate();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    /**
     *
     * @param class_type Which type of class (Economic, business, first class)
     * @param class_capacity How many seats available for this class
     * @param class_price The price of a ticket for the given class
     * @param class_flight_fk Which flightnumber this class is connected to
     *
     *This method connects to the database and inserts the input data directly into the database.
     */
    public void addClass(String class_type, String class_capacity, String class_price, String class_flight_fk) {

        //Connects to the database and creates a variable to insert data into the given table and columns in the database
        try {
            Connection conn = dbconnect.connectToDB();
            String sql2 = "INSERT INTO Class (class_type, class_capacity, class_price, class_flight_fk) VALUES (?, ?, ?, ?)";
            PreparedStatement statement2 = conn.prepareStatement(sql2);
            statement2.setString(1, class_type);
            statement2.setString(2, class_capacity);
            statement2.setString(3, class_price);
            statement2.setString(4, class_flight_fk);

            statement2.executeUpdate();

            conn.close();

        }

        catch (SQLException e) {
            e.printStackTrace();
        }

    }
}

