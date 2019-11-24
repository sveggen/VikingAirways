<%--
  Created by IntelliJ IDEA.
  User: Heidi Beate
  Date: 31.10.2019
  Time: 15.14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<jsp:include page="/templates/navbar.jsp" />
<html>
<head>
    <title>Viking Airways - Cheap flights with comfort</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="stylesheets/globalStyle.css">
</head>

<div class="jumbotron text-center">
    <h1>Booking summary</h1>
    <p>Please confirm the information you have submitted before you continue to payment </p>
</div>
<div style="text-align: center;">
    <form action="personalinfo.jsp" method="post">
        <br/>
        <br/>
        <table class="table">
            <tbody>
            <tr>
                <th scope="row">Departure from: </th>
                <td>
                    ${depAirport}   ${depDate}   ${depTime}
                </td>
            </tr>
            <tr>
                <th scope="row">Travel destination and arrival time: </th>
                <td>
                    ${destAirport}   ${arrTime}
                </td>

            </tr>
            <tr>
                <th scope="row">Class: </th>
                <td>
                    ${flightClass}
                </td>
            <tr>
                <td>
                    <input type="submit" class="btn btn-success" value="Confirm">
                </td>
            </tr>

            </tbody>
        </table>
    </form>
        </div>
</body>
</html>