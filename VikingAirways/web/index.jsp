<%@ page contentType="text/html;charset=UTF-8"%>
<jsp:include page="/templates/navbar.jsp" />
<html>
<head>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
  <link rel="stylesheet" href="stylesheets/globalStyle.css">
</head>
<body>
<div class="jumbotron text-center">
  <h1>Welcome to Viking Airways!</h1>
  <p>Please choose your date and destination below to see available flights.</p>
</div>

<div class="container">
  <form class="justify-content-center" action="SearchResult" method="post">
    <div class="form-group">
      <label for="fromAirport">Leaving from:</label>
      <select name="fromAirport" id="fromAirport" class="form-control">
        <option value="KRS">KRS Kjevik</option>
        <option value="OSL">OSL Oslo</option>
      </select>
    </div>
    <div class="form-group">
      <label for="toAirport">Going to:</label>
      <select name="toAirport" id="toAirport" class="form-control">
        <option value="TOS">TOS Tromsø</option>
        <option value="BGO">BGO Bergen</option>
        <option value="TRD">TRD Trondheim</option>
      </select>
    </div>
    <br><br>
    <div class="form-group">
      <label for="departureDate">Departure date:</label>
      <input type="date" name="departureDate" id="departureDate" class="form-control">
    </div>
    <input type="submit" class="btn btn-success" value="Find flights">
  </form>
</div>
<script defer src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>