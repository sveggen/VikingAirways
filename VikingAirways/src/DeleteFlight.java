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

            String dlFlight = "delete from Flight where flight_number=(?);";
            String dlClass = "delete from Class where class_flight_fk=(?);";

            try (PreparedStatement dlClassStmt = conn.prepareStatement(dlClass)) {
                dlClassStmt.setString(1, selectedFlight);
                int i = dlClassStmt.executeUpdate();
                System.out.println("Number of entries updated in class: " + i);

                PreparedStatement dlFlightstmt = conn.prepareStatement(dlFlight);
                dlFlightstmt.setString(1, selectedFlight);
                int v = dlFlightstmt.executeUpdate();
                System.out.println("Number of entries updated in flight: " + v);
            } catch (SQLException ex) {
                out.println("Cannot remove flight: " + selectedFlight + " because there are bookings connected " +
                        "to this flight that are not cancelled.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
