<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Viking Airways - My Booking</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <style>
        form {
            margin: auto;
            max-width: 500px;
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
    <h1>My Booking</h1>
    <p>Please enter your booking number below to find your booking.</p>
</div>

<div class="container">
    <form class="justify-content-center" action="MyBookingSearch" method="post">
        <div class="form-group">
            <input type="text" class="form-control" name="bookingNumber" placeholder="Enter your booking number...">
        </div>
        <div class="form-group">
            <input type="submit" class="btn btn-success">
        </div>
    </form>
</div>

</body>
</html>