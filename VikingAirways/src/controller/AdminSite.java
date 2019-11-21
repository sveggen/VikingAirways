package controller;

import DBConnection.DBConnect;
import model.Navbar;

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

@WebServlet(name = "AdminSite", urlPatterns = {"/AdminSite"})
public class AdminSite extends HttpServlet {
    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        Navbar.loadNavBar(out);

        out.println("<head>");
        out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\">");
        out.println("</head>");
        out.println("<h1>Admin page</h1>" +"<br/><br/>");

        //oppretter connection med database
        Connection conn;
        DBConnect dbconnect = new DBConnect();
        conn = dbconnect.connectToDB();

        //Gjør klart hva som skal hentes ut av databasen
        String strSelect = "SELECT * FROM Flight";

        //holder denne infoen
        Statement stmnt;


        try {
            //oppretter varriabel for resultatet
            stmnt = conn.createStatement();
            ResultSet rset = stmnt.executeQuery(strSelect);

            out.println("<table style=\"width:30%\" border=\"1\">");
            out.println("  <tr>");
            out.println("    <th>Flight number</th>");
            out.println("    <th>Departure date</th>");
            out.println("    <th>Departure airport</th>");
            out.println("    <th>Arrival airport</th>");
            out.println("    <th>Departure time</th>");
            out.println("    <th>Arrival time</th>");
            out.println("  </tr>");

            while(rset.next()) {
                int flightnumber = rset.getInt("flight_number");
                String dateOfDeparture = rset.getString("departure_date");
                String timeOfDeparture = rset.getString("departure_time");
                String destinationAirport = rset.getString("arrival_airport");
                String departureAirport = rset.getString("departure_airport");
                String arrivalTime = rset.getString("arrival_time");
/*
                int availableSeatsEcon = rset.getInt("available_seats_economy");
                int availableSeatsBusi = rset.getInt("available_seats_business");
                int availableSeatsFirst = rset.getInt("available_seats_firstclass");
                int priceEcon = rset.getInt("price_economy");
                int priceBusi = rset.getInt("price_business");
                int priceFirst = rset.getInt("price_firstclass");

*/
                out.println("  <tr>");
                out.println("    <td>"+flightnumber+"</td>");
                out.println("    <td>"+dateOfDeparture+"</td>");
                out.println("    <td>"+departureAirport+"</td>");
                out.println("    <td>"+destinationAirport+"</td>");
                out.println("    <td>"+timeOfDeparture+"</td>");
                out.println("    <td>"+arrivalTime+"</td>");
                out.println("  </tr>");
            }

            out.println("</table>");
        }
        catch (SQLException ex) {
            out.println("Error extracting data from database " +ex);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}
