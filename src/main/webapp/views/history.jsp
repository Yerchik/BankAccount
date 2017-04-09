<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Yerchik
  Date: 09.03.2017
  Time: 22:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/resources/css/style.css">
</head>
<body>
<table>
    <tr>
        <th>amount</th>
        <th>currency</th>
        <th>type</th>
        <th>date</th>
    </tr>
    <c:forEach var="c" items="${transactions}">
        <tr>
            <td>${c.amount}</td>
            <td>${c.currency.typeOfCurrency}</td>
            <td>${c.type.type}</td>
            <td>${c.date}</td>
        </tr>
    </c:forEach>
</table>
<form action="/history" method="post">
    <label for="currency">Show for single currency:</label>
    <select name="currency" id="currency">
        <c:forEach var="c" items="${currencies}">
            <option value="${c.id}">${c.marking}</option>
        </c:forEach>
    </select>
    <button type="submit">Ok!</button>
</form>
<p><a href="/">Ok</a></p>


</body>
</html>
