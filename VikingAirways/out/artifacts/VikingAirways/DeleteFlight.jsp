<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/templates/navbar.jsp" />
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="stylesheets/globalStyle.css">
</head>
<body>
<div class="jumbotron text-center">
    <h1>Remove flight</h1>
</div>
</body>
</html>
<div>
    <div style="padding : 10px;">
        <form action="DeleteFlight" method="post">
            <div class="text-center">
                <div style="color: #008f11;">${flightDeleted}</div><br>
                <div style="color: #FF0000;">${flightNotDeleted}</div><br>
            <h5>Enter the correct flightnumber to remove a flight.</h5>
            <br>
            <h5>If you want to delete a flight with bookings, you have to remove the bookings first.</h5>
            <input type="text" placeHolder="Flight number:" name="flightnumber"/>
            <input type="submit" value="Remove" name="remove"/>
            </div>
        </form>
    </div>
</div>
</body>
</html>