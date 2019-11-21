package controller;

import dao.UserDao;
import model.UserData;

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

        UserDao userDao = new UserDao();

        try {
            if (userDao.checkUserExistence(email, password)) {
                UserData ud = new UserData();
                ud.getPersonalData(email);

                HttpSession session = request.getSession();
                session.setAttribute("email", email);
                session.setAttribute("password", password);
                session.setAttribute("firstname", ud.getFirstname());
                session.setAttribute("lastname", ud.getLastname());
                session.setAttribute("userID", ud.getUserID());
                session.setAttribute("dateOfBirth", ud.getDateOfBirth());
                session.setAttribute("adminPriv", ud.getAdminPriv());

                String referrer = request.getHeader("referer");
                System.out.println(referrer);

                response.sendRedirect("profile.jsp");
            } else {
                request.setAttribute("errorMessage", "Login unsuccessful. Password or email was wrong.");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
        } catch (IOException | ServletException e) {
            e.printStackTrace();
        }
    }
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}
