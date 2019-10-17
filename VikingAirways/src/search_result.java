import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import classes.*;

@WebServlet(name = "search_result", urlPatterns = {"/search_result"})
public class search_result extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Viking Airways - Cheap flights with comfort</title>");
            out.println("<script defer type=\"text/javascript\" src=\"scripts/searchFilter.js\"></script>");
            out.println("</head>");
            out.println("<body>");


            String fromAirprt = request.getParameter("fromAirport");
            String toAirprt = request.getParameter("toAirport");
            String departrDate = request.getParameter("departureDate");

            Connection conn;
            DBConnect dbconnect = new DBConnect();
            conn = dbconnect.connectToDB();

            DBDisplay dbdisplay = new DBDisplay();
            dbdisplay.displayTables(conn, out, toAirprt, departrDate, fromAirprt);

            out.println("</body>");
            out.println("</html>");

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
