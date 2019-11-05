import classes.DBConnect;

import java.io.PrintWriter;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "PaymentConfirmed", urlPatterns = {"/PaymentConfirmed"})
public class PaymentConfirmed extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        //Ikke ferdig. Placeholderfil for betalingsbekreftelse.
        out.println("<html>");
        out.println("<body>");
        out.println("Thank you for your payment");
        out.println("</body></html>");


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}
