import classes.DBConnect;
import classes.Validate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


@WebServlet(name = "Register", urlPatterns = {"/Register"})
public class Register extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            String FirstName = request.getParameter("FirstName");
            String LastName = request.getParameter("LastName");
            String BirthDate = request.getParameter("BirthDate");
            String Password = request.getParameter("Password");
            String Email = request.getParameter("Email");

            Connection conn;
            DBConnect dbconnect = new DBConnect();
            conn = dbconnect.connectToDB();

            if (!Validate.checkEmailExistence(Email)) {
                newUser(FirstName, LastName, BirthDate, Password, Email, out, conn);
                response.sendRedirect("RegistrationSuccessful.jsp");
            }else{
                request.setAttribute("errorMessage", "Email is already in use, account was not created");
                request.getRequestDispatcher("/Register.jsp").forward(request, response);
            }
        }
    }

    public void newUser(String FirstName, String LastName, String BirthDate, String Password, String Email, PrintWriter out, Connection conn) {
        PreparedStatement insertUserInfo;
        try {
            String ins = "insert into vikingairways_db.Customer (first_name, last_name, date_of_birth, customer_password, email, account_created, loyalty_points, admin_priv)  values (?, ?, ?, ?, ?, NOW(), 0, false)";

            insertUserInfo = conn.prepareStatement(ins);
            insertUserInfo.setString(1, FirstName);
            insertUserInfo.setString(2, LastName);
            insertUserInfo.setString(3, BirthDate);
            insertUserInfo.setString(4, Password);
            insertUserInfo.setString(5, Email);
            insertUserInfo.executeUpdate();
            System.out.println("Ny bruker opprettet");
        } // end try
        catch (SQLException ex) {
            out.println("Ikke fått lagret navn" + ex);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}

