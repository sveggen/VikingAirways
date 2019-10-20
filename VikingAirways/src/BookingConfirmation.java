import classes.DBConnect;
import classes.Email;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.sql.Connection;

@WebServlet(name = "BookingConfirmation", urlPatterns = {"/BookingConfirmation"})
public class BookingConfirmation extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            //Hent data fra form:
            String bookingNumber = request.getParameter("bookingNumber");

            String submit = request.getParameter("submit");

            //Koble til database
            Connection conn;
            DBConnect dbconnect = new DBConnect();
            conn = dbconnect.connectToDB();

            if (submit.contains("submit")) {

                try {
                    //Hent data fra database
                    PreparedStatement ps = conn.prepareStatement("SELECT first_name FROM vikingairways_db.Customer WHERE customer_id=?;");
                    ps.setString(1, bookingNumber);
                    ResultSet name = ps.executeQuery();

                    Email email = new Email();
                    String recipient = "m.sveggen@gmail.com";
                    String subject = "Booking confirmation";
                    String content = "Hi, your bookingnumber is " + bookingNumber + ".";

                    email.sendEmail(recipient, subject, content);
                    RequestDispatcher rs = request.getRequestDispatcher("Welcome");
                    rs.forward(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                } {

                }
            } else {
                out.println("Email was not sent");
                RequestDispatcher rs = request.getRequestDispatcher("login.jsp");
                rs.include(request, response);
            }
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}
