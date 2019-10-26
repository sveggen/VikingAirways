<%--
  Created by IntelliJ IDEA.
  User: Markus
  Date: 26.10.2019
  Time: 22:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Viking Airways - Cheap flights with comfort</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <style>
        * {
            box-sizing: border-box;
        }
        body {
            height: 100%;
            width: 100%;
        }
        form {
            margin: auto;
            max-width: 500px;
            position: absolute;
            top: 35%;
            right: 0;
            left: 0;
        }
    </style>
</head>
<body>

<div class="jumbotron text-center">
    <h1>Booking Confirmation</h1>
</div>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="BookingConfirmation">
    Booking number: <input type="text" name="bookingNumber">
    <input type="submit" name="submit" value="submit">
</form>
</body>
</body>
</html>
