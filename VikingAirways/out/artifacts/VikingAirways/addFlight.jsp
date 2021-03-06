<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/templates/navbar.jsp" />
<!DOCTYPE html>
<html>
<head>
    <title>Viking Airways - Cheap flights with comfort</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <!--<link rel="stylesheet" href="stylesheets/globalStyle.css">-->
    <style>
        form {
            margin: auto;
            max-width: 500px;
        }
    </style>
</head>
<body>
<div class="jumbotron text-center">
    <h1>Add flight</h1>
</div>
<div>
        <form action="AddFlight" method="post">
            <h5>Enter the correct information to add a flight</h5>
            <div class="text-center">
                <div style="color: #008f11;">${flightAdded}</div><br>
                <div style="color: #FF0000;">${flightNotAdded}</div><br>
            <div class ="form-group">
            <input type="text" placeHolder="Flight Number" name="flight_number" class="form-control"/>
            </div>
            <div class ="form-group">
            <input type="text" placeHolder="Date of departure (YYYY-MM-DD)" name="departure_date" class="form-control"/>
            </div>
            <div class ="form-group">
            <input type="text" placeHolder="Time of departure (HH:MM:SS)" name="departure_time" class="form-control"/>
            </div>
            <div class ="form-group">
            <input type="text" placeHolder="Name of arrival airport" name="arrival_airport" class="form-control"/>
            </div>
            <div class ="form-group">
            <input type="text" placeHolder="Name of departure airport" name="departure_airport" class="form-control"/>
            </div>
            <div class ="form-group">
            <input type="text" placeHolder="Time of arrival (HH:MM:SS)" name="arrival_time" class="form-control"/>
            </div>
            <div class ="form-group">
                <input type="text" placeHolder="Class Type" name="class_type1" class="form-control"/>
            </div>
            <div class ="form-group">
                <input type="text" placeHolder="Class Capacity" name="class_capacity1" class="form-control"/>
            </div>
            <div class ="form-group">
                <input type="text" placeHolder="Class Price" name="class_price1" class="form-control"/>
            </div>
            <div class ="form-group">
                <input type="text" placeHolder="Flight Number" name="class_flight_fk1" class="form-control"/>
            </div>
            <div class ="form-group">
                <input type="text" placeHolder="Class Type" name="class_type2" class="form-control"/>
            </div>
            <div class ="form-group">
                <input type="text" placeHolder="Class Capacity" name="class_capacity2" class="form-control"/>
            </div>
            <div class ="form-group">
                <input type="text" placeHolder="Class Price" name="class_price2" class="form-control"/>
            </div>
            <div class ="form-group">
                <input type="text" placeHolder="Flight Number" name="class_flight_fk2" class="form-control"/>
            </div>
            <div class ="form-group">
                <input type="text" placeHolder="Class Type" name="class_type3" class="form-control"/>
            </div>
            <div class ="form-group">
                <input type="text" placeHolder="Class Capacity" name="class_capacity3" class="form-control"/>
            </div>
            <div class ="form-group">
                <input type="text" placeHolder="Class Price" name="class_price3" class="form-control"/>
            </div>
            <div class ="form-group">
                <input type="text" placeHolder="Flight Number" name="class_flight_fk3" class="form-control"/>
            </div>
            <div class ="form-group">
            <input type="submit" value="Add" name="add"/>
            </div>
            </div>
        </form>
</div>
</body>
</html>