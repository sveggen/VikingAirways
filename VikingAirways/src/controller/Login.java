package controller;

import dao.UserDao;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.util.HashMap;

/**
 * This servlet handles the input from the login.jsp, and creates a session for a user,
 * after the user has typed in their credentials.
 *
 * @author Markus Sveggen
 * @version 3.11.2019
 */

@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

    /** This method logs the user into the system if the tped in credentials match with an existing user in
     * the DB. It also passes appropriate variables to the Session-object.
     *
     * @param request Request object received from user, currently login.jsp
     * @param response Response object sent back to the user, currently profile.jsp or login.jsp
     * @throws ServletException Thrown if exceptions related to calling the servlet occur
     * @throws IOException Thrown if an I/O exception of some sort has occurred
     */
    private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        //Creates a instance of the UserDao in order to retrieve data from the DB.
        UserDao userDao = new UserDao();

        try {
            //Uses an external method to check whether the user exists in the DB.
            if (userDao.checkUserExistence(email, password)) {
                //calls the getPersonalData-method and creates a new HM with the returning data from the method.
                HashMap<String, Object> kv = userDao.getPersonalData(email);

                //Creates a new session and passes the following parameters (from the HM) to the Session-object.
                HttpSession session = request.getSession();
                session.setAttribute("email", email);
                session.setAttribute("password", password);
                session.setAttribute("firstname", kv.get("firstname"));
                session.setAttribute("lastname", kv.get("lastname"));
                session.setAttribute("userID", kv.get("userid"));
                session.setAttribute("dateOfBirth", kv.get("dateofbirth"));
                session.setAttribute("adminPriv", kv.get("adminpriv"));

                //Redirects the user to the profile.jsp if login is successful.
                response.sendRedirect("profile.jsp");
            } else {
                //Displays error message if user does not exist.
                request.setAttribute("errorMessage", "Login unsuccessful. Password or email was wrong.");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
        } catch (IOException | ServletException e) {
            e.printStackTrace();
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        login(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        login(request, response);
    }
}
