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
    <title>Films</title>
    <link rel="stylesheet" type="text/css" href="style.css" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body>
<div>
    <div id = "header">
        <h1>Фототека<h1>
    </div>
    <div id = "content">
        <table class="simple-little-table" cellspacing='0'>
            <tr>
                <th>Код</th>
                <th>Цена</th>
                <th>Чувств.</th>
                <th>Количество</th>
                <th>Дата снимка</th>
                <th>Дата проявки</th>
                <th>Место проявки</th>
                <th>Хранение</th>
                <th>Тип пленки</th>
            </tr><!-- Table Header -->
            <c:forEach items="${films}" var="film">
                <tr>
                    <th>${film.idFilm}</th>
                    <th>${film.priceFilm}</th>
                    <th>${film.sensibility}</th>
                    <th>${film.numFrame}</th>
                    <th>${film.dateStartingSnapshot}</th>
                    <th>${film.dateManifestation}</th>
                    <th>${film.placeManifestation}</th>
                    <th>${film.placeStorage}</th>
                    <th>${film.idTypeOfFilm}</th>
                </tr>
            </c:forEach>
        </table>
    </div>
    <div id = "footer"></div>
</div>

</body>
</html>