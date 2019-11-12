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
            HttpSession session = request.getSession();
            session.setAttribute("user", email);
            response.sendRedirect("Profile.jsp");
        } else {
            request.setAttribute("errorMessage", "Login unsuccessful. Password or email was wrong.");
            request.getRequestDispatcher("/Login.jsp").forward(request, response);
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
