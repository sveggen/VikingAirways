import classes.Validate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;


@WebServlet(name = "Register", urlPatterns = {"/Register"})
public class Register extends HttpServlet {
    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            String FirstName = request.getParameter("FirstName");
            String LastName = request.getParameter("LastName");
            String BirthDate = request.getParameter("BirthDate");
            String Password = request.getParameter("Password");
            String Email = request.getParameter("Email");

            if (!Validate.checkEmailExistence(Email)) {
                Validate.newUser(FirstName, LastName, BirthDate, Password, Email);
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
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}

