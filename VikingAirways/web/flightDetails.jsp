<%--
  Created by IntelliJ IDEA.
  User: magnusneergaard
  Date: 2019-11-01
  Time: 00:09
  To change this template use File | Settings | File Templates.
  Ikke i bruk enda, skal erstattes med out.println i FlightDetails.java
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>@
<html>
<head>
    <script src=\"https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.js\"></script>
    <script src=\"scripts/searchFilter.js\"></script>

    <h1>Selected flight:</h1><br/><br/>
</head>
<body>
Flight selected: " + selectedFlight
</br>Date og departure: " + dateOfDeparture
</br>Time of departure: " + timeOfDeparture
</br>Destination airport: " + destinationAirport
</br>Departure airport: " + departureAirport
</br>Arrivle time: " + arrivalTime
</br></br>

<table style=width:30 border=1
 <form method=post action=optionalServices.jsp id=flightForm>
    <th>Class</th>
    <th>Seats</th>
    <th>Price</th>
    </tr>
    <tr>
    <th>Economy: </th>
    <td>"+availableSeatsEcon+"</td>
    <td>"+priceEcon+"</td>
    <td><button name=SelectedClass id=economybtn value=Economy +flightnumber+"\">Select</button></td>
    </tr>
    <tr>
    <th>Business: </th>
    <td>"+availableSeatsBusi+"</td>
    <td>"+priceBusi+"</td>
    <td><button name=\"SelectedClass\" id=\"businessbtn\" value=\"Business"+flightnumber+"\">Select</button></td>
    </tr>
    <tr>
    <td>"+availableSeatsFirst+"</td>
    <td>"+priceFirst+"</td>
    <td><button name=\"SelectedClass\" id=\"firstbtn\" value=\"firstClass"+flightnumber+"\">Select</button></td></tr>
    </form>
    </table>



</body>
</html>
