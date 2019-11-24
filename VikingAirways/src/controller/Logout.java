package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * This servlet handles the input from the logout.jsp, and terminates the session of a logged in user.
 *
 * @author Markus Sveggen
 * @version 23.11.2019
 */

@WebServlet(name = "Logout", urlPatterns = {"/Logout"})
public class Logout extends HttpServlet {

    /** This servlet terminates the session of the logged in user - by altering the Session-object.
     *
     * @param request Request object received from user, currently logout.jsp
     * @param response Response object sent back to the user, currently login.jsp
     * @throws ServletException Thrown if exceptions related to calling the servlet occur
     * @throws IOException Thrown if an I/O exception of some sort has occurred
     */
    private void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String logout = request.getRequestURI();

        if (logout != null){
            try {
                HttpSession session = request.getSession(); //Gets the session object
                session.invalidate(); //Terminates the session.
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
