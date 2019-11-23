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

@WebServlet(name = "BoardingPass", urlPatterns = {"/BoardingPass"})
public class BoardingPass extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        PrintWriter out = response.getWriter();
        String fileName;

        String bookingNumber = request.getParameter("bookingNumber");

        String tomcatPath = request.getServletContext().getRealPath("/boardingpasses");

        //out.println("Your booking number is: " + bookingNumber);

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
