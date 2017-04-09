<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Yerchik
  Date: 09.03.2017
  Time: 16:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Your balans: ${balans} </h1>
<c:forEach var="c" items="${currencies}">
    <p><a href="/balans/${c.id}">${c.typeOfCurrency}</a></p>
</c:forEach>
<p><a href="/">Main menu</a></p>
</body>
</html>
