package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import dao.BookingDao;

/**
 * This servlet is used to delete a booking and/or a customerID.
 *
 * @author magnusneergaard
 * @version 24.11.2019
 */


@WebServlet(name = "CancelBooking", urlPatterns = {"/CancelBooking"})
public class CancelBooking extends HttpServlet {

    BookingDao bookingDao = new BookingDao();

    private void cancelBooking(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //Gets parameters and stores them in a string
        String booking_number = request.getParameter("bookingNumber");
        String customer_id = request.getParameter("customer_id");
        String hasPass = request.getParameter("customer_password");

        //Checks if the user has a password, and deletes the booking if not
        if (hasPass != null) {
            try {
                bookingDao.deleteBooking(booking_number);
            }

            catch (Exception e) {
                e.printStackTrace();
            }
        }

        //Deletes booking and customerID if the customer has no password
        else{
            try {
                bookingDao.deleteBookingandCustomerID(booking_number, customer_id);
            }
            catch (Exception e) {
                e.printStackTrace();
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
