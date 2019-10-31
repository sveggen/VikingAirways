import classes.DBConnect;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/uploadInfo")
public class Personalinfo extends HttpServlet {


    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        // gets values of text fields
        String FirstName = request.getParameter("FirstName");
        String LastName = request.getParameter("LastName");
        String Address = request.getParameter("Address");
        String Phone = request.getParameter("Phone");
        String Email = request.getParameter("Email");
        String DateofBirth = request.getParameter("DateofBirth");

        InputStream inputStream = null; // input stream of the upload file

        // obtains the upload file part in this multipart request
        Part filePart = request.getPart("photo");
        if (filePart != null) {
            // prints out some information for debugging
            System.out.println(filePart.getName());
            System.out.println(filePart.getSize());
            System.out.println(filePart.getContentType());

            // obtains input stream of the upload file
            inputStream = filePart.getInputStream();
        }


        Connection conn; // connection to the database
        DBConnect dbconnect = new DBConnect();
        conn = dbconnect.connectToDB();

        // constructs SQL statement
        String sql = "INSERT INTO passenger (FirstName, LastName, Address, Phone, Email, DateofBirth) values (?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = null;
        try {
            statement = conn.prepareStatement(sql);
        }

        catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            statement.setString(1, FirstName);
        }

        catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            statement.setString(2, LastName);
        }

        catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            statement.setString(3, Address);
        }

        catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            statement.setString(4, Phone);
        }

        catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            statement.setString(5, Email);
        }

        catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            statement.setString(6, DateofBirth);
        }

        catch (SQLException e) {
            e.printStackTrace();
        }

        if (inputStream != null) {
            // fetches input stream of the upload file for the blob column
            try {
                statement.setBlob(3, inputStream);
            }

            catch (SQLException e) {
                e.printStackTrace();
            }
        }

        // sends the statement to the database server
        int row = 0;
        try {
            row = statement.executeUpdate();
        }

        catch (SQLException e) {
            e.printStackTrace();
        }

        finally {
            if (conn != null) {
                // closes the database connection
                try {
                    conn.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }


    }
}