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

            conn.setAutoCommit(false);
            try (PreparedStatement dlFlightStmt = conn.prepareStatement(dlFlight)) {
                dlFlightStmt.setString(1, selectedFlight);
                dlFlightStmt.executeUpdate();
                try (PreparedStatement dlClassstmt = conn.prepareStatement(dlClass)) {
                    dlClassstmt.setString(1, selectedFlight);
                    dlClassstmt.executeUpdate();
                    conn.commit();
                }
            } catch (Exception e) {
                conn.rollback();
            }
        } catch (SQLException ex) {
            System.out.println("Cannot remove flight " + ex);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
