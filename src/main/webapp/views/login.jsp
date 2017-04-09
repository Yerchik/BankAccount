<%--
  Created by IntelliJ IDEA.
  User: Yerchik
  Date: 08.03.2017
  Time: 12:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Login page!</h1>

<form action="/loginprocessing" method="post">
    <p>Input your credential:</p>

    <label for="login">Login:</label>
    <input name="username" id="login" type="text" placeholder="Login" required = "true">

    <label for="password">Password:</label>
    <input name="password" id="password" type="password" placeholder="Password" required="true">

    <button type="submit">Sign in!</button>


</form>
<sec:authorize access="isAnonymous()"><p><a href="/registration">Registration page</a></p></sec:authorize>


</body>
</html>
