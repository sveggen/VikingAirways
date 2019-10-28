<%--
  Created by IntelliJ IDEA.
  User: Markus
  Date: 20.09.2019
  Time: 11:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <html>
    <head>
        <title>Viking Airways - Cheap flights with comfort</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" href="stylesheets/globalStyle.css">
        <link rel="stylesheet" href="stylesheets/formValidation.css">
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
<h1>Register a new account</h1>
<p>Please fill in your personal information below</p>
</div>

<div class="container">
    <div class="row">
        <div class="col">
    <form class="justify-content-center" action="Register" method="post">
        First name
            <input type="text" class="form-control" name="FirstName"required><br>
        Last name
            <input type="text" class="form-control" name="LastName"required><br>
        Date of birth
        <input type="date" class="form-control" name="BirthDate"required><br>

        Email address
        <input type="email" class="form-control" name="Email"required><br>

        Password
        <input type="password" class="form-control" name="Password"required><br>

            <input class="btn btn-success" type="submit" name="submit" value="Register">

    </form>
</div>
</div>
</div>
</body>
</html>
