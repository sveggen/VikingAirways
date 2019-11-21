package controller;

import DBConnection.DBConnect;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet(name = "MyBookingUpdate", urlPatterns = {"/MyBookingUpdate"})
public class MyBookingUpdate extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Cookie[] cookies = request.getCookies();
        int bookingNumber = 0;
        for (Cookie cookie : cookies) {
            if ((cookie == null) || (cookie.getName() == null)) {
                continue;
            }
            if (cookie.getName().equals("bookingNumber")) {
                bookingNumber = Integer.parseInt(cookie.getValue());
            }
        }

        String firstName = request.getParameter("FirstName");
        String lastName = request.getParameter("LastName");
        String email = request.getParameter("Email");
        String dateOfBirth = request.getParameter("DateOfBirth");

        String checkedInLuggage = request.getParameter("Checked_in_Luggage");
        if(checkedInLuggage == null) {checkedInLuggage = "0";}
        String extraCarryon = request.getParameter("Extra_Carryon");
        if(extraCarryon == null) {extraCarryon = "0";}
        String specialEquipment = request.getParameter("Special_Equipment");
        if(specialEquipment == null) {specialEquipment = "0";}
        String petCarryon = request.getParameter("Pet_CarryOn");
        if(petCarryon == null) {petCarryon = "0";}
        String foodOnFlight = request.getParameter("Food_on_flight");
        if(foodOnFlight == null) {foodOnFlight = "0";}
        String wifiOnFlight = request.getParameter("WiFi_on_flight");
        if(wifiOnFlight == null) {wifiOnFlight = "0";}

        PreparedStatement statement;
        Connection conn;
        DBConnect dbconnect = new DBConnect();
        conn = dbconnect.connectToDB();

        String sqlQuery = "UPDATE Customer, Booking SET Customer.first_name = '"+firstName+"', Customer.last_name = '"+lastName+"', Customer.email = '"+email+"', Customer.date_of_birth= '"+dateOfBirth+"', " +
                          "Booking.checked_in_baggage = '"+checkedInLuggage+"', Booking.extra_carryon = '"+extraCarryon+"', Booking.special_equipment= '"+specialEquipment+"', " +
                          "Booking.pet_carryon = '"+petCarryon+"', Booking.food_on_flight= '"+foodOnFlight+"'," +
                          "Booking.wifi_on_flight = '"+wifiOnFlight+"' WHERE Booking.booking_number = '" + bookingNumber + "' AND Booking.customer_id_fk = Customer.customer_id;";

        try {
            statement = conn.prepareStatement(sqlQuery);

            int exc = 0;
            if(bookingNumber > 0)
                exc = statement.executeUpdate();

            conn.close();
            if(exc > 0) {
                request.setAttribute("rowsUpdated", exc);
                RequestDispatcher req = request.getRequestDispatcher("bookingUpdateSuccess.jsp");
                req.forward(request, response);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
