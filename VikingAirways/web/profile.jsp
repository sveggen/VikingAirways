<%--
  Created by IntelliJ IDEA.
  User: Markus
  Date: 19.10.2019
  Time: 15:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=ISO-8859-1" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/templates/navbar.jsp" />

<!DOCTYPE html>
<html>
<head>
    <html>
    <head>
        <title>Viking Airways - Cheap flights with comfort</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" href="stylesheets/globalStyle.css">
    </head>
<body>
<div class="jumbotron text-center">
    <h1>My Profile</h1>
</div>
<div class="text-center">
    <p>Name: ${firstname} ${lastname}</p>
    <p>Email: ${email}</p>
    <p>User ID: ${userID}</p>
    <p>Date of birth: ${dateOfBirth}</p>
</div>
    <div class="col">
    <form class="justify-content-center">
        <a href="#" class="hyperlink">
<p class="h3"></p>
        </a>
    </form>
        <form class="justify-content-center" action="Profile" method="post">
            <div class="text-center">
                <div style="color: #FF0000;">${errorMessage}</div><br>
                <div style="color: #008F11;">${successMessage}</div><br>
            </div>
            <input type="password" class="form-control" name="oldpassword" value="" placeholder="Current password" required/><br>
            <input type="password" class="form-control" name="newpassword" value="" placeholder="New password" required/><br>
            <input class="btn btn-success" type="submit" name="submit" value="Change password"><br>
</form>

<c:forEach items="${x}" var="item">
    <div class="text-center">
    <h1>Mine bookinger:</h1><br>
        Bookingnummer: ${item.value}
        Fra - til: ${bookingnumber} ${bookingnumber}
        Flight: ${bookingnumber}
        Dato: ${bookingnumber}
        Tidspunkt: ${bookingnumber}
        <a class="nav-link" href="/VikingAirways/myBookingSearch?">Endre Booking</a>
</c:forEach>

        <c:forEach var="results" items="${results}">
            <tr>
                <td><c:out value="${results.userid}"></c:out></td>
                <td><c:out value="${results.password}"></c:out></td>
                <td><c:out value="${results.role}"></c:out></td>
                <td><c:out value="${results.contact}"></c:out></td>
                <td><c:out value="${results.mentor}"></c:out></td>
                <td><c:out value="${results.group}"></c:out></td>
            </tr>
        </c:forEach>
    </tr>
    </div>
</div>
</body>
</html>
