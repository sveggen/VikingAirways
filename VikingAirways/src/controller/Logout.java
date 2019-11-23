package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * This servlet handles the input and output of the profile.jsp for logged in users,
 * and makes it possible for the users to change password and list all the users bookings.
 *
 * @author Markus Sveggen
 * @version 23.11.2019
 */

@WebServlet(name = "Logout", urlPatterns = {"/Logout"})
public class Logout extends HttpServlet {
    private void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String logout = request.getRequestURI();

        if (logout != null){
            try {
                HttpSession session = request.getSession();
                session.invalidate();
                response.sendRedirect("login.jsp");
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        logout(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        logout(request, response);
    }
}
