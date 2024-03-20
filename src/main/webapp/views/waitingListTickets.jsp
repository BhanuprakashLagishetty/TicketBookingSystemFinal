<%@page language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<a href="javascript:history.go(-1)" style="position:absolute; top:10px; left:30px">Go Back</a>
<h2>Alien Details</h2>

<form:form action="waitingListTickets" >

    <label for="numberOfSeats">Enter No OF Seats Required</label>
    <input type="number" id="numberOfSeats" name="numberOfSeats">
    <form:errors path="name" cssClass="error"/><br>
    <label for="typeOfSeat">Select Type of Seat:</label>
        <select id="typeOfSeat" name="typeOfSeat">
            <option value="Ac">AC</option>
            <option value="General">General</option>
            <option value="Sleeper">Sleeper</option>
        </select><br>



    <input type="submit" value="Submit">
</form:form>

</body>
</html>