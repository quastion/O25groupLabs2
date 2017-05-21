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
    <link rel="stylesheet" type="text/css" href="../style.css" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body>
<div>
    <div id = "header">
        <a href="/menu" class="without_"><h1>Фототека</h1></a>
    </div>
    <div id = "content">
        <ul>
            <li><a href = "/menu">Главная</a> </li>
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
                <td>Рейтинг</td>
                <td>Рейтинг пользователя</td>
                <td>Редактировать</td>
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
                    <td>${post.typeOfFilm}</td>
                    <%--<td>${post.rating}</td>--%>
                    <td>
                        <div id="reviewStars-input" style="width:150px;">
                            <input id="star-4" type="radio" name="reviewStars"/>
                            <label title="gorgeous" for="star-4"></label>

                            <input id="star-3" type="radio" name="reviewStars"/>
                            <label title="good" for="star-3"></label>

                            <input id="star-2" type="radio" name="reviewStars"/>
                            <label title="regular" for="star-2"></label>

                            <input id="star-1" type="radio" name="reviewStars"/>
                            <label title="poor" for="star-1"></label>

                            <input id="star-0" type="radio" name="reviewStars"/>
                            <label title="bad" for="star-0"></label>
                        </div>
                    </td>
                    <td>
                        <div id="1reviewStars-input" style="width:150px;">
                            <input id="1star-4" type="radio" name="reviewStars"/>
                            <label title="gorgeous" for="star-4"></label>

                            <input id="1star-3" type="radio" name="reviewStars"/>
                            <label title="good" for="star-3"></label>

                            <input id="1star-2" type="radio" name="reviewStars"/>
                            <label title="regular" for="star-2"></label>

                            <input id="1star-1" type="radio" name="reviewStars"/>
                            <label title="poor" for="star-1"></label>

                            <input id="1star-0" type="radio" name="reviewStars"/>
                            <label title="bad" for="star-0"></label>
                        </div>
                    </td>
                    <td><a href="/edit?table=film&id=${post.idFilm}">Редактировать</a> </td>
                    <td><a href="/delete?table=film&id=${post.idFilm}">Удалить</a> </td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <div id = "footer"></div>
</div>

</body>
</html>