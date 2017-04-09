<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Yerchik
  Date: 09.03.2017
  Time: 23:49
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
<p><a href="/history">All history</a></p>
<p><a href="/">Main menu</a></p>
</body>
</html>
