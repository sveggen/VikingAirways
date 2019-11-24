<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/templates/navbar.jsp" />
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="stylesheets/globalStyle.css">
</head>
<body>
<div class="jumbotron text-center">
    <h1>My Booking</h1>
    <p>Please enter your booking number below to check in and get your boarding pass.</p>
</div>

<div class="container">
    <form class="justify-content-center" action="BoardingPass" method="post">
        <div class="form-group">
            <input type="text" class="form-control" name="bookingNumber" placeholder="Enter your booking number...">
        </div>
        <div class="form-group">
            <input type="submit" value="Check In" class="btn btn-success">
        </div>
    </form>
</div>

</body>
</html>