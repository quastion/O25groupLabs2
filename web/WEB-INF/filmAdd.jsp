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
    <title>Films</title>
    <link rel="stylesheet" type="text/css" href="style.css"/>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body>
<div>
    <div id = "header">
        <h1>Фототека<h1>
    </div>
    <div id = "content">
        <ul>
            <li><a href="/addpost?table=film" method="POST">Добавить</a>
        </ul>

        <table class="simple-little-table" cellspacing='0'>
            <tr>
                <th>Цена</th>
                <th>Чувств.</th>
                <th>Количество</th>
                <th>Дата снимка</th>
                <th>Дата проявки</th>
                <th>Место проявки</th>
                <th>Хранение</th>
                <th>Тип пленки</th>
            </tr><!-- Table Header -->

            <tr>
                <th><input name ="priceFilm" type="number"></th>
                <th><input name ="sensibility" type="number"></th>
                <th><input name ="numFrame" type="number"></th>
                <th><input name ="dateStartingSnapshot" type="date"></th>
                <th><input name ="dateManifestation" type="date"></th>
                <th><input name ="placeManifestation" type="text"></th>
                <th><input name="placeStorage" type="text"></th>
                <th>
                    <select name="idTypeOfFilm">
                        <option disabled>Выберите тип пленки</option>
                        <c:forEach items="${posts}" var="post">
                            <option value="${post.idTypeOfFilm}">${post.typeFilm}</option>
                        </c:forEach>
                    </select>
                </th>
            </tr>
        </table>
    </div>
    <div id = "footer"></div>
</div>
</body>
</html>