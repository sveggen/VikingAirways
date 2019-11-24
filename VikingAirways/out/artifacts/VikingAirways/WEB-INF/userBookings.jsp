<%--
  Created by IntelliJ IDEA.
  User: Markus
  Date: 23.11.2019
  Time: 15:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body>
<b>The Demo Object Names Are:-
    <br>

    <table>
        <c:forEach items="${firstname}" var="firstname">
            <tr>
                <td>${firstname}</td>
            </tr>
        </c:forEach>

    </table>
</body>
</html>

<html>
<head>
    <title>Title</title>
</head>
<body>

</body>
</html>
