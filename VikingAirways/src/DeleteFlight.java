import classes.DBConnect;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet(name = "DeleteFlight", urlPatterns = {"/DeleteFlight"})
public class DeleteFlight extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        Connection conn;
        DBConnect dbconnect = new DBConnect();
        conn = dbconnect.connectToDB();


        try {
            String selectedFlight = request.getParameter("flightnumber");

            String strSelect = "delete from Flight where flight_number= "+selectedFlight+"";

            PreparedStatement stmt = conn.prepareStatement(strSelect);

            int i = stmt.executeUpdate();

            
        }
        catch (SQLException ex) {
            out.println("Cannot remove flight " +ex);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
