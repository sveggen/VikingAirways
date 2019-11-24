package controller;

import dao.FlightDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * This servlet is responsible for deleting flights from the database using admin user account.
 */

@WebServlet(name = "DeleteFlight", urlPatterns = {"/DeleteFlight"})

public class DeleteFlight extends HttpServlet {

    /**
     * Connects with the database and runs a query to delete classes and flight with the given flightnumber
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */

    private void deleteFlight(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // connecter med databasen og kjører query som sletter klasser og flygning med gitt flightnumber
            String selectedFlight = request.getParameter("flightnumber");
            FlightDao flightDao = new FlightDao();
            flightDao.deleteFlight(selectedFlight);

            request.setAttribute("flightDeleted", "Flight was successfully deleted.");
            request.getRequestDispatcher("/deleteFlight.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("flightNotDeleted", "Flight could not be deleted. ");
            request.getRequestDispatcher("/deleteFlight.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        deleteFlight(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        deleteFlight(request, response);
    }
}
