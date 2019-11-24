<%--
  Created by IntelliJ IDEA.
  User: Markus
  Date: 14.11.2019
  Time: 15:00
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=ISO-8859-1" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <title>Viking Airways - Cheap flights with comfort</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="../stylesheets/globalStyle.css">
</head>
<body>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
    <ul class="navbar-nav mr-auto">
        <li class="nav-item active">
            <a class="nav-link" href="/VikingAirways/index.jsp">Home</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="/VikingAirways/checkIn.jsp">Check In</a>
        </li>
        <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
                My Booking
            </a>
            <div class="dropdown-menu">
            <a class="dropdown-item" href="/VikingAirways/myBookingSearch.jsp">Change Booking</a>
                <a class="dropdown-item" href="/VikingAirways/cancelBooking.jsp">Cancel Booking</a>
            </div>
        </li>
    </ul>
    <ul class="navbar-nav ml-auto">
        <li class="nav-item">
            <a class="nav-link" href="/VikingAirways/register.jsp">Register</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="/VikingAirways/login.jsp">Log In</a>
        </li>
    </ul>
</nav>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script defer src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>