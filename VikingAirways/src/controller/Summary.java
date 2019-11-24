package controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

/**
 * This class retrieves cookies.
 *
 * @author Heidi Landsverk
 * @version 24.11.2019
 */
@WebServlet(name = "Summary", urlPatterns = {"/Summary"})
public class Summary extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try{

            response.setContentType("text/html");

            HashMap<String, String> cookieHash = new HashMap<>();
            //Retrieves cookies and adds them to an Array
            Cookie[] cookies = request.getCookies();


            for (Cookie cookie : cookies) {
                cookieHash.put(cookie.getName(), cookie.getValue());

            }

            //
            String flightClass = cookieHash.get("class");
            request.setAttribute("flightClass", flightClass);

            String  depAirport= cookieHash.get("departureairport");
            request.setAttribute("depAirport", depAirport);

            String destAirport = cookieHash.get("destinationAirport");
            request.setAttribute("destAirport", destAirport);

            String depDate = cookieHash.get("dateofdeparture");
            request.setAttribute("depDate", depDate);

            String depTime = cookieHash.get("timeofdeparture");
            request.setAttribute("depTime", depTime);

            String arrTime = cookieHash.get("arrivaltime");
            request.setAttribute("arrTime", arrTime);

        System.out.println(depAirport + depDate);



            RequestDispatcher req = request.getRequestDispatcher("summary.jsp");
            req.forward(request, response);
        }catch(Exception e){System.out.println(e);}

    }
}
