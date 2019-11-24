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
import java.util.*;


@WebServlet(name = "FlightDetails", urlPatterns = {"/FlightDetails"})

public class FlightDetails extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        String selectedFlight = request.getParameter("selectedFlight");

        //Creates arraylists for each of the database columns
        List fnum = new ArrayList();
        List ddate = new ArrayList();
        List dept = new ArrayList();
        List arra = new ArrayList();
        List depa = new ArrayList();
        List arrt = new ArrayList();
        List ctype = new ArrayList();
        List ccap = new ArrayList();
        List cprice = new ArrayList();



        //Creates a connection with the database
        Connection conn;
        DBConnect dbconnect = new DBConnect();
        conn = dbconnect.connectToDB();

        //Defines what to get from the database
        String strSelect = "SELECT * FROM Flight WHERE flight_number = " + selectedFlight;
        String strSelect2 = "SELECT * FROM Class WHERE class_flight_fk = " + selectedFlight;

        Statement stmnt;
        Statement stmnt2;

        try {
            stmnt = conn.createStatement();
            stmnt2 = conn.createStatement();

            ResultSet rset = stmnt.executeQuery(strSelect);
            ResultSet rset2 = stmnt2.executeQuery(strSelect2);


            //creates a while loop to iterate each row in the table "??"
            while (rset.next()) {
                fnum.add(rset.getInt("flight_number"));
                ddate.add(rset.getString("departure_date"));
                dept.add(rset.getString("departure_time"));
                arra.add(rset.getString("arrival_airport"));
                depa.add(rset.getString("departure_airport"));
                arrt.add(rset.getString("arrival_time"));

            }

            while (rset2.next()){
                ctype.add(rset2.getString("class_type"));
                ccap.add(rset2.getInt("class_capacity"));
                cprice.add(rset2.getInt("class_price"));
            }

            //Connects the AdminSite servlet to the adminSite jsp.
            request.getRequestDispatcher("/flightDetails.jsp").forward(request, response);

        } catch (SQLException e) {
            e.printStackTrace(/*"Error extracting data from database" +e*/);
        }

        //Creates an object of the arraylist for the .jsp to use
        request.setAttribute("flight", fnum);
        request.setAttribute("ddate", ddate);
        request.setAttribute("dept", dept);
        request.setAttribute("arra", arra);
        request.setAttribute("depa", depa);
        request.setAttribute("arrt", arrt);
        request.setAttribute("ctype", ctype);
        request.setAttribute("ccap", ccap);
        request.setAttribute("cprice", cprice);
    }
}
          /*

            if(rset.next()) {
                flightnumber = rset.getString("flight_number");
                String dateOfDeparture = rset.getString("departure_date");
                String timeOfDeparture = rset.getString("departure_time");
                String destinationAirport = rset.getString("arrival_airport");
                String departureAirport = rset.getString("departure_airport");
                String arrivalTime = rset.getString("arrival_time");

                arrivalTime = arrivalTime.substring(0, arrivalTime.length() - 3);
                timeOfDeparture = timeOfDeparture.substring(0, timeOfDeparture.length() - 3);

                String[] nameArray = new String[] {"flightnumber", "dateofdeparture", "timeofdeparture", "destinationAirport", "departureairport", "arrivaltime"};
                String[] valueArray = new String[] {flightnumber, dateOfDeparture, timeOfDeparture, destinationAirport, departureAirport, arrivalTime};

                int i = 0;
                for(String selected : nameArray){
                    Cookie newCookie = new Cookie(nameArray[i], valueArray[i]);
                    newCookie.setMaxAge(1800);
                    response.addCookie(newCookie);
                    i++;
                }
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
        }
    } catch (SQLException e) {
            e.printStackTrace("Error extracting data from database " +e);
        }

        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
/*
                (fnum)flightnumber = rset.getString("flight_number");
                (ddate)String dateOfDeparture = rset.getString("departure_date");
                (dept)String timeOfDeparture = rset.getString("departure_time");
                (arra)String destinationAirport = rset.getString("arrival_airport");
                (depa)String departureAirport = rset.getString("departure_airport");
                (arrt)String arrivalTime = rset.getString("arrival_time");
 */
        /*PrintWriter out = response.getWriter();

        String selectedFlight = request.getParameter("selectedFlight");
        out.println("<html>");
        out.println("<head>");
        out.println("<script src=\"https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.js\"></script>");
        out.println("<script src=\"scripts/searchFilter.js\"></script>");
        out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\">");
        out.println("<link rel=\"stylesheet\" href=\"stylesheets/globalStyle.css\">");
        out.println("</head>");

         */
