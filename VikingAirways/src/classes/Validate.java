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

            PreparedStatement ps = conn.prepareStatement("SELECT * FROM RegisteredUser WHERE email=? AND registered_user_password=?");

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

            PreparedStatement ps = conn.prepareStatement("SELECT * FROM RegisteredUser WHERE email =?");

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

    public static void changePassword(String password, String email){
        try{
            Connection conn;
            DBConnect dbconnect = new DBConnect();
            conn = dbconnect.connectToDB();

            PreparedStatement ps = conn.prepareStatement("UPDATE RegisteredUser SET registered_user_password = ? WHERE email = ?;");

            ps.setString(1, password);
            ps.setString(2, email);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

        public static void newUser(String FirstName, String LastName, String BirthDate, String Password, String Email) {
            try {
                Connection conn;
                DBConnect dbconnect = new DBConnect();
                conn = dbconnect.connectToDB();

                PreparedStatement insertUserInfo = conn.prepareStatement("insert into RegisteredUser (first_name, last_name, date_of_birth, registered_user_password, email, account_created, admin_priv)  values (?, ?, ?, ?, ?, true, false);");

                insertUserInfo.setString(1, FirstName);
                insertUserInfo.setString(2, LastName);
                insertUserInfo.setString(3, BirthDate);
                insertUserInfo.setString(4, Password);
                insertUserInfo.setString(5, Email);
                insertUserInfo.executeUpdate();
                System.out.println("Ny bruker opprettet");
            } catch (SQLException ex) {
                System.out.println("Ny bruker kunne ikke opprettes");
            }
        }
    }