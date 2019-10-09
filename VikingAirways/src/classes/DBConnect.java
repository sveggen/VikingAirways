package classes;

import javax.naming.*;
import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.*;

public class DBConnect {

    Connection conn;

    public Connection connectToDB(PrintWriter out) {
        try {
            Context cont = new InitialContext();
            DataSource ds = (DataSource)cont.lookup("java:comp/env/jdbc/localhostDS");

            conn = ds.getConnection();
            return conn;

        }
        catch (SQLException ex ) {
            out.println("Not connected to database " +ex);
        }
        catch (NamingException nex) {
            out.println("Not correct naming" + nex);
        }
        return null;
    }
}
