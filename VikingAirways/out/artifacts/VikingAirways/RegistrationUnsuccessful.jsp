<%--
  Created by IntelliJ IDEA.
  User: Markus
  Date: 28.10.2019
  Time: 11:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=ISO-8859-1" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <html>
    <head>
        <meta http-equiv="Refresh" content="6; url=http://localhost:8080/VikingAirways/Register.jsp" />
        <title>Viking Airways - Cheap flights with comfort</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" href="stylesheets/globalStyle.css">
    </head>
<body>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
    <ul class="navbar-nav mr-auto">
        <li class="nav-item active">
            <a class="nav-link" href="index.jsp">Home</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="#">Check In</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="#">My Booking</a>
        </li>
    </ul>
    <ul class="navbar-nav ml-auto">
        <li class="nav-item">
            <a class="nav-link" href="register.jsp">Register</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="login.jsp">Log In</a>
        </li>
    </ul>
</nav>
<div class="jumbotron text-center">
    <div class="jumbotron text-center">
        <h1>Registration was unsuccessful!</h1>
    </div>
</div>
<form class="text-center">
    <p>Email already in use. Please wait for a few seconds and you will be taken to the registration page again.</p>
</form>
</body>
</html>

