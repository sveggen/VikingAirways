import classes.UserData;
import classes.Validate;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;

@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if (Validate.checkUserExistence(email, password)){
            UserData ud = new UserData();
            ud.getPersonalData(email);

            HttpSession session = request.getSession();
            session.setAttribute("email", email);
            session.setAttribute("password", password);
            session.setAttribute("firstname", ud.getFirstname());
            session.setAttribute("lastname", ud.getLastname());
            session.setAttribute("customerID", ud.getCustomerID());
            session.setAttribute("dateOfBirth", ud.getDateOfBirth());


            response.sendRedirect("profile.jsp");
        } else {
            request.setAttribute("errorMessage", "Login unsuccessful. Password or email was wrong.");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
