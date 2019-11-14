<%--
  Created by IntelliJ IDEA.
  User: Markus
  Date: 19.10.2019
  Time: 15:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=ISO-8859-1" language="java" %>
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
<p>Your email: <%=request.getParameter("email")%></p>
</div>
    <div class="col">
    <form class="justify-content-center">
        <a href="#" class="hyperlink">
<p class="h3"></p>
        </a>
</form>
</div>
</body>
</html>
