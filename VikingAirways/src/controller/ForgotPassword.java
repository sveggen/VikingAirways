package controller;

import dao.UserDao;
import model.GeneratePassword;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * This servlet handles the input and output of the profile.jsp for logged in users,
 * and makes it possible for the users to change password and list all the users bookings.
 *
 * @author Markus Sveggen
 * @version 23.11.2019
 */

@WebServlet(name = "ForgotPassword", urlPatterns = {"/ForgotPassword"})
public class ForgotPassword extends HttpServlet {
    private void generatePassword(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=UTF-8");

        String email = request.getParameter("email");
        String tmppass = GeneratePassword.generateTempPass();

        UserDao userDao = new UserDao();

        try{
            if (userDao.checkEmailExistence(email)){
                userDao.changePassword(tmppass, email);

                GeneratePassword gp = new GeneratePassword();
                gp.sendEmail(email);

                request.setAttribute("successMessage", "Password was succesfully reset, please check your mail inbox.");
            }else{
                request.setAttribute("errorMessage", "Password was not reset. Email does not exist.");
            }
            request.getRequestDispatcher("/forgotPassword.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("emailCatch", "Email-server error. Email could not be sent.");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        generatePassword(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        generatePassword(request, response);
    }
}
