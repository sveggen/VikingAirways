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
            out.println("<style>");
            out.println("#table {display: table;padding: 5px; border: #000000 solid 1px;}");
            out.println(".tr {display:table-row;padding: 5px; border: #000000 solid 1px;}");
            out.println(".td {display:table-cell;padding: 5px; border: #000000 solid 1px;}");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");


            String fromAirprt = request.getParameter("fromAirport");
            String toAirprt = request.getParameter("toAirport");
            String departrDate = request.getParameter("departureDate");

            Connection conn;
            DBConnect dbconnect = new DBConnect();
            conn = dbconnect.connectToDB(out);

            DBDisplay dbdisplay = new DBDisplay();
            dbdisplay.displayTables(conn, out, toAirprt, departrDate, fromAirprt);

            out.println("</body>");
            out.println("</html>");

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
