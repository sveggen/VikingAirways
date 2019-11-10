import classes.BookingNumberEmail;
import classes.DBConnect;
import java.sql.Connection;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

@WebServlet(name = "Payment_DBupdate", urlPatterns = {"/Payment_DBupdate"})
public class Payment_DBupdate extends HttpServlet {

    private String bookingnumber = null;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Connection conn;
        DBConnect dbconnect = new DBConnect();
        conn = dbconnect.connectToDB();

        String firstName, lastName, creditCard, expDate, cvc;
        firstName = request.getParameter("firstName");
        lastName = request.getParameter("lastName");
        creditCard = request.getParameter("creditCard");
        expDate = request.getParameter("expDate");
        cvc = request.getParameter("cvc");

        try {
                //Creates a HashMap
                HashMap<String, String> cookieHash = new HashMap<>();
                //Retrieves cookies and adds them to an Array
                Cookie[] cookies = request.getCookies();

                //Loops through the cookies and adds them to the HashMap and the Response, and finally deletes them.
                for (Cookie cookie : cookies) {
                    cookieHash.put(cookie.getName(), cookie.getValue());
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);
                }
                //Creates object of class PreparedStatement.
                PreparedStatement insertUserInfo;

                String customerINS = "INSERT INTO Customer (first_name, last_name, email) " +
                        "VALUES(?, ?, ?);";

                String bookingINS = "INSERT INTO Booking (customer_paid, checked_in_baggage, extra_carryon, " +
                        "special_equipment, pet_carryon, food_on_flight, wifi_on_flight, flight_number_fk, customer_id_fk) " +
                        "VALUES('1', ?, ?, ?, ?, ?, ?, ?, LAST_INSERT_ID());";

                String getBN = "SELECT booking_number FROM Booking WHERE customer_id_fk = (LAST_INSERT_ID()) AND flight_number_fk = (?);";

                //String rmSeat = "Fjern sete i den klassen i den flyvninger kunden har valgt";

                try {
                    insertUserInfo = conn.prepareStatement(customerINS);
                    insertUserInfo.setString(1, cookieHash.get("firstname"));
                    insertUserInfo.setString(2, cookieHash.get("lastname"));
                    insertUserInfo.setString(3, cookieHash.get("email"));
                    insertUserInfo.executeUpdate();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                try {
                    insertUserInfo = conn.prepareStatement(bookingINS);
                    insertUserInfo.setString(1, cookieHash.get("extraluggage"));
                    insertUserInfo.setString(2, cookieHash.get("extracarryon"));
                    insertUserInfo.setString(3, cookieHash.get("specialequipment"));
                    insertUserInfo.setString(4, cookieHash.get("petcarryon"));
                    insertUserInfo.setString(5, cookieHash.get("foodonflight"));
                    insertUserInfo.setString(6, cookieHash.get("wifionflight"));
                    insertUserInfo.setString(7, cookieHash.get("flightnumber"));
                    insertUserInfo.executeUpdate();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                try {
                    insertUserInfo = conn.prepareStatement(getBN);
                    //  insertUserInfo.setString(1, "32");
                    insertUserInfo.setString(1, cookieHash.get("flightnumber"));
                    ResultSet resultSet = insertUserInfo.executeQuery();

                    while (resultSet.next()) {
                        bookingnumber = resultSet.getString("booking_number");
                        request.setAttribute("bookingnumber", bookingnumber);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                //Sends email to the customer with the correct booking number.
                BookingNumberEmail.sendEmail(conn, bookingnumber );
                RequestDispatcher rd = request.getRequestDispatcher("bookingConfirmation.jsp");
                rd.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}