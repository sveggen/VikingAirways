import classes.BookingNumberEmail;
import classes.DBConnect;

import java.sql.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
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

                //Loops through the cookie Array and adds them to the HashMap and finally deletes them.
                // Adds the deleted cookies to the response.
                for (Cookie cookie : cookies) {
                    cookieHash.put(cookie.getName(), cookie.getValue());
                    if(!cookie.getName().equals("JSESSIONID")) {
                        cookie.setMaxAge(0);
                        response.addCookie(cookie);
                    }
                }

                String customerInfo = "INSERT INTO Customer (first_name, last_name, email, date_of_birth) " +
                        "VALUES(?, ?, ?, ?);";

                String bookinginfo = "INSERT INTO Booking (customer_paid, checked_in_baggage, extra_carryon, " +
                        "special_equipment, pet_carryon, food_on_flight, wifi_on_flight, flight_number_fk, customer_id_fk, class_id_fk, registered_user_fk) " +
                        "VALUES('1', ?, ?, ?, ?, ?, ?, ?, LAST_INSERT_ID(), ?, ?);";

                String getBN = "SELECT * FROM Customer WHERE customer_id = (SELECT LAST_INSERT_ID());";

                String getClassID = "SELECT class_id FROM Class WHERE class_type = (?) AND class_flight_fk = (?);";

                String removeSeat = "UPDATE Class SET class_capacity = class_capacity - 1 WHERE class_id = (?);";

                conn.setAutoCommit(false);

                try (PreparedStatement insertCustomerInfo = conn.prepareStatement(customerInfo)) {
                    insertCustomerInfo.setString(1, cookieHash.get("firstname"));
                    insertCustomerInfo.setString(2, cookieHash.get("lastname"));
                    insertCustomerInfo.setString(3, cookieHash.get("email"));
                    insertCustomerInfo.setDate(4, Date.valueOf(cookieHash.get("dateofBirth")));
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

                            HttpSession session = request.getSession();
                            if(session.getAttribute("userID") != null){
                                insertBookingInfo.setInt(9, (Integer) session.getAttribute("userID"));
                                } else {
                                insertBookingInfo.setNull(9, java.sql.Types.INTEGER);
                            }
                            insertBookingInfo.executeUpdate();

                            try (PreparedStatement getCustomerInfostmt = conn.prepareStatement(getBN)) {
                                ResultSet getBNRS = getCustomerInfostmt.executeQuery();

                                while (getBNRS.next()) {
                                    bookingnumber = getBNRS.getString("customer_id");
                                }
                                try (PreparedStatement seatRemoval = conn.prepareStatement(removeSeat)) {
                                    seatRemoval.setString(1, classID);
                                    seatRemoval.executeUpdate();
                                    }
                                }
                            conn.commit();
                            BookingNumberEmail.sendEmail(conn, bookingnumber);
                            RequestDispatcher rd = request.getRequestDispatcher("bookingConfirmation.jsp");
                            rd.forward(request, response);
                        }
                    }
                }
                //Rollback if error occurs
                catch (SQLException e) {
                    e.printStackTrace();
                    System.out.println("Transaction did not commit");
                    conn.rollback();
                }
                //Sends an email to the customer with the correct booking number.
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}