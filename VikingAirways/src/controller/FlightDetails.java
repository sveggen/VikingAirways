package controller;

import DBConnection.DBConnect;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

/**
 *  This servlet displays flight information based on choices made in SearchResult and
 *  passes this information on to flightDetails.jsp
 *
 * @author Kirsti Næsset
 * @author Magnus Neergaard
 * @version 24.11.2019
 *
 */

@WebServlet(name = "FlightDetails", urlPatterns = {"/FlightDetails"})

public class FlightDetails extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        String selectedFlight = request.getParameter("selectedFlight");

        //Creates strings for each flight detail
        String fnum = null;
        String ddate = null;
        String dept = null;
        String arra = null;
        String depa = null;
        String arrt = null;

        //Creates Arraylist for each airline class, price and capacity
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
            if (rset.next()) {
                fnum = rset.getString("flight_number");
                ddate = rset.getString("departure_date");
                dept = rset.getString("departure_time");
                arra = rset.getString("arrival_airport");
                depa = rset.getString("departure_airport");
                arrt = rset.getString("arrival_time");

                //fjerne de siste 3 tegnene i strengene, som tilsvarer :00 da det ikke er nødvendig å se sekunder her
                ddate = ddate.substring(0, ddate.length() - 3);
                arrt = arrt.substring(0, arrt.length() - 3);

            }

            //creates arrays to store cookies
            String[] nameArray = new String[] {"flightnumber", "dateofdeparture", "timeofdeparture", "destinationAirport", "departureairport", "arrivaltime"};
            String[] valueArray = new String[] {fnum, ddate, dept, arra, depa, arrt};

            int i = 0;
            for(String selected : nameArray){
                Cookie newCookie = new Cookie(nameArray[i], valueArray[i]);
                newCookie.setMaxAge(1800);
                response.addCookie(newCookie);
                i++;
            }
            //iterates through the ResultSet
            while (rset2.next()){
                ctype.add(rset2.getString("class_type"));
                ccap.add(rset2.getInt("class_capacity"));
                cprice.add(rset2.getInt("class_price"));
            }

        } catch (SQLException e) {
            e.printStackTrace(/*"Error extracting data from database" +e*/);
        }

        //Creates an object of each string/arraylist for the .jsp to use
        request.setAttribute("flight", fnum);
        request.setAttribute("ddate", ddate);
        request.setAttribute("dept", dept);
        request.setAttribute("arra", arra);
        request.setAttribute("depa", depa);
        request.setAttribute("arrt", arrt);

        request.setAttribute("ctype", ctype);
        request.setAttribute("ccap", ccap);
        request.setAttribute("cprice", cprice);

        //Connects the AdminSite servlet to the adminSite jsp.
        request.getRequestDispatcher("/flightDetails.jsp").forward(request, response);
    }

}
