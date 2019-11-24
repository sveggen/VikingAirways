package dao;

import DBConnection.DBConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class UserDao implements Dao {

    DBConnect dbconnect = new DBConnect();

    @Override
    public Optional get(long id) {
        return Optional.empty();
    }

    @Override
    public List getAll() {
        return null;
    }


    public boolean checkUserExistence(String email, String password) {
        boolean userExistence = false;

        try {
            Connection conn = dbconnect.connectToDB();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM RegisteredUser WHERE email=? AND registered_user_password=?");

            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            userExistence = rs.next();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return userExistence;
    }

    public boolean checkEmailExistence(String email) {
        boolean emailExistence = false;
        try {
            Connection conn = dbconnect.connectToDB();

            PreparedStatement ps = conn.prepareStatement("SELECT * FROM RegisteredUser WHERE email =?");

            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                emailExistence = true;
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return emailExistence;
    }

    public void changePassword(String password, String email) {
        try {
            Connection conn = dbconnect.connectToDB();

            PreparedStatement ps = conn.prepareStatement("UPDATE RegisteredUser SET registered_user_password = ? WHERE email = ?;");

            ps.setString(1, password);
            ps.setString(2, email);
            ps.executeUpdate();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void newUser(String FirstName, String LastName, String BirthDate, String Password, String Email) {
        try {
            Connection conn = dbconnect.connectToDB();

            PreparedStatement insertUserInfo = conn.prepareStatement("insert into RegisteredUser (first_name, last_name, date_of_birth, registered_user_password, email, account_created, admin_priv)  values (?, ?, ?, ?, ?, true, false);");

            insertUserInfo.setString(1, FirstName);
            insertUserInfo.setString(2, LastName);
            insertUserInfo.setString(3, BirthDate);
            insertUserInfo.setString(4, Password);
            insertUserInfo.setString(5, Email);
            insertUserInfo.executeUpdate();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public HashMap<String, Object> getPersonalData(String email) {
        HashMap<String, Object> user = new HashMap<>();
        try {
            Connection conn = dbconnect.connectToDB();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM RegisteredUser WHERE email =?");

            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                user.put("userid", rs.getInt("registered_user_id"));
                user.put("firstname", rs.getString("first_name"));
                user.put("lastname", rs.getString("last_name"));
                user.put("dateofbirth", rs.getDate("date_of_birth"));
                user.put("adminpriv", rs.getInt("admin_priv"));
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
    }

