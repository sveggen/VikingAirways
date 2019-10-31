<%--
  Created by IntelliJ IDEA.
  User: stian
  Date: 20.10.2019
  Time: 16.05
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>File Upload to Database Demo</title>
</head>
<body>
<center>
    <h1>Enter your Personal Information:</h1>
    <form method="post" action="uploadInfo" enctype="multipart/form-data">
        <table border="0">
            <tr>
                <td>First Name: </td>
                <td><input type="text" name="FirstName" size="50"></td>
            </tr>
            <tr>
                <td>Last Name: </td>
                <td><input type="text" name="LastName" size="50"></td>
            </tr>
            <tr>
                <td>Address: </td>
                <td><input type="text" name="Address" size="50"></td>
            </tr>
            <tr>
                <td>Email Address: </td>
                <td><input type="text" name="Email" size="50"></td>
            </tr>
            <tr>
                <td>Date of Birth (YYYY-MM-DD): </td>
                <td><input type="text" name="DateofBirth" size="50"></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="Save">
                </td>
            </tr>
        </table>
    </form>
</center>
</body>
</html>
