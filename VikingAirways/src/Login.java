import classes.Navbar;
import classes.Validate;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;

@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        Navbar.loadNavBar(out);

        if (Validate.checkUserExistence(email, password)){
            HttpSession session = request.getSession();
            session.setAttribute("user", email);
            RequestDispatcher rs = request.getRequestDispatcher("Profile.jsp");
            rs.forward(request, response);
        }
        else {
            out.println("Email or password is incorrect. ");
            RequestDispatcher rs = request.getRequestDispatcher("login.jsp");
            rs.include(request, response);
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}