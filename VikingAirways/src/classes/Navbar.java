package classes;

import java.io.PrintWriter;

public class Navbar {

    public static void loadNavBar(PrintWriter out) {
        out.println("<nav class=\"navbar navbar-expand-sm bg-dark navbar-dark\">");
        out.println("  <ul class=\"navbar-nav\">");
        out.println("    <li class=\"nav-item active\">");
        out.println("      <a class=\"nav-link\" href=\"index.jsp\">Home</a>");
        out.println("    </li>");
        out.println("    <li class=\"nav-item\">");
        out.println("      <a class=\"nav-link\" href=\"#\">Check In</a>");
        out.println("    </li>");
        out.println("    <li class=\"nav-item\">");
        out.println("      <a class=\"nav-link\" href=\"#\">My Booking</a>");
        out.println("    </li>");
        out.println("    <li class=\"nav-item\">");
        out.println("      <a class=\"nav-link\" href=\"#\">Register</a>");
        out.println("    </li>");
        out.println("    <li class=\"nav-item\">");
        out.println("      <a class=\"nav-link\" href=\"#\">Log In</a>");
        out.println("    </li>");
        out.println("  </ul>");
        out.println("</nav>");
    }
}
