<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: fil-n
  Date: 19.05.17
  Time: 16:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ошибка</title>
    <link rel="stylesheet" type="text/css" href="style.css" />
</head>
<body>
<div id = "header">

    <h1>${e}</h1>
</div>
<div id = "content">
    <ul>
        <li>
    <c:if test="${code == 1}">
        <a href="/"> < авторизация</a>
    </c:if>
    <c:if test="${code == 2}">
        <a href="/menu"> < меню</a>
    </c:if>
        </li>
        </ul>
</div>
</body>
</html>
