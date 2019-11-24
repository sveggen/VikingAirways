<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page language="java" import="java.util.*" %>
<jsp:include page="/templates/navbar.jsp" />
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
<body>
<div class="jumbotron text-center">
    <h1>Admin Site</h1>
</div>
</body>
<div class="text-center">
    <form action="AdminSite" method="get">
        <h5>List of flights</h5>
        <table align="center">
            <thead>
            <tr>
                <td>Flight number</td>
                <td>Departure date</td>
                <td>Departure airport</td>
                <td>Arrival airport</td>
                <td>Departure time</td>
                <td>Arrival time</td>
            </tr>
            </thead>
            <tbody>
            <tr>
                <TD align="center"><A HREF="adminSite.jsp">
                </A></tr>
            <c:forEach items="${flight}" var="flight" varStatus="myIndex">
                <tr>
                    <td>${flight}</td>
                    <td>${ddate[myIndex.index]}</td>
                    <td>${dtime[myIndex.index]}</td>
                    <td>${aairport[myIndex.index]}</td>
                    <td>${dairport[myIndex.index]}</td>
                    <td>${atime[myIndex.index]}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <br>
        <table align="center">
            <thead>
            <tr>
                <td>Flight number</td>
                <td>Class type</td>
                <td>Class capacity</td>
                <td>Class price</td>
            </tr>
            </thead>
            <tbody>
            <tr>
                <TD align="center"><A HREF="adminSite.jsp">
                </A></tr>
            <c:forEach items="${fk_flightnumber}" var="fk_flightnumber" varStatus="myIndex">
                <tr>
                    <td>${fk_flightnumber}</td>
                    <td>${ctype[myIndex.index]}</td>
                    <td>${ccap[myIndex.index]}</td>
                    <td>${cprice[myIndex.index]}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </form>
</div>
</div>
</body>
</html>