<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
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
            <a class="nav-link" href="/VikingAirways/AdminSite">Admin</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="Register.jsp">Register</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="Login.jsp">Log In</a>
        </li>
    </ul>
</nav>
<div class="jumbotron text-center">
    <h1>Remove flight</h1>
</div>
</body>
</html>
<div>
    <div style="padding : 10px;">
        <form action="DeleteFlight" method="post">
            <h5>Enter the correct flightnumber to remove a flight.</h5>
            <br>
            <h5>If you want to delete a flight with bookings, you have to remove the bookings first.</h5>
            <input type="text" placeHolder="Flight number:" name="flightnumber"/>
            <input type="submit" value="Remove" name="remove"/>
        </form>
    </div>
</div>
</body>
</html>