import classes.DBConnect;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet(name = "FlightDetails", urlPatterns = {"/FlightDetails"})

public class FlightDetails extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        String selectedFlight = request.getParameter("selectedFlight");

        out.println("<head>");
        out.println("<script src=\"https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.js\"></script>");
        out.println("<script src=\"scripts/searchFilter.js\"></script>");
        out.println("</head>");

        out.println("<h1>Selected flight:</h1>" +"<br/><br/>");

        Connection conn;
        DBConnect dbconnect = new DBConnect();
        conn = dbconnect.connectToDB();

        String strSelect = "SELECT * FROM Flight WHERE flight_number = "+ selectedFlight;
        String classesForFlight = "SELECT * FROM Class WHERE class_flight_fk = " + selectedFlight;

        Statement stmnt;

        try {
            stmnt = conn.createStatement();
            ResultSet rset = stmnt.executeQuery(strSelect);

            String flightnumber = null;

            if(rset.next()) {
                flightnumber = rset.getString("flight_number");
                String dateOfDeparture = rset.getString("departure_date");
                String timeOfDeparture = rset.getString("departure_time");
                String destinationAirport = rset.getString("arrival_airport");
                String departureAirport = rset.getString("departure_airport");
                String arrivalTime = rset.getString("arrival_time");

                String[] nameArray = new String[] {"flightnumber", "dateofdeparture", "timeofdeparture", "destinationAirport", "departureairport", "arrivaltime"};
                String[] valueArray = new String[] {flightnumber, dateOfDeparture, timeOfDeparture, destinationAirport, departureAirport, arrivalTime};

                int i = 0;
                for(String selected : nameArray){
                    Cookie newCookie = new Cookie(nameArray[i], valueArray[i]);
                    newCookie.setMaxAge(1800);
                    response.addCookie(newCookie);
                    i++;
                }

                out.println("Flight selected: " + selectedFlight);
                out.println("</br>Date og departure: " + dateOfDeparture);
                out.println("</br>Time of departure: " + timeOfDeparture);
                out.println("</br>Destination airport: " + destinationAirport);
                out.println("</br>Departure airport: " + departureAirport);
                out.println("</br>Arrivle time: " + arrivalTime);
                out.println("</br></br>");

                out.println("<table style=\"width:30%\" border=\"1\">");
                out.println(" <form method=\"post\" action=\"optionalServices.jsp\" id=\"flightForm\"");
                out.println("  <tr>");
                out.println("    <th>Class</th>");
                out.println("    <th>Seats</th>");
                out.println("    <th>Price</th>");
                out.println("  </tr>");
            }
            rset.close();
            ResultSet classRset = stmnt.executeQuery(classesForFlight);
            int c = 1;
            while(classRset.next()) {
                String classType = classRset.getString("class_type");
                String classCapacity = classRset.getString("class_capacity");
                String classPrice = classRset.getString("class_price");

                out.println("  <tr>");
                out.println("    <th>"+classType+"</th>");
                out.println("    <td>" + classCapacity + "</td>");
                out.println("    <td>" + classPrice + "</td>");
                out.println("    <td><button name=\"SelectedClass\" id=\""+c+"btn\" value=\"Economy" + flightnumber + "\">Select</button></td>");
                out.println("  </tr>");
                out.println("  <tr>");
                c++;
            }
            out.println("  </form>");
            out.println("</table>");
        }
        catch (SQLException ex) {
            out.println("Error extracting data from database " +ex);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

}
