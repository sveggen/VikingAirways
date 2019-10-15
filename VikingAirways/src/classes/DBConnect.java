package classes;

import javax.naming.*;
import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.*;

public class DBConnect {

    Connection conn;

    public Connection connectToDB() {
        try {
            Context cont = new InitialContext();
            DataSource ds = (DataSource)cont.lookup("java:comp/env/jdbc/localhostDS");

            conn = ds.getConnection();
            return conn;

        }
        catch (SQLException ex ) {
            System.out.println("Not connected to database " +ex);
        }
        catch (NamingException nex) {
            System.out.println("Not correct naming" + nex);
        }
        return null;
    }
    public void newUser(String FirstName, String LastName, String BirthDate, String Password, String Email, PrintWriter out, Connection conn) {
        PreparedStatement insertUserInfo;
        try {
            String ins = "insert into vikingairways_db.Customer (first_name, last_name, date_of_birth, customer_password, email)  values (?, ?, ?, ?, ?)";

            insertUserInfo = conn.prepareStatement(ins);
            insertUserInfo.setString(1, FirstName);
            insertUserInfo.setString(2, LastName);
            insertUserInfo.setString(3, BirthDate);
            insertUserInfo.setString(4, Password);
            insertUserInfo.setString(5, Email);
            insertUserInfo.executeUpdate();
            out.println("Ny bruker opprettet");
        } // end try
        catch (SQLException ex) {
            out.println("Ikke fått lagret navn" + ex);
        }

    }

}
