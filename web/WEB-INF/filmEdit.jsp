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
    <title>Добавление пленку</title>
    <link rel="stylesheet" type="text/css" href="../style.css"/>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body>
<div>
    <div id = "header">
        <h1>Фототека</h1>
    </div>
    <div id = "content">
        <form action="/editpost?table=film&id=${film.idFilm}" method="POST">
            <ul>
                <li><a href = "/menu">Главная</a> </li>
                <li><a><input type="submit" value="Сохранить"></a> </li>
            </ul>

            <table style = "padding: 10px 0 10px 0;" class="simple-little-table" cellspacing='0'>
                <tr>
                    <td>Цена</td>
                    <td>Чувств.</td>
                    <td>Количество</td>
                    <td>Дата снимка</td>
                    <td>Дата проявки</td>
                    <td>Место проявки</td>
                    <td>Хранение</td>
                    <td>Тип пленки</td>
                </tr><!-- Table Header -->

                <tr>

                    <td><input name ="priceFilm" type="number" value="${film.priceFilm}"></td>
                    <td><input name ="sensibility" type="number" value="${film.sensibility}"></td>
                    <td><input name ="numFrame" type="number" value="${film.numFrame}" /></td>
                    <td><input name ="dateStartingSnapshot" type="date" value="${film.dateStartingSnapshot}"></td>
                    <td><input name ="dateManifestation" type="date" value="${film.dateManifestation}"></td>
                    <td><input name ="placeManifestation" type="text" value="${film.placeManifestation}"></td>
                    <td><input name="placeStorage" type="text" value="${film.placeStorage}"></td>
                    <td>
                        <select name="idTypeOfFilm">
                            <option disabled>Выберите тип пленки</option>
                            <c:forEach items="${posts}" var="post">
                                <option value="${post.idTypeOfFilm}"
                                    <c:if test="${post.idTypeOfFilm == film.idTypeOfFilm}">
                                        selected
                                    </c:if>
                                >${post.typeFilm}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
            </table>
        </form>
    </div>
    <div id = "footer"></div>
</div>
</body>
</html>