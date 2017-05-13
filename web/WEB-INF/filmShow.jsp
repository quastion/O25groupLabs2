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
    <title>Обзор пленок</title>
    <link rel="stylesheet" type="text/css" href="style.css" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body>
<div>
    <div id = "header">
        <h1>Фототека<h1>
    </div>
    <div id = "content">
        <ul>
            <li><a href = "#">Главная</a> </li>
        </ul>
        <table class="simple-little-table"
               style = "padding: 10px 0 10px 0;" cellspacing='0'>
            <tr>
                <td>Цена</td>
                <td>Чувств.</td>
                <td>Количество</td>
                <td>Дата снимка</td>
                <td>Дата проявки</td>
                <td>Место проявки</td>
                <td>Хранение</td>
                <td>Тип пленки</td>
                <td>Удалить</td>
            </tr><!-- Table Header -->
            <c:forEach items="${posts}" var="post">
                <tr>
                    <td>${post.priceFilm}</td>
                    <td>${post.sensibility}</td>
                    <td>${post.numFrame}</td>
                    <td>${post.dateStartingSnapshot}</td>
                    <td>${post.dateManifestation}</td>
                    <td>${post.placeManifestation}</td>
                    <td>${post.placeStorage}</td>
                    <td>${post.idTypeOfFilm}</td>
                    <td><a href="/delete?table=film&id=${post.idFilm}">Удалить</a> </td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <div id = "footer"></div>
</div>

</body>
</html>