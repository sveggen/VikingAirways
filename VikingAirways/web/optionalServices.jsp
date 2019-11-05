<%--
  Created by IntelliJ IDEA.
  User: stian
  Date: 13.10.2019
  Time: 18.04
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="stylesheets/globalStyle.css">
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Viking Airways - Extra Accommodations</title>
    <style>
        /* The container */
        .container {
            display: block;
            position: relative;
            padding-left: 50px;
            margin-bottom: 12px;
            cursor: pointer;
            font-size: 22px;
            -webkit-user-select: none;
            -moz-user-select: none;
            -ms-user-select: none;
            user-select: none;
        }

        /* Hide the browser's default checkbox */
        .container input {
            position: absolute;
            opacity: 0;
            cursor: pointer;
            height: 0;
            width: 0;
        }

        /* Create a custom checkbox */
        .checkmark {
            position: absolute;
            top: 0;
            left: 0;
            height: 25px;
            width: 25px;
            background-color: #eee;
        }

        /* On mouse-over, add a grey background color */
        .container:hover input ~ .checkmark {
            background-color: #ccc;
        }

        /* When the checkbox is checked, add a blue background */
        .container input:checked ~ .checkmark {
            background-color: #28a745;
        }

        /* Create the checkmark/indicator (hidden when not checked) */
        .checkmark:after {
            content: "";
            position: absolute;
            display: none;
        }

        /* Show the checkmark when checked */
        .container input:checked ~ .checkmark:after {
            display: block;
        }

        /* Style the checkmark/indicator */
        .container .checkmark:after {
            left: 10px;
            top: 5px;
            width: 6px;
            height: 13px;
            border: solid white;
            border-width: 0 3px 3px 0;
            -webkit-transform: rotate(45deg);
            -ms-transform: rotate(45deg);
            transform: rotate(45deg);
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
            <a class="nav-link" href="register.jsp">Register</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="login.jsp">Log In</a>
        </li>
    </ul>
</nav>
<div class="jumbotron text-center">
    <h1>Extra Accommodations</h1>
    <p>Please select your desired add-ons for your trip </p>
</div>
    <form method="post" action="Checkbox">
        <table>
            <tr>
                <td><label class="container">Extra Luggage <input type="checkbox" name="Extra_Luggage" value="Yes"><span class="checkmark"></span> </label></td>
            </tr>
            <tr>
                <td><label class="container">Extra Carry-on<input type="checkbox" name="Extra_Carryon" value="Yes"><span class="checkmark"></span> </label></td>
            </tr>
            <tr>
                <td><label class="container"> Sport Equipment<input type="checkbox" name="Special_Equipment" value="Yes"> <span class="checkmark" </td></label>
            </tr>
            <tr>
                <td><label class="container">Pet Carry-on<input type="checkbox" name="Pet_CarryOn" value="Yes"><span class="checkmark" </td></label>
            </tr>
            <tr>
                <td><label class="container">Food on flight<input type="checkbox" name="Food_on_flight" value="Yes"><span class="checkmark" </td></label>
            </tr>
            <tr>
                <td><label class="container">WiFi on flight<input type="checkbox" name="WiFi_on_flight" value="Yes"><span class="checkmark" </td></label>
            </tr>
            <tr>
                <td>
                    <input type="submit" value="Continue" class="btn btn-success">
                </td>
            </tr>
        </table>
    </form>

</body>
</html>