package classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Validate {
    public static boolean checkUser(String email, String password){
      boolean st = false;

      try{

          Connection conn;
          DBConnect dbconnect = new DBConnect();
          conn = dbconnect.connectToDB();

          PreparedStatement ps = conn.prepareStatement("SELECT * FROM Customer WHERE email=? AND customer_password=?");

          ps.setString(1, email);
          ps.setString(2, password);
          ResultSet rs = ps.executeQuery();
          st = rs.next();

      } catch (Exception e) {
          e.printStackTrace();
      }
      return st;
    }



}
