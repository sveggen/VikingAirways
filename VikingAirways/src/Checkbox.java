import classes.DBConnect;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet(name = "Checkbox", urlPatterns = {"/Checkbox"})
@MultipartConfig(maxFileSize = 16177215)    // upload file's size up to 16MB
public class Checkbox extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        // gets values of text fields
        String Extra_Luggage = request.getParameter("Extra_Luggage");
        if(Extra_Luggage==null) {
            Extra_Luggage = new String("No");
        }
        String Extra_Carryon = request.getParameter("Extra_Carryon");
        if(Extra_Carryon==null) {
            Extra_Carryon = new String("No");
        }
        String Overweight_Luggage = request.getParameter("Overweight_Luggage");
        if(Overweight_Luggage==null) {
            Overweight_Luggage = new String("No");
        }
        String Sport_Equipment = request.getParameter("Sport_Equipment");
        if(Sport_Equipment==null) {
            Sport_Equipment = new String("No");
        }
        String Digital_Equipment = request.getParameter("Digital_Equipment");
        if(Digital_Equipment==null) {
            Digital_Equipment = new String("No");
        }
        String Pet_CarryOn = request.getParameter("Pet_CarryOn");
        if(Pet_CarryOn==null) {
            Pet_CarryOn = new String("No");
        }
        String Food_on_flight = request.getParameter("Food_on_flight");
        if(Food_on_flight==null) {
            Food_on_flight = new String("No");
        }
        String WiFi_on_flight = request.getParameter("WiFi_on_flight");
        if(WiFi_on_flight==null) {
            WiFi_on_flight = new String("No");
        }

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
        String message = null;  // message will be sent back to client

        try {
            // connects to the database
            //DriverManager.registerDriver(new com.mysql.jdbc.Driver());

            // constructs SQL statement
            String sql = "INSERT INTO Optionalservices (Extra_Luggage, Extra_Carryon, Overweight_Luggage, Sport_Equipment, Digital_Equipment, Pet_CarryOn, Food_on_flight, WiFi_on_flight) VALUES (? ,? ,? ,? ,? ,? ,? ,? )";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, Extra_Luggage);
            statement.setString(2, Extra_Carryon);
            statement.setString(3, Overweight_Luggage);
            statement.setString(4, Sport_Equipment);
            statement.setString(5, Digital_Equipment);
            statement.setString(6, Pet_CarryOn);
            statement.setString(7, Food_on_flight);
            statement.setString(8, WiFi_on_flight);


            if (inputStream != null) {
                // fetches input stream of the upload file for the blob column
                statement.setBlob(3, inputStream);
            }

            // sends the statement to the database server
            int row = statement.executeUpdate();
            if (row > 0) {
                message = "File uploaded and saved into database";
            }
        } catch (SQLException ex) {
            message = "ERROR: " + ex.getMessage();
            ex.printStackTrace();
        } finally {
            if (conn != null) {
                // closes the database connection
                try {
                    conn.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            // sets the message in request scope
            request.setAttribute("Message", message);

            // forwards to the message page
            try {
                getServletContext().getRequestDispatcher("Message.jsp").forward(request, response);

            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
    }
}
