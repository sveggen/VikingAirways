package controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import com.itextpdf.text.*;

import model.*;

/**
 * This servlet handles a request from checkIn.jsp.
 * It gets the booking number entered, sets the path where the PDF should be stored
 * and passes this as parameters to BoardingPassPDF to generated the PDF.
 * Finally it gets the name of the PDF and forwarrds this to showBoardingPass.jsp
 *
 * @author Jørgen Lindbøl
 * @version 24.11.2019
 */
@WebServlet(name = "BoardingPass", urlPatterns = {"/BoardingPass"})
public class BoardingPass extends HttpServlet {

    /**
     * Standard Servlet method to handle a post request.
     * Gets the booking number passed through the request object,
     * gets the path to PDF storage location and calls on BoardingPassPDF
     * to generated the PDF. Forwards to showBoardingPass.jsp.
     *
     * @param request Request object received from user, currently checkIn.jsp
     * @param response Response object sent back to the user, currently showBoardingPass.jsp
     * @throws IOException Thrown if an I/O exception of some sort has occurred
     * @throws ServletException Thrown if exceptions related to calling the servlet occur
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String fileName;

        String bookingNumber = request.getParameter("bookingNumber");

        String tomcatPath = request.getServletContext().getRealPath("/boardingpasses");


        BoardingPassPDF pdffunc = new BoardingPassPDF();
        pdffunc.makePDF(bookingNumber, tomcatPath);
        fileName = pdffunc.getFileName();

        request.setAttribute("fileName", fileName);

        String nextJSP = "/showBoardingPass.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        dispatcher.forward(request,response);
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
    }
}
