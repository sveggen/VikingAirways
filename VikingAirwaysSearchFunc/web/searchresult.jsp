<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <style type="text/css">
        #flights {
            font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
            border-collapse: collapse;
        }
        #flights td, #flights th{
            border: 1px solid #ddd;
            padding: 8px;
        }

        #flights tr:nth-child(even){background-color: #f2f2f2;}
        #flights tr:nth-child(odd){background-color: #EBFFEE;}
        #flights tr:hover{background-color: #ddd;}
        #flights th{
            padding-top: 12px;
            padding-bottom: 12px;
            text-align: left;
            background-color: #0FA268;/*#4CAF50;*/
            color: white;
        }
    </style>
    <title>Book a flight</title>
</head>
<body>
<h2 style="text-align:center">Book a flight</h2>
<p style="text-align:center">
    Date: <strong> 11.14.2019</strong>
</p>

<table id="flights" style="width:70%;margin:auto">
    <tr>
        <th>From</th>
        <th>Departure</th>
        <th>To</th>
        <th>Arrival</th>
        <th>Travel Class</th>
        <th>Price</th>
        <th></th>
    </tr>


    <tr>
        <td>Kristiansand <strong>KRS</strong></td>
        <td>12.40</td>
        <td>Barcelona <strong>BCN</strong></td>
        <td>16.50</td>
        <td>
            <div>
                <label for="trvlcls1">Travel Class</label>
                <select name="Travel Class" id="trvlcls1">
                    <option value="Economy">Economy</option>
                    <option value="Business">Business</option>
                    <option value="First Class">First Class</option>
                </select>
            </div>
        </td>
        <td><strong>3499,-</strong></td>
        <td><button>Book Now</button></td>
    </tr>



    <tr>
        <td>Kristiansand <strong>KRS</strong></td>
        <td>19.40</td>
        <td>Barcelona <strong>BCN</strong></td>
        <td>23.50</td>
        <td>
            <div>
                <label for="trvlcls2">Travel Class</label>
                <select name="Travel Class" id="trvlcls2">
                    <option value="Economy">Economy</option>
                    <option value="Business">Business</option>
                    <option value="First Class">First Class</option>
                </select>
            </div>
        </td>
        <td><strong>4399,-</strong></td>
        <td><button>Book Now</button></td>
    </tr>

    <tr>
        <td>Kristiansand <strong>KRS</strong></td>
        <td>19.40</td>
        <td>Barcelona <strong>BCN</strong></td>
        <td>23.50</td>
        <td>
            <div>
                <label for="trvlcls3">Travel Class</label>
                <select name="Travel Class" id="trvlcls3">
                    <option value="Economy">Economy</option>
                    <option value="Business">Business</option>
                    <option value="First Class">First Class</option>
                </select>
            </div>
        </td>
        <td><strong>4399,-</strong></td>
        <td><button>Book Now</button></td>
    </tr>

</table>

</body>
</html>