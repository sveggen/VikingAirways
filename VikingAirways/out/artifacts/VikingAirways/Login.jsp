<%--
  Created by IntelliJ IDEA.
  User: Markus
  Date: 06.10.2019
  Time: 19:41
  To change this template use File | Settings | File Templates.
--%>
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
    <h1>Login</h1>
    <p>Please enter your email and password below.</p>
</div>
<div class="container">
    <div class="row">
        <div class="col">
            <form class="justify-content-center" action="Login" method="post">
                <div style="color: #FF0000;">${errorMessage}</div><br>
                Email
                <input type="email" class="form-control" name="email" required/><br/>
                Password
                <input type="password" class="form-control" name="password" required/><br>
                <input class="btn btn-success" type="submit" name="submit" value="Log in"><br>
                <a href="/VikingAirways/forgotPassword.jsp" class="hyperlink">Forgot your password? Click here</a><br>
                <a href="/VikingAirways/register.jsp" class="hyperlink">Create a new account here</a><br>
            </form>
        </div>
    </div>
</div>
</body>
</html>
