package classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserData {

    private int customerID;
    private String firstname;
    private String lastname;
    private int dateOfBirth;
    private boolean adminPriv;


    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
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

    public int getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(int dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public boolean isAdminPriv() {
        return adminPriv;
    }

    public void setAdminPriv(boolean adminPriv) {
        this.adminPriv = adminPriv;
    }

    public void getPersonalData (String email){

        try{
            Connection conn;
            DBConnect dbconnect = new DBConnect();
            conn = dbconnect.connectToDB();

            PreparedStatement ps = conn.prepareStatement("SELECT * FROM Customer WHERE email =?");

            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                setCustomerID(rs.getInt("customer_id"));
                setFirstname(rs.getString("first_name"));
                setLastname(rs.getString("last_name"));
                setDateOfBirth(rs.getInt("date_of_birth"));
                setAdminPriv(rs.getBoolean("admin_priv"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }



    }
}
