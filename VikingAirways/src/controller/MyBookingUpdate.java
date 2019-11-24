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

/**
 * This class is responsible for updating the database with the data the user has entered.
 * It takes all input from myBooking.jsp, puts them into a SQL statement and runs it on
 * the database, then forwards the user to bookingUpdateSuccess.jsp
 *
 * @author Jorgen Lindbol
 * @version 24.11.2019
 */
@WebServlet(name = "MyBookingUpdate", urlPatterns = {"/MyBookingUpdate"})
public class MyBookingUpdate extends HttpServlet {

    /**
     * Responsible for updating the dabatase with the new information entered
     * by the user.
     *
     * @param request A request object from the Servlet calling this method
     * @param response A response object from the Servlet calling this method
     * @throws ServletException Thrown if exceptions related to calling the servlet occur
     * @throws IOException Thrown if an I/O exception of some sort has occurred
     */
    protected void updateBooking(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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

    /**
     * Standard servlet Get method called if specified in connecting Form.
     * Not currently used in this project.
     *
     * @param request Request object received from user
     * @param response Response object returned to user
     * @throws ServletException Thrown if exceptions related to calling the servlet occur
     * @throws IOException Thrown if an I/O exception of some sort has occurred
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        updateBooking(request, response);
    }

    /**
     * Standard servlet Post method called if specified in connecting Form.
     * In this system, currently this is called from myBooking.jsp.
     *
     * @param request Request object received from user
     * @param response Response object returned to user
     * @throws ServletException Thrown if exceptions related to calling the servlet occur
     * @throws IOException Thrown if an I/O exception of some sort has occurred
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        updateBooking(request, response);
    }
}
