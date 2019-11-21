package controller;

import dao.FlightDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteFlight", urlPatterns = {"/DeleteFlight"})
public class DeleteFlight extends HttpServlet {
    private void deleteFlight(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            String selectedFlight = request.getParameter("flightnumber");
            FlightDao flightDao = new FlightDao();
            flightDao.deleteFlight(selectedFlight);

        } catch (Exception e) {
            e.printStackTrace();
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
