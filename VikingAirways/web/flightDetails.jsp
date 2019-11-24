<%--
  Created by IntelliJ IDEA.
  User: magnusneergaard
  Date: 2019-11-24
  Time: 13:33
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page language="java" import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
    <title>Viking Airways - Cheap flights with comfort</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <!--<link rel="stylesheet" href="stylesheets/globalStyle.css">-->
    <style>
        form {
            margin: auto;
        }
        table, th, td {
            padding: 10px;
            border: 1px solid black;
            border-collapse: collapse;
        }
    </style>
</head>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
    <ul class="navbar-nav mr-auto">
        <li class="nav-item active">
            <a class="nav-link" href="index.jsp">Home</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="checkIn.jsp">Check In</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="myBookingSearch.jsp">My Booking</a>
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

<script defer src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script defer src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<div class="jumbotron text-center" >
    <h1>Selected Flight</h1><br></div>
</body>
<div class="text-center">
    <form action="FlightDetails" method="get">
        <table align="center" class="table table-bordered">
            <thead>
            <tr>
                <th>Flight number</th>
                <th>Departure date</th>
                <th>Departure airport</th>
                <th>Arrival airport</th>
                <th>Departure time</th>
                <th>Arrival time</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <TD align="center"><A HREF="flightDetails.jsp">
                </A></tr>

            <c:forEach items="${flight}" var="flight" varStatus="myIndex">
                <tr>
                    <td>${flight}</td>
                    <td>${ddate[myIndex.index]}</td>
                    <td>${dept[myIndex.index]}</td>
                    <td>${arra[myIndex.index]}</td>
                    <td>${depa[myIndex.index]}</td>
                    <td>${arrt[myIndex.index]}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </form>
</div>

<div class="text-center">
        <table align="center">
            <thead>
                <tr>
                    <th>Class type</th>
                    <th>Class capacity</th>
                    <th>Class price</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <TD align="center"><A HREF="adminSite.jsp">
                    </A>
                </tr>
                <c:forEach items="${ctype}" var="ctype" varStatus="myIndex2">
                    <tr>
                        <td>${ctype[myIndex2.index]}</td>
                        <td>${ccap[myIndex2.index]}</td>
                        <td>${cprice[myIndex2.index]}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
</html>