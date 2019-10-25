<%--
  Created by IntelliJ IDEA.
  User: Markus
  Date: 19.10.2019
  Time: 15:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Profile</title>
</head>
<body>
<h1> My Profile</h1>

<h2> Overview </h2>
<p>
    Name:
    RewardPoints:
    User registered:

</p>

<h2> My Bookings</h2>



<h3> Edit user</h3>
<h4> Change password</h4>
<form method="post" action="Profile.jsp">
    Current password: <input type="password" name="password"/><br/>
    New Password: <input type="password" name="password"/><br>
    Repeat new password:  <input type="password" name="password"/><br>


</form>
</body>
</html>
