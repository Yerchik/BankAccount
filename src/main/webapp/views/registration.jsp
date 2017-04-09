<%--
  Created by IntelliJ IDEA.
  User: Yerchik
  Date: 08.03.2017
  Time: 12:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/registration" method="post">

    <label for="name">Name:</label>
    <input name="name" id="name" type="text">

    <label for="secondName">Second name:</label>
    <input name="secondName" id="secondName" type="text">

    <label for="login">Login:</label>
    <input name="login" id="login" type="text">

    <label for="password">Password:</label>
    <input name="password" id="password" type="password">



    <button type="submit">Registration!</button>
</form>

</body>
</html>
