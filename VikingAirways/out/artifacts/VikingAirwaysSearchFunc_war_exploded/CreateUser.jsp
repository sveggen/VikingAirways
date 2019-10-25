<%--
  Created by IntelliJ IDEA.
  User: Markus
  Date: 20.09.2019
  Time: 11:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>CreateUser</title>
</head>
<body>
<div>
    <h1> Create a new user </h1>
    <form action="CreateUser">
        First name:<input type="text" name="FirstName"required>
        Last name:<input type="text" name="LastName"required><br>
        Date of birth:<input type="date" name="BirthDate"required><br>
        Email address:<input type="email" name="Email"required><br>
        Password: <input type="password" name="Password"required><br>
        <input type="submit" name="submit" value="submit">
    </form>
</div>
</body>
</html>
