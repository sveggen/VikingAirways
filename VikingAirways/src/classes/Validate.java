package classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Validate {
    public static boolean checkUserExistence(String email, String password){
      boolean empw = false;

      try{
          Connection conn;
          DBConnect dbconnect = new DBConnect();
          conn = dbconnect.connectToDB();


          PreparedStatement ps = conn.prepareStatement("SELECT * FROM Customer WHERE email=? AND customer_password=?");

          ps.setString(1, email);
          ps.setString(2, password);
          ResultSet rs = ps.executeQuery();
          empw = rs.next();

      } catch (Exception e) {
          e.printStackTrace();
      }
      return empw;
    }

    public static boolean checkEmailExistence(String email){
        boolean em = false;
        try {
            Connection conn;
            DBConnect dbconnect = new DBConnect();
            conn = dbconnect.connectToDB();

            PreparedStatement ps = conn.prepareStatement("SELECT * FROM Customer WHERE email =?");

            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                em = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return em;
    }



}
