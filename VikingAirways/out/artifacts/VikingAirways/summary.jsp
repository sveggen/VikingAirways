<%--
  Created by IntelliJ IDEA.
  User: Heidi Beate
  Date: 31.10.2019
  Time: 15.14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>Viking Airways - Cheap flights with comfort</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="stylesheets/globalStyle.css">
</head>

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
    <h1>Booking summary</h1>
    <p>Please confirm the information you have submitted before you continue to payment </p>
</div>
<div style="text-align: center;">
    <form action="personalinfo.jsp" method="post">
        <br>
        <br>
        <table class="table">
            <tbody>
            <tr>
                <th scope="row">Departure from: </th>
                <td>${depAirport}   ${depDate}   ${depTime}
                    <% String depAir = request.getParameter("depAirport");
                    System.out.println(depAir); %>
                    <% String depDat = request.getParameter("dateofdeparture");
                        System.out.println(depDat); %>
                    <% String depTime = request.getParameter("timeofdeparture");
                        System.out.println(depTime); %></td>
            </tr>
            <tr>
                <th scope="row">Travel destination and arrival time: </th>
                <td>${destAirport}   ${arrTime}
                    <% String desAir = request.getParameter("destinationAirport");
                        System.out.println(desAir); %>
                    <% String arrTim = request.getParameter("arrivaltime");
                        System.out.println(arrTim); %>
                </td>

            </tr>
            <tr>
                <th scope="row">Class: </th>
                <td>${flightClass}
                    <% String flightc = request.getParameter("flightClass");
                        System.out.println(flightc); %>
                </td>
            <tr>
                <td>
                    <input type="submit" class="btn btn-success" value="Confirm">
                </td>
            </tr>

            </tbody>
        </table>
    </form>
        </div>


</body>




<!--<script defer src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>-->
</html>