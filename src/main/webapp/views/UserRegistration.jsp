<%@page language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<a href="javascript:history.go(-1)" style="position:absolute; top:10px; left:30px">Go Back</a>
<h2>User Registarions</h2>

    <form:form action="AddUser" modelAttribute="UserModel">

    <label for="userName">Enter User Name:</label>
    <input type="text" id="userName" name="userName">
      <p style="color:red;font-size:14px;">
        <form:errors path="userName" cssClass="error"/><br>
        ${userfound}
    </p>
        <label for="password">Enter Password:</label>
        <input type="password" id="password" name="password"><br>
        <form:errors path="password" cssClass="error"/><br>

        <label for="age">Enter age:</label>
          <input type="number" id="age" name="age" ><br>
          <p style="color:red;font-size:14px;">
          <form:errors path="age" cssClass="error"/><br>
          </p>

        <label for="email">Enter email:</label>
        <input type="text" id="email" name="email" ><br>
         <form:errors path="email" cssClass="error"/><br>

    <input type="submit" value="Submit">
</form:form>

</body>
</html>