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
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>File Upload to Database Demo</title>
</head>
<body>
<center>
    <h1>Value Upload to Database</h1>
    <form method="post" action="uploadServlet" enctype="multipart/form-data">
        <table border="0">
            <tr>
                <td><input type="checkbox" name="Extra_Luggage" value="Yes">Extra Luggage </td>
            </tr>
            <tr>
                <td><input type="checkbox" name="Extra_Carryon" value="Yes">Extra Carry-on</td>
            </tr>
            <tr>
                <td><input type="checkbox" name="Overweight_Luggage" value="Yes">Overweight Luggage</td>
            </tr>
            <tr>
                <td><input type="checkbox" name="Sport_Equipment" value="Yes">Sport Equipment</td>
            </tr>
            <tr>
                <td><input type="checkbox" name="Digital_Equipment" value="Yes">Digital Equipment</td>
            </tr>
            <tr>
                <td><input type="checkbox" name="Pet_CarryOn" value="Yes">Pet Carry-on</td>
            </tr>
            <tr>
                <td><input type="checkbox" name="Food_on_flight" value="Yes">Food on flight</td>
            </tr>
            <tr>
                <td><input type="checkbox" name="WiFi_on_flight" value="Yes">WiFi on flight</td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="Submit">
                </td>
            </tr>
        </table>
    </form>
</center>
</body>
</html>