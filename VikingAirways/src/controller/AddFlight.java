package controller;

import DBConnection.DBConnect;
import dao.FlightDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet(name = "AddFlight", urlPatterns = {"/AddFlight"})
public class AddFlight  extends HttpServlet {

    /**
     * Records the contents of the input of the .jsp, and directly uploads it into
     * the database in the correct tables and columns.
     * addClass and addFlight is an extension of the same methods in the FlightDao servlet.
     */

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        // gets values of text fields
        String flight_number = request.getParameter("flight_number");
        String departure_date = request.getParameter("departure_date");
        String departure_time = request.getParameter("departure_time");
        String arrival_airport = request.getParameter("arrival_airport");
        String departure_airport = request.getParameter("departure_airport");
        String arrival_time = request.getParameter("arrival_time");
        String class_type1 = request.getParameter("class_type1");
        String class_capacity1 = request.getParameter("class_capacity1");
        String class_price1 = request.getParameter("class_price1");
        String class_flight_fk1 = request.getParameter("class_flight_fk1");
        String class_type2 = request.getParameter("class_type2");
        String class_capacity2 = request.getParameter("class_capacity2");
        String class_price2 = request.getParameter("class_price2");
        String class_flight_fk2 = request.getParameter("class_flight_fk2");
        String class_type3 = request.getParameter("class_type3");
        String class_capacity3 = request.getParameter("class_capacity3");
        String class_price3 = request.getParameter("class_price3");
        String class_flight_fk3 = request.getParameter("class_flight_fk3");

        try {
            //Gets the methods in FlightDao and initializes them to upload the inputs to the database
            FlightDao flightdao = new FlightDao();
            flightdao.addFlight(flight_number, departure_date, departure_time, arrival_airport, departure_airport, arrival_time);
            flightdao.addClass(class_type1, class_capacity1, class_price1, class_flight_fk1);
            flightdao.addClass(class_type2, class_capacity2, class_price2, class_flight_fk2);
            flightdao.addClass(class_type3, class_capacity3, class_price3, class_flight_fk3);

        }

        catch (Exception e) {
            e.printStackTrace();
        }
        }
    }