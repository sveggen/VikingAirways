package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import model.*;
import DBConnection.DBConnect;

/**
 * This servlet handles connection to the database to retrieve details about
 * all flights that fit the parameters specified by the user in index.jsp
 *
 * @author Jørgen Lindbøl
 * @version 24.11.2019
 */
@WebServlet(name = "SearchResult", urlPatterns = {"/SearchResult"})
public class SearchResult extends HttpServlet {

    /**
     * This class processes the request from index.jsp.
     * It writes HTML directly through the PrintWriter from the response object
     * and calls on the DBDislay class to print the table with information from
     * the database.
     *
     * @param request Request object received from the user, currently index.jsp
     * @param response Response object sent back to the user, currently displayed directly without dedicated jsp/html file
     * @throws ServletException Thrown if exceptions related to calling the servlet occur
     * @throws IOException Thrown if an I/O exception of some sort has occurred
     */
    protected void searchResult(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Viking Airways - Cheap flights with comfort</title>");
            out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\">");
            out.println("<link rel=\"stylesheet\" href=\"stylesheets/globalStyle.css\">");
            out.println("<script src=\"https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.js\"></script>");
            out.println("<script src=\"scripts/searchFilter.js\"></script>");
            out.println("</head>");
            out.println("<body>");

            Navbar.loadNavBar(out);

            String fromAirprt = request.getParameter("fromAirport");
            String toAirprt = request.getParameter("toAirport");
            String departrDate = request.getParameter("departureDate");

            Connection conn;
            DBConnect dbconnect = new DBConnect();
            conn = dbconnect.connectToDB();

            DBDisplay dbdisplay = new DBDisplay();
            dbdisplay.displayTables(conn, out, toAirprt, departrDate, fromAirprt);

            out.println("<script defer src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js\"></script>");
            out.println("<script defer src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js\"></script>");

            out.println("</body>");
            out.println("</html>");
        }
    }

    /**
     * Standard servlet Post method called if specified in connecting Form.
     * Used in this project to handle request from index.jsp
     *
     * @param request Request object received from user
     * @param response Response object received from user
     * @throws ServletException Thrown if exceptions related to calling the servlet occur
     * @throws IOException Thrown if an I/O exception of some sort has occurred
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        searchResult(request, response);
    }

    /**
     * Standard servlet Get method called if specified in connecting Form.
     *
     * @param request Request object received from user
     * @param response Response object received from user
     * @throws ServletException Thrown if exceptions related to calling the servlet occur
     * @throws IOException Thrown if an I/O exception of some sort has occurred
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        searchResult(request, response);
    }
}
