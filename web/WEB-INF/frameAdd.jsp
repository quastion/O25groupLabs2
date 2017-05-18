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
    <title>Добавить снимок</title>
    <link rel="stylesheet" type="text/css" href="../style.css" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body>
<div>
    <div id = "header">
        <h1>Фототека</h1>
    </div>
    <div id = "content">
        <form action="/addpost?table=frame" method="POST">
            <ul>
                <li><a href = "/menu">Главная</a> </li>
                <li><a><input type="submit" value="Добавить"></a> </li>
            </ul>

            <table class="simple-little-table"
                   style = "padding: 10px 0 10px 0;" cellspacing='0'>
                <tr>
                    <td>Дата снимка</td>
                    <td>Хранение</td>
                    <td>Тема</td>
                    <td>Код пленки</td>
                </tr><!-- Table Header -->
                <tr>
                    <td><input name ="dateFrame" type="date"></td>
                    <td><input name="placeFrame" type="text"></td>
                    <td><input name="theme" type="text"></td>
                    <td>
                        <select name="idFilm">
                            <option disabled>Выберите пленку</option>
                            <c:forEach items="${posts}" var="post">
                                <option value="${post.idFilm}">Цена:${post.priceFilm},чув-ть:${post.sensibility} , дата съемки: ${post.dateStartingSnapshot}</option>
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