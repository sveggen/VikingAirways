import classes.DBConnect;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(name = "Checkbox", urlPatterns = {"/Checkbox"})
public class Checkbox extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        ArrayList<String> nameArrayList = new ArrayList();

        // gets values of text fields
        String Extra_Luggage = request.getParameter("Checked_in_luggage");
        if(Extra_Luggage==null) {
            Extra_Luggage = new String("No");
        } else
            nameArrayList.add("extraluggage");

        String Extra_Carryon = request.getParameter("Extra_Carryon");
        if(Extra_Carryon==null) {
            Extra_Carryon = new String("No");
        } else
            nameArrayList.add("extracarryon");

        String Special_Equipment = request.getParameter("Special_Equipment");
        if(Special_Equipment==null) {
            Special_Equipment = new String("No");
        } else
            nameArrayList.add("specialequipment");

        String Pet_CarryOn = request.getParameter("Pet_CarryOn");
        if(Pet_CarryOn==null) {
            Pet_CarryOn = new String("No");
        } else
            nameArrayList.add("petcarryon");

        String Food_on_flight = request.getParameter("Food_on_flight");
        if(Food_on_flight==null) {
            Food_on_flight = new String("No");
        } else
            nameArrayList.add("foodonflight");

        String WiFi_on_flight = request.getParameter("WiFi_on_flight");
        if(WiFi_on_flight==null) {
            WiFi_on_flight = new String("No");
        } else
            nameArrayList.add("wifionflight");


        int i = 0;
        for(String selected : nameArrayList){
            response.addCookie(new Cookie(nameArrayList.get(i), "Yes"));
            i++;
        }


        Connection conn; // connection to the database
        DBConnect dbconnect = new DBConnect();
        conn = dbconnect.connectToDB();
        String message = null;  // message will be sent back to client


        RequestDispatcher req = request.getRequestDispatcher("Personalinfo.jsp");
        req.forward(request, response);
    }
}
