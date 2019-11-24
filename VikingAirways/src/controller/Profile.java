package controller;

import dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "Profile", urlPatterns = {"/Profile"})
public class Profile extends HttpServlet {
    private void changePassword(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String oldPassword = request.getParameter("oldpassword");
        String newPassword = request.getParameter("newpassword");

        HttpSession session = request.getSession();
        String email = (String)session.getAttribute("email");
        String password = (String)session.getAttribute("password");

        try {
            UserDao userDao = new UserDao();
            if (oldPassword.equals(password)) {
                userDao.changePassword(newPassword, email);
                request.setAttribute("successMessage", "Password was successfully changed");
            } else {
                request.setAttribute("errorMessage", "Password was not changed - Current password was wrong");
            }
            request.getRequestDispatcher("/profile.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        changePassword(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        changePassword(request, response);
    }
}
