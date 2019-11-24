package controller;

import DBConnection.DBConnect;
import model.Navbar;

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

/**
 * This servlet is responsible for connecting with the database and displaying details about the flight.
 */

@WebServlet(name = "FlightDetails", urlPatterns = {"/FlightDetails"})

public class FlightDetails extends HttpServlet {

    /**
     * Receives value from selected flight being the selected flightnumber.
     * Accesses database where all information about with this flightnumber is retrieved.
     * The selected information is stores in cookies, and ready for use elsewhere.
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        String selectedFlight = request.getParameter("selectedFlight");
        out.println("<html>");
        out.println("<head>");
        out.println("<script src=\"https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.js\"></script>");
        out.println("<script src=\"scripts/searchFilter.js\"></script>");
        out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\">");
        out.println("<link rel=\"stylesheet\" href=\"stylesheets/globalStyle.css\">");
        out.println("</head>");

        Navbar.loadNavBar(out);

        //kobler til databasen og henter ut nødvendig informasjon
        Connection conn;
        DBConnect dbconnect = new DBConnect();
        conn = dbconnect.connectToDB();

        String strSelect = "SELECT * FROM Flight WHERE flight_number = "+ selectedFlight;
        String classesForFlight = "SELECT * FROM Class WHERE class_flight_fk = " + selectedFlight;

        Statement stmnt;

        try {
            stmnt = conn.createStatement();
            ResultSet rset = stmnt.executeQuery(strSelect);

<<<<<<< HEAD
                //fjerne de siste 3 tegnene i strengene, som tilsvarer :00 da det ikke er nødvendig å se sekunder her
                ddate = ddate.substring(0, ddate.length() - 3);
                arrt = arrt.substring(0, arrt.length() - 3);

=======
            String flightnumber = null;

            if(rset.next()) {
                flightnumber = rset.getString("flight_number");
                String dateOfDeparture = rset.getString("departure_date");
                String timeOfDeparture = rset.getString("departure_time");
                String destinationAirport = rset.getString("arrival_airport");
                String departureAirport = rset.getString("departure_airport");
                String arrivalTime = rset.getString("arrival_time");

                arrivalTime = arrivalTime.substring(0, arrivalTime.length() - 3);
                timeOfDeparture = timeOfDeparture.substring(0, timeOfDeparture.length() - 3);

                //legger til cookies
                String[] nameArray = new String[] {"flightnumber", "dateofdeparture", "timeofdeparture", "destinationAirport", "departureairport", "arrivaltime"};
                String[] valueArray = new String[] {flightnumber, dateOfDeparture, timeOfDeparture, destinationAirport, departureAirport, arrivalTime};

                int i = 0;
                for(String selected : nameArray){
                    Cookie newCookie = new Cookie(nameArray[i], valueArray[i]);
                    newCookie.setMaxAge(1800);
                    response.addCookie(newCookie);
                    i++;
                }

                //skriver ut detaljert informasjon om flyvningen øverst
                out.println("<body>");
                out.println("<script defer src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js\"></script>");
                out.println("<script defer src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js\"></script>");
                // out.println("<tr>");
                out.println("<div class=\"jumbotron text-center\" >");
                out.println("<h1>Selected Flight</h1><br></div>");
                out.println("<div class=\"container text-center\" >");
                out.println("<ul class=\"list-group\">");
                out.println("<li class=\"list-group-item\"> Flight selected: <b>" + selectedFlight + "</b></li>");
                out.println("<li class=\"list-group-item\">Date og departure: <b>" + dateOfDeparture + "</b></li>");
                out.println("<li class=\"list-group-item\">Time of departure: <b>" + timeOfDeparture + "</b></li>");
                out.println("<li class=\"list-group-item\">Destination airport: <b>" + destinationAirport + "</b></li>");
                out.println("<li class=\"list-group-item\">Departure airport: <b>" + departureAirport + "</b></li>");
                out.println("<li class=\"list-group-item\">Arrival time: <b>" + arrivalTime + "</b></li>");
                out.println("</ul>");
                out.println("</br></br>");

                out.println("<table id=\"resultTable\" class=\"table table-bordered\">");
                out.println(" <form method=\"post\" action=\"optionalServices.jsp\" id=\"flightForm\"");
                out.println("<thead>");
                out.println("  <tr>");
                out.println("    <th>Class</th>");
                out.println("    <th>Available Seats</th>");
                out.println("    <th>Price</th>");
                out.println("<th></th>");
                out.println("  </tr></thead>");
                out.println("<tbody>");
>>>>>>> fc78a94758e5e0b68dd5441ab72ebf6eab1d480d
            }
            rset.close();
            ResultSet classRset = stmnt.executeQuery(classesForFlight);
            int c = 1;
            //skriver ut tabellen med klasse, pris og seter
            while(classRset.next()) {
                String classType = classRset.getString("class_type");
                String classCapacity = classRset.getString("class_capacity");
                String classPrice = classRset.getString("class_price");

                out.println("  <tr>");
                out.println("    <th>"+classType+"</th>");
                out.println("    <td>" + classCapacity + "</td>");
                out.println("    <td>" + classPrice + "</td>");
                out.println("    <td><button name=\"SelectedClass\" id=\""+ c +"btn"+"\" class=\"btn btn-success\" value=\"Economy" + flightnumber + "\">Select</button></td>");
                out.println("  </tr>");
                out.println("  <tr>");
                c++;
            }
            out.println("</tbody>");
            out.println("  </form>");
            out.println("</table>");
            out.println("</body>");
            out.println("</html>");
            conn.close();
        }
        catch (SQLException ex) {
            out.println("Error extracting data from database " +ex);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

}