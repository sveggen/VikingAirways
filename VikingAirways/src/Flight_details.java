import classes.DBConnect;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet(name = "Flight_details", urlPatterns = {"/Flight_details"})

public class Flight_details extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        String selectedFlight = request.getParameter("selectedFlight");

        out.println("<h1>Selected flight:</h1>" +"<br/><br/>");

        Connection conn;
        DBConnect dbconnect = new DBConnect();
        conn = dbconnect.connectToDB();

        String strSelect = "SELECT * FROM Flight WHERE flight_number = "+ selectedFlight;

        Statement stmnt;

        try {
            stmnt = conn.createStatement();
            ResultSet rset = stmnt.executeQuery(strSelect);


            if(rset.next()) {
                int flightnumber = rset.getInt("flight_number");
                String dateOfDeparture = rset.getString("departure_date");
                String timeOfDeparture = rset.getString("departure_time");
                String destinationAirport = rset.getString("arrival_airport");
                String departureAirport = rset.getString("departure_airport");
                String arrivalTime = rset.getString("arrival_time");
                int availableSeatsEcon = rset.getInt("available_seats_economy");
                int availableSeatsBusi = rset.getInt("available_seats_business");
                int availableSeatsFirst = rset.getInt("available_seats_firstclass");
                int priceEcon = rset.getInt("price_economy");
                int priceBusi = rset.getInt("price_business");
                int priceFirst = rset.getInt("price_firstclass");

                out.println("Flight selected: " + selectedFlight);
                out.println("</br>Date og departure: " + dateOfDeparture);
                out.println("</br>Time of departure: " + timeOfDeparture);
                out.println("</br>Destination airport: " + destinationAirport);
                out.println("</br>Departure airport: " + departureAirport);
                out.println("</br>Arrivle time: " + arrivalTime);
                out.println("</br></br>");

                out.println("<table style=\"width:30%\" border=\"1\">");
                out.println(" <form method=\"post\" action=\"\"");
                out.println("  <tr>");
                out.println("    <th>Class</th>");
                out.println("    <th>Seats</th>");
                out.println("    <th>Price</th>");
                out.println("  </tr>");
                out.println("  <tr>");
                out.println("    <th>Economy: </th>");
                out.println("    <td>"+availableSeatsEcon+"</td>");
                out.println("    <td>"+priceEcon+"</td>");
                out.println("    <td><button name=\"SelectedClass\" value=\"Economy"+flightnumber+"\" type=\"submit\">Select</button></td>");
                out.println("  </tr>");
                out.println("  <tr>");
                out.println("    <th>Business: </th>");
                out.println("    <td>"+availableSeatsBusi+"</td>");
                out.println("    <td>"+priceBusi+"</td>");
                out.println("    <td><button name=\"SelectedClass\" value=\"Business"+flightnumber+"\" type=\"submit\">Select</button></td>");
                out.println("  </tr>");
                out.println("  <tr>");
                out.println("    <th>First class: </th>");
                out.println("    <td>"+availableSeatsFirst+"</td>");
                out.println("    <td>"+priceFirst+"</td>");
                out.println("    <td><button name=\"SelectedClass\" value=\"firstClass"+flightnumber+"\" type=\"submit\">Select</button></td>");
                out.println("  </tr>");
                out.println("  </form>");
                out.println("</table>");
            }
        }
        catch (SQLException ex) {
            out.println("Error extracting data from database " +ex);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

}
