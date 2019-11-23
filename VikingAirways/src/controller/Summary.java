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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


@WebServlet(name = "Summary", urlPatterns = {"/Summary"})
public class Summary extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try{

            response.setContentType("text/html");
            PrintWriter out = response.getWriter();

            HashMap<String, String> cookieHash = new HashMap<>();
            //Retrieves cookies and adds them to an Array
            Cookie[] cookies = request.getCookies();

            //Loops through the cookie Array and adds them to the HashMap and finally deletes them.
            // Adds the deleted cookies to the response.
            for (Cookie cookie : cookies) {
                cookieHash.put(cookie.getName(), cookie.getValue());
            }

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

            String pet = cookieHash.get("petcarryon");
            request.setAttribute("pet", pet);














            /**
            out.print("These are the options you have submitted so far"+ck[0].getValue())

            out.close();

            out.print("<form action='NesteSide'>");//creating submit button
            out.print("<input type='submit' value='Confirm'>");
            out.print("</form>");

            out.close();
**/
            RequestDispatcher req = request.getRequestDispatcher("summary.jsp");
            req.forward(request, response);
        }catch(Exception e){System.out.println(e);}
    }



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{

            response.setContentType("text/html");
            PrintWriter out = response.getWriter();

            HashMap<String, String> cookieHash = new HashMap<>();
            //Retrieves cookies and adds them to an Array
            Cookie[] cookies = request.getCookies();

            //Loops through the cookie Array and adds them to the HashMap and finally deletes them.
            // Adds the deleted cookies to the response.
            for (Cookie cookie : cookies) {
                cookieHash.put(cookie.getName(), cookie.getValue());
            }

            String flightClass = cookieHash.get("class");
            request.setAttribute("flightClass", flightClass);
            /**
             out.print("These are the options you have submitted so far"+ck[0].getValue())

             out.close();

             out.print("<form action='NesteSide'>");//creating submit button
             out.print("<input type='submit' value='Confirm'>");
             out.print("</form>");

             out.close();
             **/
            RequestDispatcher req = request.getRequestDispatcher("summary.jsp");
            req.forward(request, response);
        }catch(Exception e){System.out.println(e);}
    }
}
