import classes.DBConnect;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

import classes.Navbar;
import com.sun.org.apache.xpath.internal.objects.XNull;

@WebServlet(name = "Payment_DBupdate", urlPatterns = {"/Payment_DBupdate"})
public class Payment_DBupdate extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //statisk booking number. Skal replaces med dynamisk booking number
        String booking_number = "25";

        Connection conn;
        DBConnect dbconnect = new DBConnect();
        conn = dbconnect.connectToDB();

        String firstName, lastName, creditCard, expDate, cvc;
        firstName = request.getParameter("firstName");
        lastName = request.getParameter("lastName");
        creditCard = request.getParameter("creditCard");
        expDate = request.getParameter("expDate");
        cvc = request.getParameter("cvc");

        String str = "UPDATE Booking SET customer_paid = '0' WHERE booking_number =" +booking_number;
        try {

            if(firstName!=null && lastName!=null && creditCard!=null && expDate!=null && cvc!=null) {
                Statement stmnt = conn.createStatement();

                int query = stmnt.executeUpdate(str);

                if(query != 0) {
                    System.out.println("Database successfully updated!");
                    
                }
            }

        }

        catch (SQLException e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
