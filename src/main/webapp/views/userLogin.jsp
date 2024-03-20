<%@page language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<a href="javascript:history.go(-1)" style="position:absolute; top:10px; left:30px">Go Back</a>
<h2>User Login</h2>

    <form:form action="loginUser" modelAttribute="UserModel">

    <label for="name">Enter User Name:</label>
    <input type="text" id="name" name="userName">
    <form:errors path="name" cssClass="error"/><br>
        <label for="password">Enter Password:</label>
        <input type="password" id="password" name="password"><br>
        <form:errors path="password" cssClass="error"/><br>

    <input type="submit" value="Submit">
    <a href="UserRegistration">create account?</a>
</form:form>



</body>
</html>