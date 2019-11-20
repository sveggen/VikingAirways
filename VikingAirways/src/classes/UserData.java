package classes;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserData {

    private int userID;
    private String firstname;
    private String lastname;
    private Date dateOfBirth;
    private int adminPriv;


    public int getUserID() {
        return userID;
    }

    public void setUserID(int customerID) {
        this.userID = customerID;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth( Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getAdminPriv() {
        return adminPriv;
    }

    public void setAdminPriv(int adminPriv) {
        this.adminPriv = adminPriv;
    }

    public void getPersonalData (String email){

        try{
            Connection conn;
            DBConnect dbconnect = new DBConnect();
            conn = dbconnect.connectToDB();

            PreparedStatement ps = conn.prepareStatement("SELECT * FROM RegisteredUser WHERE email =?");

            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                setUserID(rs.getInt("registered_user_id"));
                setFirstname(rs.getString("first_name"));
                setLastname(rs.getString("last_name"));
                setDateOfBirth(rs.getDate("date_of_birth"));
                setAdminPriv(rs.getInt("admin_priv"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
