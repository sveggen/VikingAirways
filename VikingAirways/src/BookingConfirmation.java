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

            String strSelect = "SELECT * FROM Customer WHERE customer_id = " + bookingNumber;
            Statement stmnt;

            if (submit.contains("submit")) {
                try {
                    stmnt = conn.createStatement();
                    ResultSet rset = stmnt.executeQuery(strSelect);

                    if (rset.next()) {
                        String firstName = rset.getString("first_name");
                        String lastName = rset.getString("last_name");
                        String departureAirport = "";
                        String arrivalAirport = "";

                        //Declare variables to be used when sending an email.
                        String recipient = "m.sveggen@gmail.com";
                        String subject = "Booking confirmation";
                        String content = "Hello " + firstName + " " + lastName + ". <br>" +
                                "Your bookingnumber is " + bookingNumber + ", for your flight from " + departureAirport +
                                " to " + arrivalAirport + "." + "<br><br>" +
                                "Have a nice flight! <br>" +
                                "<b>Viking Airways</b> <br>" +
                                "NO-4635 Kristiansand, Norway <br>" +
                                "Tel. +47 38 04 55 38 <br>";
                        //Creates an email object.
                        Email email = new Email();
                        email.sendEmail(recipient, subject, content);
                        RequestDispatcher rs = request.getRequestDispatcher("index.jsp");
                        rs.forward(request, response);
                    } else {
                        out.println("Email was not sent");
                        RequestDispatcher rs = request.getRequestDispatcher("login.jsp");
                        rs.include(request, response);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}