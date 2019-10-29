<%--
  Created by IntelliJ IDEA.
  User: kirst
  Date: 28.10.2019
  Time: 14:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin remove flight</title>
</head>
<body>
<div>

    <div style="padding : 10px;">

            <form action="DeleteFlight" method="post">
                <h5>Enter the correct flightnumber to remove a flight,</h5>
                <input type="text" placeHolder="Flight number:" name="flightnumber"/>
                <input type="submit" value="Remove" name="remove"/>
            </form>

    </div>

</div>
</body>
</html>
