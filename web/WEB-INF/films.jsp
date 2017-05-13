<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Ник
  Date: 01.03.17
  Time: 15:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Что-то про пленки</title>
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
        <table  style = "padding: 10px 0 10px 0;"class="simple-little-table" cellspacing='0'>
            <tr>
                <td>Код</td>
                <td>Цена</td>
                <td>Чувств.</td>
                <td>Количество</td>
                <td>Дата снимка</td>
                <td>Дата проявки</td>
                <td>Место проявки</td>
                <td>Хранение</td>
                <td>Тип пленки</td>
            </tr><!-- Table Header -->
            <c:forEach items="${films}" var="film">
                <tr>
                    <td>${film.idFilm}</td>
                    <td>${film.priceFilm}</td>
                    <td>${film.sensibility}</td>
                    <td>${film.numFrame}</td>
                    <td>${film.dateStartingSnapshot}</td>
                    <td>${film.dateManifestation}</td>
                    <td>${film.placeManifestation}</td>
                    <td>${film.placeStorage}</td>
                    <td>${film.idTypeOfFilm}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <div id = "footer"></div>
</div>

</body>
</html>