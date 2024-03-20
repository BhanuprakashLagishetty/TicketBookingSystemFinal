<%@page language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<a href="javascript:history.go(-1)" style="position:absolute; top:10px; left:30px">Go Back</a>
<h2>Alien Details</h2>

<form:form action="addTrain" modelAttribute="TrainModel">

    <label for="name">Enter Train Name:</label>
    <input type="text" id="name" name="name">
    <form:errors path="name" cssClass="error"/><br>
    </p>
        <label for="arrivalStation">Enter ArrivalStation:</label>
        <input type="text" id="arrivalStation" name="arrivalStation"><br>
        <form:errors path="arrivalStation" cssClass="error"/><br>

        <label for="departureStation">Enter Departure Station:</label>
          <input type="text" id="departureStation" name="departureStation" ><br>
          <form:errors path="departureStation" cssClass="error"/><br>

        <label for="arrivalTime">Enter ArrivalTime:</label>
        <input type="time" id="arrivalTime" name="arrivalTime" ><br>
         <form:errors path="arrivalTime" cssClass="error"/><br>

          <label for="departureTime">Enter departureTime:</label>
          <input type="time" id="departureTime" name="departureTime" ><br>
          <form:errors path="departureTime" cssClass="error"/><br>


    <input type="submit" value="Submit">
</form:form>

</body>
</html>