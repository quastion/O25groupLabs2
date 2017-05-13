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
        <form action="/addpost?table=photo" method="POST">
            <ul>
                <li><a href = "#">Главная</a> </li>
                <li><a><input type="submit" value="Добавить"></a> </li>
            </ul>

            <table class="simple-little-table" style = "padding: 10px 0 10px 0;" cellspacing='0'>
                <tr>
                    <td>Дата печати</td>
                    <td>Размер</td>
                    <td>Количество</td>
                    <td>Цена</td>
                    <td>Хранение</td>
                    <td>Код производителя</td>
                    <td>Код бумаги</td>
                    <td>Код пленки</td>
                </tr><!-- Table Header -->
                <tr>
                    <td><input name ="datePrinting" type="date"></td>
                    <td><input name ="size" type="number"></td>
                    <td><input name ="number" type="number"></td>
                    <td><input name ="pricePhoto" type="number"></td>
                    <td><input name="placePhoto" type="text"></td>
                    <td>
                        <select name="idDeveloper">
                            <option disabled>Выберите изготовителя</option>
                            <c:forEach items="${developers}" var="developer">
                                <option value="${developer.idDeveloper}">${developer.name}</option>
                            </c:forEach>
                        </select>
                    </td>
                    <td>
                        <select name="idPaper">
                            <option disabled>Выберите тип бумаги</option>
                            <c:forEach items="${papers}" var="paper">
                                <option value="${paper.idPaper}">${paper.typePaper}</option>
                            </c:forEach>
                        </select>
                    </td>
                    <td>
                        <select name="idFrame">
                            <option disabled>Выберите кадр</option>
                            <c:forEach items="${frames}" var="frame">
                                <option value="${frame.idFrame}">Дата съемки:${frame.dateFrame}, место съемки:${frame.placeFrame}, тема:${frame.theme} </option>
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