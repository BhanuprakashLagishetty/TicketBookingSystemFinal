<%@page language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<a href="javascript:history.go(-1)" style="position:absolute; top:10px; left:30px">Go Back</a>
<h2>Seat Details</h2>

<form:form action="AddingStationsToTrain" modelAttribute="Stations">

    <label for="stationName">Enter stationName:</label>
    <input type="text" id="stationName" name="stationName">
    <form:errors path="seatNumber" cssClass="error"/><br>
      <label for="km">Enter kilometers:</label>
        <input type="text" id="km" name="km">
        <form:errors path="km" cssClass="error"/><br>
        <input type="submit" value="Submit">
</form:form>

</body>
</html>