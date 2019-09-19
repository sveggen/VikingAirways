<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>

    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <style> /*type="text/css"*/
        * {
              box-sizing: border-box;
          }
          body {
              height: 100%;
              width: 100%;
          }
          form {
              margin: auto;
              max-width: 500px;
              position: absolute;
              top: 35%;
              right: 0;
              left: 0;
          }
        /*#flights {
            font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
            border-collapse: collapse;
        }
        #flights td, #flights th{
            border: 1px solid #ddd;
            padding: 8px;
        }

        #flights tbody:nth-child(even){background-color: #f2f2f2;}
        #flights tbody:nth-child(odd){background-color: #FFFFFF;}
        #flights tbody:hover{background-color: #ddd;}
        #flights th{
            padding-top: 12px;
            padding-bottom: 12px;
            text-align: left;
            background-color: #4CAF50;
            color: white;
        }*/
    </style>
    <title>Choose a flight</title>
</head>
<body>
   <div class="container">
        <div class="jumbotron">
            <h1 id="flights" style="text-align:center">Choose a flight</h1> 
            <p id="flights" style="text-align:center">Date: <strong> 11.14.2019</strong></p>
         </div>
    <table class="table"> <!--id="flights"-->
        <thead class="thead-light">
            <th>From</th>
            <th>Departure</th>
            <th>To</th>
            <th>Arrival</th>
            <th>Travel Class</th>
            <th>Price</th>
            <th></th>
        </thead>


        <tbody>
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
            <td><button type="button" class="btn btn-success">Choose flight</button></td>
        </tbody>



        <tbody>
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
            <td><button type="button" class="btn btn-success">Choose flight</button></td>
        </tbody>

        <tbody>
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
            <!--<td><button>Book Now</button></td>-->
            <td><button type="button" class="btn btn-success">Choose flight</button></td>
        </tbody>

    </table>
    </div>
    </div>
    </body>
</html>