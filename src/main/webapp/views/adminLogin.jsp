<%@page language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<a href="javascript:history.go(-1)" style="position:absolute; top:10px; left:30px">Go Back</a>
<h2>Alien Details</h2>

    <form:form action="/loginAdmin" modelAttribute="adminModel">

    <label for="username">Enter Admin Name:</label>
    <input type="text" id="username" name="username">
    <form:errors path="name" cssClass="error"/><br>
        <label for="password">Enter password:</label>
        <input type="password" id="password" name="password"><br>
        <form:errors path="password" cssClass="error"/><br>

    <input type="submit" value="Submit">
</form:form>

</body>
</html>