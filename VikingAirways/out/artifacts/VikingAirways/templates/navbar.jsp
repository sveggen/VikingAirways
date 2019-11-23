<%--
  Created by IntelliJ IDEA.
  User: Markus
  Date: 17.11.2019
  Time: 01:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:choose>
    <c:when test="${adminPriv == 1}">
        <jsp:include page="/templates/adminNavbar.jsp" />
        <br />
    </c:when>
    <c:when test="${adminPriv == 0}">
        <jsp:include page="/templates/customerNavbar.jsp" />
    </c:when>
    <c:otherwise>
        <jsp:include page="/templates/standardNavbar.jsp" />
    </c:otherwise>
</c:choose>
