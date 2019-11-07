import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;import classes.DBConnect;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet(name = "CancelBooking")
public class CancelBooking extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String booking_number = request.getParameter("booking_number");
        String customer_id = request.getParameter("customer_id");
        String hasPass = request.getParameter("customer_password");

        String dlt = "DELETE FROM Booking WHERE booking_number = " + booking_number;
        String cstmrDlt = "DELETE FROM Customer, Booking WHERE customer_id = " +customer_id
                      +"AND booking_number = " +booking_number;



        Connection conn;
        DBConnect dbconnect = new DBConnect();
        conn = dbconnect.connectToDB();

        Statement stmnt;

        if (hasPass != null) {
            try {
                stmnt = conn.createStatement();
                int rset = stmnt.executeUpdate(dlt);
            }
            catch (SQLException e) {
                e.printStackTrace();
                //legg til failmessage
            }
        }

        else{
            try {
                stmnt = conn.createStatement();
                int rset = stmnt.executeUpdate(cstmrDlt);
            }
            catch (SQLException e) {
                e.printStackTrace();
                //legg til failmessage
            }
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
