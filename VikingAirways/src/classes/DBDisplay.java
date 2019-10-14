package classes;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBDisplay {

    Statement stmnt;

    public void displayTables(Connection conn, PrintWriter out, String destination, String departureDate, String dprtAirport) {

        String strSelect = "SELECT * FROM Flight WHERE arrival_airport = '"+destination
                            +"' AND departure_date = '"+departureDate
                            +"' AND departure_airport ='"+dprtAirport+"';";

        try {
            stmnt = conn.createStatement();
            ResultSet rset = stmnt.executeQuery(strSelect);

            out.println("<h1>Available flights:</h1>" +"<br/><br/>");
            out.println("<div class=\"table\">");
            out.println("<div class=\"tr\">");
            out.println("<div class=\"td\">Flight Number</div>");
            out.println("<div class=\"td\">Date of Departure</div>");
            out.println("<div class=\"td\">Time of Departure</div>");
            out.println("<div class=\"td\">Destination Airport</div>");
            out.println("<div class=\"td\">Departure Airport</div></div>");


            while(rset.next()) {
                int flightnumber = rset.getInt("flight_number");
                String dateOfDeparture = rset.getString("departure_date");
                String timeOfDeparture = rset.getString("departure_time");
                String destinationAirport = rset.getString("arrival_airport");
                String departureAirport = rset.getString("departure_airport");
                //int availableSeats = rset.getInt("available_seats");

                out.println("   <form class=\"tr\" method=\"post\" action=\"Flight_details\">");
                out.println("       <span class=\"td\">"+flightnumber+"</span>");
                out.println("       <span class=\"td\">"+dateOfDeparture+"</span>");
                out.println("       <span class=\"td\">"+timeOfDeparture+"</span>");
                out.println("       <span class=\"td\">"+destinationAirport+"</span>");
                out.println("       <span class=\"td\">"+departureAirport+"</span>");
                out.println("       <span class=\"td\"><button name=\"selectedFlight\" type=\"submit\" value=\""+flightnumber+"\">Select</button></span>");
                out.println("   </form>");
            }
            out.println("</div>");
        }
        catch (SQLException ex) {
            out.println("Error extracting data from database " +ex);
        }

    }

}
