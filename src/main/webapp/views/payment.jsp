<%@page language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<a href="javascript:history.go(-1)" style="position:absolute; top:10px; left:30px">Go Back</a>
<h2>Seat Details</h2>

<form:form action="ticketsPayments" modelAttribute="paymentModel">

    <label for="bookingId">Enter Booking Id:</label>
    <input type="text" id="id" name="bookingId" value=${bookingId}>
    <form:errors path="id" cssClass="error"/><br>
     <label for="amount">Enter amount :</label>
     <input type="number" id="amount" name="amount" value=${price}>
     <form:errors path="amount" cssClass="error"/><br>
    <input type="submit" value="Submit">
</form:form>

</body>
</html>
