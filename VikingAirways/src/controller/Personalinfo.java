package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Makes textfields for personal information and stores the information in cookies
 */

@WebServlet(name = "/Personalinfo", urlPatterns = {"/Personalinfo"})
public class Personalinfo extends HttpServlet {
    protected void personalInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        // gets values of text fields
        String firstName = request.getParameter("FirstName");
        String lastName = request.getParameter("LastName");
        String email = request.getParameter("Email");
        String dateofBirth = request.getParameter("DateofBirth");

        //Creates arrays to use for the cookies
        String[] nameArray = new String[] {"firstname", "lastname", "email", "dateofBirth"};
        String[] valueArray = new String[] {firstName, lastName, email, dateofBirth};

        // Creates cookies to store the information inputted by the user.
        int i = 0;
        for(String selected : nameArray){
            response.addCookie(new Cookie(nameArray[i], valueArray[i]));
            i++;
        }
        RequestDispatcher req = request.getRequestDispatcher("payment.jsp");
        req.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        personalInfo(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        personalInfo(request, response);
    }
}