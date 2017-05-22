<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: fil-n
  Date: 22.04.17
  Time: 16:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Обзор снимков</title>
    <link rel="stylesheet" type="text/css" href="../style.css" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body>
<div>
    <div id = "header">
        <h1>Фототека</h1>
    </div>
    <div id = "content">
        <ul>
            <li><a href = "/menu">Главная</a> </li>
        </ul>
        <table class="simple-little-table"
               style = "padding: 10px 0 10px 0;" cellspacing='0'>
            <tr>
                <td>Дата снимка</td>
                <td>Хранение</td>
                <td>Тема</td>
                <td>Пленка</td>
                <c:if test="${edit == true}">
                    <td>Редактировать</td>
                </c:if>
                <c:if test="${delete == true}">
                    <td>Удалить</td>
                </c:if>
            </tr><!-- Table Header -->
            <c:forEach items="${posts}" var="post">
                <tr>
                    <td>${post.dateFrame}</td>
                    <td>${post.placeFrame}</td>
                    <td>${post.theme}</td>
                    <td>
                        Чувств-ть: ${post.film.sensibility},
                        кол-во кадров: ${post.film.numFrame},
                        дата съемки: ${post.film.dateStartingSnapshot},
                        место проявления: ${post.film.placeManifestation}
                    </td>
                    <c:if test="${edit == true}">
                        <td><a href="/edit?table=frame&id=${post.idFrame}">Редактировать</a></td>
                    </c:if>
                    <c:if test="${delete == true}">
                        <td><a href="/delete?table=frame&id=${post.idFrame}">Удалить</a></td>
                    </c:if>
                </tr>
            </c:forEach>
        </table>
    </div>
    <div id = "footer"></div>
</div>

</body>
</html>