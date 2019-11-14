import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(name = "Checkbox", urlPatterns = {"/Checkbox"})
public class Checkbox extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        ArrayList<String> yesArrayList = new ArrayList<>();
        ArrayList<String> noArrayList = new ArrayList<>();

        // gets values of text fields
        String Extra_Luggage = request.getParameter("Checked_in_luggage");
        if(Extra_Luggage==null) {
            noArrayList.add("extraluggage");
        } else
            yesArrayList.add("extraluggage");

        String Extra_Carryon = request.getParameter("Extra_Carryon");
        if(Extra_Carryon==null) {
            noArrayList.add("extracarryon");
        } else
            yesArrayList.add("extracarryon");

        String Special_Equipment = request.getParameter("Special_Equipment");
        if(Special_Equipment==null) {
            noArrayList.add("specialequipment");
        } else
            yesArrayList.add("specialequipment");

        String Pet_CarryOn = request.getParameter("Pet_CarryOn");
        if(Pet_CarryOn==null) {
            noArrayList.add("petcarryon");
        } else
            yesArrayList.add("petcarryon");

        String Food_on_flight = request.getParameter("Food_on_flight");
        if(Food_on_flight==null) {
            noArrayList.add("foodonflight");
        } else
            yesArrayList.add("foodonflight");

        String WiFi_on_flight = request.getParameter("WiFi_on_flight");
        if(WiFi_on_flight==null) {
            noArrayList.add("wifionflight");
        } else
            yesArrayList.add("wifionflight");

        int i = 0;
        for(String selected : yesArrayList){
            Cookie newCookie = new Cookie(yesArrayList.get(i), "1");
            newCookie.setMaxAge(1800);
            response.addCookie(newCookie);
            i++;
        }
        int k = 0;
        for(String selected : noArrayList){
            Cookie newCookie = new Cookie(noArrayList.get(k), "0");
            newCookie.setMaxAge(1800);
            response.addCookie(newCookie);
            k++;
        }

        RequestDispatcher req = request.getRequestDispatcher("personalinfo.jsp");
        req.forward(request, response);
    }
}