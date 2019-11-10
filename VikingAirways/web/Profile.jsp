<%--
  Created by IntelliJ IDEA.
  User: Markus
  Date: 19.10.2019
  Time: 15:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=ISO-8859-1" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <script src=\"scripts/passwordMatch.js\"></script>
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
            <a class="nav-link" href="Register.jsp">Register</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="Login.jsp">Log In</a>
        </li>
    </ul>
</nav>
<div class="jumbotron text-center">
    <h1>My Profile</h1>
</div>
<div class="text-center">
<p>Your email:${email} </p>
</div>
    <div class="col">
    <form class="justify-content-center">
        <a href="#" class="hyperlink">
<p class="h3"></p>
        </a>
    </form>
        <form class="justify-content-center" onsubmit="return checkforMatchingPasswords(this)" action="Profile" method="post">
            <div class="text-center">
            <div style="color: #FF0000;">${errorMessage}</div><br>
            <div style="color: #25ff53;">${successMessage}</div><br>
                </div>
        <input type="password" class="form-control" name="oldpassword" value="" placeholder="Current password" required/><br>
        <input type="password" class="form-control" name="newpassword" value="" placeholder="New password" required/><br>
            <input type="password" class="form-control" name="newpassword2" value="" placeholder="New password" required/><br>
        <input class="btn btn-success" type="submit" name="submit" value="Change password"><br>
</form>
</div>
</body>
</html>
