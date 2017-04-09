<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Yerchik
  Date: 08.03.2017
  Time: 11:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/resources/css/style.css">
</head>
<body>
<h1>hello</h1>
<p><sec:authentication property="name"/></p>
        <h2>${account.name} ${account.secondName}</h2>

<sec:authorize access="isAuthenticated()"><p><a href="/add">Add</a></p></sec:authorize>
<sec:authorize access="isAuthenticated()"><p><a href="/withdraw">Withdraw</a></p></sec:authorize>
<sec:authorize access="isAuthenticated()"><p><a href="/history">History of Transaction</a></p></sec:authorize>
<sec:authorize access="isAuthenticated()"><p><a href="/showBalans">Show Balans</a></p></sec:authorize>
<sec:authorize access="isAuthenticated()"><p><a href="/logout">Logout</a></p></sec:authorize>
</body>
</html>
