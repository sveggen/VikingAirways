package model;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBDisplay {

    Statement stmnt;

    public void displayTables(Connection conn, PrintWriter out, String destination, String departureDate, String dprtAirport, HttpServletResponse response) {


        String strSelect = "SELECT * FROM Flight WHERE arrival_airport = '"+destination
                            +"' AND departure_date = '"+departureDate
                            +"' AND departure_airport ='"+dprtAirport
                            //+"' AND Flight.flight_number = Class.class_flight_fk"
                           // +"  AND Class.class_type = 'Economy'"
                            +"';";

        try {
            stmnt = conn.createStatement();
            ResultSet rset = stmnt.executeQuery(strSelect);

            out.println("<div class=\"jumbotron text-center\"><h1>Available flights</h1>");
            out.println("<h3>From: "+dprtAirport+"&emsp;To: "+destination+"</h3></div><br/><br/>");
            out.println("<div class=\"container\">");
            out.println("<label for=\"selectedFilter\">Order by:</label>");
            out.println("<select name=\"selectedFilter\" id=\"selectedFilter\">");
            out.println("<option value=\"Time\">Flight time</option>");
            out.println("<option value=\"Price\">Price</option>");
            out.println("</select>");
            out.println("<button onclick=\"sortTable()\">Sort</button><br/><br/>");
            out.println("<table id=\"resultTable\" class=\"table table-bordered\">");
            out.println("<thead>");
            out.println("<tr>");
            out.println("<th>Flight Number</th>");
            out.println("<th>Date of Departure</th>");
            out.println("<th>Time of Departure</th>");
            out.println("<th>Time of Arrival</th>");
            out.println("<th>Flight time</th>");
            out.println("<th>Destination Airport</th>");
            out.println("<th>Departure Airport</th>");
            out.println("<th></th></tr></thead>");
            out.println("<tbody>");


            while(rset.next()) {
                int flightnumber = rset.getInt("flight_number");
                String dateOfDeparture = rset.getString("departure_date");
                String timeOfDeparture = rset.getString("departure_time");
                String timeOfArrival = rset.getString("arrival_time");
                String destinationAirport = rset.getString("arrival_airport");
                String departureAirport = rset.getString("departure_airport");
                //String priceEconomy = rset.getString("class_price");

                timeOfArrival = timeOfArrival.substring(0, timeOfArrival.length() - 3);
                timeOfDeparture = timeOfDeparture.substring(0, timeOfDeparture.length() - 3);

                out.println("   <form id=\"form"+flightnumber+"\" class=\"justify-content-center\" method=\"post\" action=\"FlightDetails\">");
                out.println("       <tr>");
                out.println("       <td class=\"flightNumber\">"+flightnumber+"</td>");
                out.println("       <td>"+dateOfDeparture+"</td>");
                out.println("       <td>"+timeOfDeparture+"</td>");
                out.println("       <td>"+timeOfArrival+"</td>");
                out.println("       <td>"+timeDiff(timeOfDeparture, timeOfArrival)+" minutes</td>");
                out.println("       <td>"+destinationAirport+"</td>");
                out.println("       <td>"+departureAirport+"</td>");
                //out.println("       <td>From: "+priceEconomy+"</td>");
                out.println("       <td><button form=\"form"+flightnumber+"\" name=\"selectedFlight\" class=\"btn btn-success\" value=\""+flightnumber+"\">Select</button></td>");
                out.println("       </tr>");
                out.println("   </form>");
            }
            out.println("</tbody></table></div>");
        }
        catch (SQLException ex) {
            System.out.println("Error extracting data from database " +ex);
        }

    }

    private int timeDiff (String timeDeparture, String timeArrival) {
        String[] hourMinFirst = timeDeparture.split(":");
        String[] hourMinSecond = timeArrival.split(":");

        int hourFirst = Integer.parseInt(hourMinFirst[0]);
        int minuteFirst = Integer.parseInt(hourMinFirst[1]);

        int hourSecond = Integer.parseInt(hourMinSecond[0]);
        int minuteSecond = Integer.parseInt(hourMinSecond[1]);

        int hourFirstInMins = hourFirst * 60;
        int hourSecondInMins = hourSecond * 60;

        return (hourSecondInMins + minuteSecond) - (hourFirstInMins + minuteFirst);
    }

}
