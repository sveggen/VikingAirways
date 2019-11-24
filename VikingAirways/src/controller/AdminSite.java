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
import java.util.*;

@WebServlet(name = "AdminSite", urlPatterns = {"/AdminSite"})
public class AdminSite extends HttpServlet {

    /**
     *
     * @param request Defines an object to provide client request information to a servlet.
     * @param response Defines an object to assist a servlet in sending a response to the client.
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        //Creates arraylists for each of the database columns
        List flightNumber = new ArrayList();
        List ddate = new ArrayList();
        List dtime = new ArrayList();
        List aairport = new ArrayList();
        List dairport = new ArrayList();
        List atime = new ArrayList();
        List ctype = new ArrayList();
        List ccap = new ArrayList();
        List cprice = new ArrayList();
        List fk_flightnumber = new ArrayList();

        //oppretter connection med database
        Connection conn;
        DBConnect dbconnect = new DBConnect();
        conn = dbconnect.connectToDB();

        //Defines what to get from the database
        String strSelect1 = "SELECT * FROM Flight";
        String strSelect2 = "SELECT class_flight_fk, class_type, class_capacity, class_price FROM Class";

        //Contains the info from the database
        Statement stmnt1;
        Statement stmnt2;

        try {
            //Creates variables for the result
            stmnt1 = conn.createStatement();
            stmnt2 = conn.createStatement();
            ResultSet rset1 = stmnt1.executeQuery(strSelect1);
            ResultSet rset2 = stmnt2.executeQuery(strSelect2);

            //creates a while loop to iterate each row in the table "Flight"
            while (rset1.next()) {
                flightNumber.add(rset1.getInt("flight_number"));
                ddate.add(rset1.getString("departure_date"));
                dtime.add(rset1.getString("departure_time"));
                aairport.add(rset1.getString("arrival_airport"));
                dairport.add(rset1.getString("departure_airport"));
                atime.add(rset1.getString("arrival_time"));
            }

            //creates a while loop to iterate each row in the table "Class"
            while (rset2.next()) {
                ctype.add(rset2.getString("class_type"));
                ccap.add(rset2.getInt("class_capacity"));
                cprice.add(rset2.getInt("class_price"));
                fk_flightnumber.add(rset2.getInt("class_flight_fk"));
            }



        } catch (SQLException e)
        {
            e.printStackTrace();
        }

        //Creates an object of the arraylist for the .jsp to use
        request.setAttribute("flight", flightNumber);
        request.setAttribute("ddate", ddate);
        request.setAttribute("dtime", dtime);
        request.setAttribute("aairport", aairport);
        request.setAttribute("dairport", dairport);
        request.setAttribute("atime", atime);
        request.setAttribute("ctype", ctype);
        request.setAttribute("ccap", ccap);
        request.setAttribute("cprice", cprice);
        request.setAttribute("fk_flightnumber", fk_flightnumber);

        //Connects the AdminSite servlet to the adminSite jsp.
        request.getRequestDispatcher("/adminSite.jsp").forward(request, response);
        }
    }

