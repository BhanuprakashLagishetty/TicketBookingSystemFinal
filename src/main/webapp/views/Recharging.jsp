<%@page language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<a href="javascript:history.go(-1)" style="position:absolute; top:10px; left:30px">Go Back</a>
<h2>Recharge</h2>

<form:form action="Recharging" >

    <label for="balance">Enter Amount:</label>
    <input type="number" id="balance" name="balance">
    <form:errors path="seatNumber" cssClass="error"/><br>
        <input type="submit" value="Submit">
</form:form>

</body>
</html>