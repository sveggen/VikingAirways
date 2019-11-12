<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Viking Airways - Booking Updated</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
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
            <a class="nav-link" href="myBookingSearch.jsp">My Booking</a>
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

<div class="jumbotron text-center">
    <h1>Booking Updated!</h1>
</div>

<h3 class="text-center">Your booking has been successfully updated with the details you provided.</h3>
<p class="text-center">To see the updated information, please click "My Booking" on the navigation bar at the top left corner and enter your booking number.</p>
<br/><br/><br/>
<p class="text-center">For debugging: ${rowsUpdated} rows were updated in the database.</p>

</body>
</html>
