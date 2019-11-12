import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "/Personalinfo", urlPatterns = {"/Personalinfo"})
public class Personalinfo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // gets values of text fields
        String firstName = request.getParameter("FirstName");
        String lastName = request.getParameter("LastName");
        String email = request.getParameter("Email");
        String dateofBirth = request.getParameter("DateofBirth");

        String[] nameArray = new String[] {"firstname", "lastname", "email", "dateofBirth"};
        String[] valueArray = new String[] {firstName, lastName, email, dateofBirth};

        int i = 0;
        for(String selected : nameArray){
            response.addCookie(new Cookie(nameArray[i], valueArray[i]));
            i++;
        }
        RequestDispatcher req = request.getRequestDispatcher("payment.jsp");
        req.forward(request, response);
    }
}