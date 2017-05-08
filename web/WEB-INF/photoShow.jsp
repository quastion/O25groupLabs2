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
                <th>Дата печати</th>
                <th>Размер</th>
                <th>Количество</th>
                <th>Цена</th>
                <th>Хранение</th>
                <th>Код производителя</th>
                <th>Код бумаги</th>
                <th>Код кадра</th>
                <th>Код пленки</th>
                <th>Удалить</th>
            </tr><!-- Table Header -->
            <c:forEach items="${posts}" var="post">
                <tr>
                    <th>${post.datePrinting}</th>
                    <th>${post.size}</th>
                    <th>${post.number}</th>
                    <th>${post.pricePhoto}</th>
                    <th>${post.placePhoto}</th>
                    <th>${post.idDeveloper}</th>
                    <th>${post.idPaper}</th>
                    <th>${post.idFrame}</th>
                    <th>${post.idFilm}</th>
                    <th><a href="/delete?table=photo&id=${post.idPhoto}">Удалить</a> </th>
                </tr>
            </c:forEach>
        </table>
    </div>
    <div id = "footer"></div>
</div>

</body>
</html>