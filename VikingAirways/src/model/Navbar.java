package model;

import java.io.PrintWriter;

/**
 * This class prints out the navigation bar for servlets that don't use JSP
 *
 * @author Jørgen Lindbøl
 * @version 24.11.2019
 */
public class Navbar {

    /**
     * Prints out the navigation bar through the provided PrintWriter
     *
     * @param out The PrintWriter to be used for printing out the navigation bar
     */
    public static void loadNavBar(PrintWriter out) {
        out.println("<nav class=\"navbar navbar-expand-sm bg-dark navbar-dark\">");
        out.println("  <ul class=\"navbar-nav mr-auto\">");
        out.println("    <li class=\"nav-item active\">");
        out.println("      <a class=\"nav-link\" href=\"index.jsp\">Home</a>");
        out.println("    </li>");
        out.println("    <li class=\"nav-item\">");
        out.println("      <a class=\"nav-link\" href=\"checkIn.jsp\">Check In</a>");
        out.println("    </li>");
        out.println("    <li class=\"nav-item\">");
        out.println("      <a class=\"nav-link\" href=\"myBookingSearch.jsp\">My Booking</a>");
        out.println("    </li>");
        out.println("  </ul>");
        out.println("  <ul class=\"navbar-nav ml-auto\">");
        out.println("    <li class=\"nav-item\">");
        out.println("      <a class=\"nav-link\" href=\"register.jsp\">Register</a>");
        out.println("    </li>");
        out.println("    <li class=\"nav-item\">");
        out.println("      <a class=\"nav-link\" href=\"login.jsp\">Log In</a>");
        out.println("    </li>");
        out.println("  </ul>");
        out.println("</nav>");
    }
}
