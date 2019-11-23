<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/templates/navbar.jsp" />
<html>
<head>
    <title>Viking Airways - My Booking</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <style>
        form {
            margin: auto;
            max-width: 500px;
        }
    </style>
</head>
<body>

<%
    int specialEquipment = Integer.parseInt(request.getAttribute("specialEquipment").toString());
    int checkedInBaggage = Integer.parseInt(request.getAttribute("checkedInBaggage").toString());
    int extraCarryon = Integer.parseInt(request.getAttribute("extraCarryon").toString());
    int petCarryon = Integer.parseInt(request.getAttribute("petCarryon").toString());
    int foodOnFlight = Integer.parseInt(request.getAttribute("foodOnFlight").toString());
    int wifiOnFlight = Integer.parseInt(request.getAttribute("wifiOnFlight").toString());
    String[] checked = new String[]{"","","","","",""};
    Integer[] options = new Integer[]{specialEquipment, checkedInBaggage, extraCarryon, petCarryon, foodOnFlight, wifiOnFlight};
    for(int i = 0; i < checked.length; i++){
        if(options[i] > 0) { checked[i] = "checked"; }
    }
%>

<div class="jumbotron text-center">
    <h1>My Booking</h1>
    <p>The current details registered to your booking can be seen below.</p>
</div>

<h3 class="text-center">Passenger Information</h3>
<br/>

<form class="justify-content-center" action="MyBookingUpdate" method="post">
    <div class="form-group">
    First Name: <br>
    <input type="text" class="form-control" name="FirstName" value=${firstName} placeholder=${firstName}> <br>
    </div>

    <div class="form-group">
    Last Name:<br>
    <input type="text" class="form-control" name="LastName" value=${lastName} placeholder=${lastName}><br>
    </div>

    <div class="form-group">
    Email Address:<br>
    <input type="text" class="form-control" name="Email" value=${email} placeholder=${email} ><br>
    </div>

    <div class="form-group">
    Date of Birth:<br>
    <input type="text" class="form-control" name="DateOfBirth" value=${dateOfBirth} placeholder=${dateOfBirth}><br><br>
    </div>

    <h3 class="text-center">Extra Accommodations</h3>
    <br/>

    <div class="form-check">
        <label class="form-check-label">
            <input type="checkbox" class="form-check-input" name="Checked_in_Luggage" value="1" <%=checked[1]%>>Checked In Luggage
        </label>
    </div>
        
        
    <div class="form-check">
        <label class="form-check-label">
            <input type="checkbox" class="form-check-input" name="Extra_Carryon" value="1" <%=checked[2]%>>Extra Carry-on
        </label>
    </div>

    <div class="form-check">
        <label class="form-check-label">
            <input type="checkbox" class="form-check-input" name="Special_Equipment" value="1" <%=checked[0]%>>Special Equipment
        </label>
    </div>

    <div class="form-check">
        <label class="form-check-label">
            <input type="checkbox" class="form-check-input" name="Pet_CarryOn" value="1" <%=checked[3]%>>Pet Carry-on
        </label>
    </div>

    <div class="form-check">
        <label class="form-check-label">
            <input type="checkbox" class="form-check-input" name="Food_on_flight" value="1" <%=checked[4]%>>Food on flight
        </label>
    </div>

    <div class="form-check">
        <label class="form-check-label">
            <input type="checkbox" class="form-check-input" name="WiFi_on_flight" value="1" <%=checked[5]%>>WiFi on flight
        </label>
    </div>

    <br/>

    <input type="submit" class="btn btn-success" value="Submit">

    <br/><br/>

</form>

</body>
</html>
