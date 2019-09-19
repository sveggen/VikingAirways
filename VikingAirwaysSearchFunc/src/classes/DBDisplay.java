package classes;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBDisplay {

    Statement stmnt;

    public void displayTables(Connection conn, PrintWriter out, String destination) {

        String strSelect = "SELECT * FROM flight WHERE destination_airport = '"+destination+"';";

        try {
            stmnt = conn.createStatement();
            ResultSet rset = stmnt.executeQuery(strSelect);

            out.println("Available flights:" +"<br>");

            while(rset.next()) {
                int flightnumber = rset.getInt("flight_number");
                String dateOfDeparture = rset.getString("date_of_departure");
                String timeOfDeparture = rset.getString("time_of_departure");
                String destinationAirport = rset.getString("destination_airport");
                String departureAirport = rset.getString("departure_airport");
                int availableSeats = rset.getInt("available_seats");

                out.println(flightnumber + dateOfDeparture + timeOfDeparture + destinationAirport + departureAirport + availableSeats +"<br>");
            }
        }
        catch (SQLException ex) {
            out.println("Error extracting data from database " +ex);
        }


    }

}
