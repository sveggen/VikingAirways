<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/templates/navbar.jsp" />
<html>
<head>
    <title>Viking Airways - Show Boarding Pass</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

    <style>
        .pdfobject-container {
            width: 75%;
            height: 500px;
            margin: auto;
        }
        a {
            display: block;
            margin: auto;
        }
    </style>

</head>
<body>


<div class="jumbotron text-center">
    <h1>Your Boarding Pass</h1>
    <p>Your boarding pass can be found below. Thank you for flying Viking Airways!</p>
</div>

<div class="container">
    <div class="row">
    <div id="pdf1"></div>
    </div>
</div>
<br/>
<div class="container">
    <div class="row">
    <a href="boardingpasses/${fileName}" download><button class="btn btn-success center-block">Download</button></a>
    </div>
</div>

<script src="https://cdnjs.cloudflare.com/ajax/libs/pdfobject/2.1.1/pdfobject.min.js"></script>
<script>
    PDFObject.embed("boardingpasses/${fileName}", "#pdf1");
</script>

</body>
</html>
