<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Yerchik
  Date: 09.03.2017
  Time: 16:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/resources/css/style.css">
</head>
<body>

<form action="/add" method="post">
    <label for="amount">Amount:</label>
    <input name="amount" id="amount" type="text">

    <label for="currency">Currency:</label>
    <select name="currency" id="currency">
        <c:forEach var="c" items="${currencies}">
            <option value="${c.id}">${c.marking}</option>
        </c:forEach>
    </select>

    <button type="submit">Add!</button>
</form>
<p><a href="/">Main menu</a></p>
</body>
</html>
