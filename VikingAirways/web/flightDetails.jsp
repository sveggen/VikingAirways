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
    <script defer src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script defer src="scripts/searchFilter.js"></script>
    <style>
        form {
            margin: auto;
        }
        table, th, td {
            padding: 10px;
            border: 1px solid black;
            border-collapse: collapse;
        }
        table{
            max-width: 600px;
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

<div class="jumbotron text-center" >
    <h1>Selected Flight</h1><br></div>
<div class="text-center">
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
                <TD align="center">
            </tr>
                <tr>
                    <td>${flight}</td>
                    <td>${ddate}</td>
                    <td>${dept}</td>
                    <td>${arra}</td>
                    <td>${depa}</td>
                    <td>${arrt}</td>
                </tr>
            </tbody>
        </table>
</div>
<br><br>
<div class="text-center">
    <form action="optionalServices.jsp" id="flightForm" method="post">
        <table align="center" class="table table-bordered">
            <thead>
                <tr>
                    <th>Class type</th>
                    <th>Class capacity</th>
                    <th>Class price</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <TD align="center">
                </tr>
                <c:forEach items="${ctype}" var="ctype" varStatus="myIndex">
                        <tr>
                            <td>${ctype}</td>
                            <td>${ccap[myIndex.index]}</td>
                            <td>${cprice[myIndex.index]}</td>
                            <td><button name="SelectedClass" id="${myIndex.index}btn" class="btn btn-success">Select</button></td>
                        </tr>
                </c:forEach>
                </tbody>
            </table>
        </form>
    </div>

<script defer src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script defer src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>