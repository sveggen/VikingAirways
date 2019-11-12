<%--
  Created by IntelliJ IDEA.
  User: stian
  Date: 20.10.2019
  Time: 16.05
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="stylesheets/globalStyle.css">

    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Personal Information</title>
    <style>
        input {
            width: 100%;
            margin-bottom: 10px;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 3px;
        }
        * {
            box-sizing: border-box;
        }
        .col-50{
            padding: 0 16px;
            -ms-flex: 50%; /* IE10 */
            flex: 50%;
        }
        .row {
            display: -ms-flexbox; /* IE10 */
            display: flex;
            -ms-flex-wrap: wrap; /* IE10 */
            flex-wrap: wrap;
            margin: 0 -16px;
        }
    </style>
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
    <h1>Enter your Personal Information</h1>
</div>
<form action="Personalinfo" method="post">
    First Name: <br>
    <input type="text" name="FirstName" required placeholder="John"> <br>

    Last Name:<br>
    <input type="text" name="LastName" required placeholder="Doe"><br>

    Email Address:<br>
    <input type="text" name="Email" required placeholder="john@doe.com"><br>

    Date of Birth:<br>
    <input type="text" name="DateofBirth" required placeholder="14-03-1980"><br><br>


    <input type="submit" value="Continue" class="btn-success">


</form>
</body>
</html>