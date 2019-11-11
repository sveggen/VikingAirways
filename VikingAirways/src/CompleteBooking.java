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

@WebServlet(name = "CompleteBooking", urlPatterns = {"/CompleteBooking"})
public class CompleteBooking extends HttpServlet {

    private String bookingnumber = null;
    private String classID = null;

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

                String customerInfo = "INSERT INTO Customer (first_name, last_name, email) " +
                        "VALUES(?, ?, ?);";

                String bookinginfo = "INSERT INTO Booking (customer_paid, checked_in_baggage, extra_carryon, " +
                        "special_equipment, pet_carryon, food_on_flight, wifi_on_flight, flight_number_fk, customer_id_fk, class_id_fk) " +
                        "VALUES('1', ?, ?, ?, ?, ?, ?, ?, LAST_INSERT_ID(), ?);";

                String getBN = "SELECT booking_number FROM Booking WHERE customer_id_fk = (LAST_INSERT_ID()) AND flight_number_fk = (?);";

                String getClassID = "SELECT class_id FROM Class WHERE class_type = () AND class_flight_fk = ();";

                //String rmSeat = "Fjern sete i den klassen i den flyvninger kunden har valgt";

                conn.setAutoCommit(false);

                try (PreparedStatement insertCustomerInfo = conn.prepareStatement(customerInfo)) {
                    insertCustomerInfo.setString(1, cookieHash.get("firstname"));
                    insertCustomerInfo.setString(2, cookieHash.get("lastname"));
                    insertCustomerInfo.setString(3, cookieHash.get("email"));
                    insertCustomerInfo.executeUpdate();

                    try (PreparedStatement retrieveClassID = conn.prepareStatement(getClassID)) {
                        retrieveClassID.setString(1, "Economy");
                        retrieveClassID.setString(2, cookieHash.get("flightnumber"));
                        ResultSet classRS = retrieveClassID.executeQuery();

                        while (classRS.next()) {
                            classID = classRS.getString("class_id");
                        }

                        try (PreparedStatement insertBookingInfo = conn.prepareStatement(bookinginfo)) {
                            insertBookingInfo.setString(1, cookieHash.get("extraluggage"));
                            insertBookingInfo.setString(2, cookieHash.get("extracarryon"));
                            insertBookingInfo.setString(3, cookieHash.get("specialequipment"));
                            insertBookingInfo.setString(4, cookieHash.get("petcarryon"));
                            insertBookingInfo.setString(5, cookieHash.get("foodonflight"));
                            insertBookingInfo.setString(6, cookieHash.get("wifionflight"));
                            insertBookingInfo.setString(7, cookieHash.get("flightnumber"));
                            insertBookingInfo.setString(8, classID);
                            insertBookingInfo.executeUpdate();

                            try (PreparedStatement retrieveBN = conn.prepareStatement(getBN)) {
                                retrieveBN.setString(1, cookieHash.get("flightnumber"));
                                ResultSet bnRS = retrieveBN.executeQuery();

                                while (bnRS.next()) {
                                    bookingnumber = bnRS.getString("booking_number");
                                    request.setAttribute("bookingnumber", bookingnumber);
                                }
                                conn.commit();
                            }
                        }
                    }
                }
                catch (SQLException e) {
                    System.out.println("Transaction did not commit");
                    conn.rollback();
                }

                //Sends an email to the customer with the correct booking number.
                BookingNumberEmail.sendEmail(conn, bookingnumber);
                RequestDispatcher rd = request.getRequestDispatcher("bookingConfirmation.jsp");
                rd.forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}