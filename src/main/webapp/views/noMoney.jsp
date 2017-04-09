<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Yerchik
  Date: 10.03.2017
  Time: 1:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<h1>You have no money</h1>
<p>Yuor ${currency.typeOfCurrency} balans is: ${balans}</p>
<p><a href="/withdraw">Try again</a></p>
<p><a href="/">Main menu</a></p>
</body>
</html>
