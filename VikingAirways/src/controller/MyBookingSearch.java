package controller;

import DBConnection.DBConnect;
import sun.misc.Request;

import javax.servlet.RequestDispatcher;
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

@WebServlet(name = "MyBookingSearch", urlPatterns = {"/MyBookingSearch"})
public class MyBookingSearch extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int checkedInBaggage = 0;
        int customerIdFk = 0;
        int extraCarryon = 0;
        int specialEquipment = 0;
        int petCarryon = 0;
        int foodOnFlight = 0;
        int wifiOnFlight = 0;

        String firstName = null;
        String lastName = null;
        String email = null;
        String dateOfBirth = null;

        Statement statement;
        String bookingNumber = request.getParameter("bookingNumber");
        Cookie bookingCookie = new Cookie("bookingNumber", bookingNumber);
        response.addCookie(bookingCookie);
        String sqlBookingQuery = "SELECT * FROM Booking WHERE booking_number = " + bookingNumber; //SQL query to get booking details

        Connection conn;
        DBConnect dbconnect = new DBConnect();
        conn = dbconnect.connectToDB();

        try {
            statement = conn.createStatement();
            ResultSet rset = statement.executeQuery(sqlBookingQuery);

            //extract values from the ResultSet and assign to previously declared variables
            if(rset.next()) {
                checkedInBaggage = rset.getInt("checked_in_baggage");
                customerIdFk = rset.getInt("customer_id_fk");
                extraCarryon = rset.getInt("extra_carryon");
                specialEquipment = rset.getInt("special_equipment");
                petCarryon = rset.getInt("pet_carryon");
                foodOnFlight = rset.getInt("food_on_flight");
                wifiOnFlight = rset.getInt("wifi_on_flight");
            } else {
                RequestDispatcher req = request.getRequestDispatcher("/bookingNotFound.jsp");
                req.forward(request, response);
            }
            rset.close();

            String sqlCustomerQuery = "SELECT * FROM Customer WHERE customer_id = " + customerIdFk; //SQL query to get customer details
            Cookie customerIdCookie = new Cookie("customerID", Integer.toString(customerIdFk));
            response.addCookie(customerIdCookie);
            rset = statement.executeQuery(sqlCustomerQuery);
            if(rset.next()) {
                firstName = rset.getString("first_name");
                lastName = rset.getString("last_name");
                email = rset.getString("email");
                dateOfBirth = rset.getString("date_of_birth");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("checkedInBaggage", checkedInBaggage);
        request.setAttribute("customerIdFk", customerIdFk);
        request.setAttribute("extraCarryon", extraCarryon);
        request.setAttribute("specialEquipment", specialEquipment);
        request.setAttribute("petCarryon", petCarryon);
        request.setAttribute("foodOnFlight", foodOnFlight);
        request.setAttribute("wifiOnFlight", wifiOnFlight);

        request.setAttribute("firstName", firstName);
        request.setAttribute("lastName", lastName);
        request.setAttribute("email", email);
        request.setAttribute("dateOfBirth", dateOfBirth);

        RequestDispatcher rd = request.getRequestDispatcher("myBooking.jsp");
        rd.forward(request, response);



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
