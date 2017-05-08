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
    <title>Пленки</title>
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
                <th>Цена</th>
                <th>Чувств.</th>
                <th>Количество</th>
                <th>Дата снимка</th>
                <th>Дата проявки</th>
                <th>Место проявки</th>
                <th>Хранение</th>
                <th>Тип пленки</th>
                <th>Удалить</th>
            </tr><!-- Table Header -->
            <c:forEach items="${posts}" var="post">
                <tr>
                    <th>${post.priceFilm}</th>
                    <th>${post.sensibility}</th>
                    <th>${post.numFrame}</th>
                    <th>${post.dateStartingSnapshot}</th>
                    <th>${post.dateManifestation}</th>
                    <th>${post.placeManifestation}</th>
                    <th>${post.placeStorage}</th>
                    <th>${post.idTypeOfFilm}</th>
                    <th><a href="/delete?table=film&id=${post.idFilm}">Удалить</a> </td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <div id = "footer"></div>
</div>

</body>
</html>