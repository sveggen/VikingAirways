package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;import DBConnection.DBConnect;
import dao.BookingDao;
import dao.MultipleTablesDao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet(name = "CancelBooking")
public class CancelBooking extends HttpServlet {
    protected void cancelBooking(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String booking_number = request.getParameter("booking_number");
        String customer_id = request.getParameter("customer_id");
        String hasPass = request.getParameter("customer_password");

        if (hasPass != null) {
            try {
                BookingDao bookingDao = new BookingDao();
                bookingDao.deleteBooking(booking_number);
            }
            catch (Exception e) {
                e.printStackTrace();
                //legg til failmessage
            }
        }
        else{
            try {
                MultipleTablesDao multipleTablesDao = new MultipleTablesDao();
                multipleTablesDao.deleteBooking(booking_number, customer_id);
            }
            catch (Exception e) {
                e.printStackTrace();
                //legg til failmessage
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        cancelBooking(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        cancelBooking(request, response);
    }
}
