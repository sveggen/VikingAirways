package controller;

import dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * This servlet handles the input from register.jsp, and adds a new user to the database.
 *
 * @author Markus Sveggen
 * @version 23.11.2019
 */

@WebServlet(name = "Register", urlPatterns = {"/Register"})
public class Register extends HttpServlet {
    private void createUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            String FirstName = request.getParameter("FirstName");
            String LastName = request.getParameter("LastName");
            String BirthDate = request.getParameter("BirthDate");
            String Password = request.getParameter("Password");
            String Email = request.getParameter("Email");

            UserDao userdao = new UserDao();
            if (!userdao.checkEmailExistence(Email)) {
                userdao.newUser(FirstName, LastName, BirthDate, Password, Email);
                response.sendRedirect("registrationSuccessful.jsp");
            } else {
                request.setAttribute("errorMessage", "Email is already in use, account was not created");
                request.getRequestDispatcher("/register.jsp").forward(request, response);
            }
        } catch (IOException | ServletException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        createUser(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        createUser(request, response);
    }
}

