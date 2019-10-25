<%--
  Created by IntelliJ IDEA.
  User: Markus
  Date: 06.10.2019
  Time: 19:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <html>
    <head>
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
            <a class="nav-link" href="#">Register</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="#">Log In</a>
        </li>
    </ul>
</nav>
    <title>Login</title>
</head>
<form method="post" action="Login">
    Email:<input type="text" name="email" /><br/>
    Password:<input type="password" name="password" /><br/>
    <input type="submit" value="login" />
</form>
</body>
</html>
