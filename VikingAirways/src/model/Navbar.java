package model;

import java.io.PrintWriter;

public class Navbar {

    public static void loadNavBar(PrintWriter out) {
        out.println("<nav class=\"navbar navbar-expand-sm bg-dark navbar-dark\">");
        out.println("  <ul class=\"navbar-nav mr-auto\">");
        out.println("    <li class=\"nav-item active\">");
        out.println("      <a class=\"nav-link\" href=\"index.jsp\">Home</a>");
        out.println("    </li>");
        out.println("    <li class=\"nav-item\">");
        out.println("      <a class=\"nav-link\" href=\"#\">Check In</a>");
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
