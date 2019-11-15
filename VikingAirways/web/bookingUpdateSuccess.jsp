<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/templates/navbar.jsp" />
<html>
<body>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="stylesheets/globalStyle.css">
</head>
<div class="jumbotron text-center">
    <h1>Booking Updated!</h1>
</div>
<h3 class="text-center">Your booking has been successfully updated with the details you provided.</h3>
<p class="text-center">To see the updated information, please click "My Booking" on the navigation bar at the top left corner and enter your booking number.</p>
<br/><br/><br/>
<p class="text-center">For debugging: ${rowsUpdated} rows were updated in the database.</p>
</body>
</html>
