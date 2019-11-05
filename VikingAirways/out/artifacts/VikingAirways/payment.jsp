<%--
  Created by IntelliJ IDEA.
  User: magnusneergaard
  Date: 2019-10-24
  Time: 23:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Payment Details</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="stylesheets/globalStyle.css">

    <style>
        input {
            width: 100%;
            margin-bottom: 10px;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 3px;
        }
        * {
            box-sizing: border-box;
        }
        .col-50{
            padding: 0 16px;
            -ms-flex: 50%; /* IE10 */
            flex: 50%;
        }
        .row {
            display: -ms-flexbox; /* IE10 */
            display: flex;
            -ms-flex-wrap: wrap; /* IE10 */
            flex-wrap: wrap;
            margin: 0 -16px;
}
        

    </style>
</head>

<body>
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="index.jsp">Home</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Check In</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">My Booking</a>
      </li>
    </ul>
    <ul class="navbar-nav ml-auto">
      <li class="nav-item">
       <a class="nav-link" href="register.jsp">Register</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="login.jsp">Log In</a>
      </li>
    </ul>
  </nav>

  <div class="jumbotron text-center">
    <h1>Payment Details</h1>
    <p>Please do not pay us for this. We are the Russian government</p>
  </div>


<form action="PaymentDBupdate" method="post">
    First name: <br>
    <input type="text" name ="firstName" id="firstName" maxlength="45" required placeholder="John"> <br> <br>
    Last name: <br>
    <input type="text" name="lastName" id="lastName" maxlength="45" required placeholder="Doe">
    <br><br>
    Credit Card: <br>
    <input type="number" name="creditCard" id="creditCard" required placeholder="XXXX-XXXX-XXXX-XXXX">
    <br><br>
    Expiration Date:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;CVC:<br>
      <div class="row">
      <div class="col-50">
        <input type="month" name="expDate" id="expDate" min="2019-10" max="2023-12"required>
      </div>
    <!--CVC: <br>-->
    <div class="col-50">
    <input type="number" name="cvc" id="cvc" max="999" required placeholder="XXX">
    <br><br>
  </div>
</div>
    <input type="submit" value="Pay Now" class="btn btn-success">
</form>

<script defer src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>
