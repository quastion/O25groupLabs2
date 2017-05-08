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
        <ul>
            <li><a href="/addpost?table=photo" method="POST">Добавить</a>
        </ul>

        <table class="simple-little-table" cellspacing='0'>
            <tr>
                <th>Дата печати</th>
                <th>Размер</th>
                <th>Количество</th>
                <th>Цена</th>
                <th>Хранение</th>
                <th>Код производителя</th>
                <th>Код бумаги</th>
                <th>Код пленки</th>
            </tr><!-- Table Header -->
            <tr>
                <th><input name ="datePrinting" type="date"></th>
                <th><input name ="size" type="number"></th>
                <th><input name ="number" type="number"></th>
                <th><input name ="pricePhoto" type="number"></th>
                <th><input name="placePhoto" type="text"></th>
                <th>
                    <select name="idDeveloper">
                        <option disabled>Выберите изготовителя</option>
                        <c:forEach items="${developers}" var="developer">
                            <option value="${developer.idDeveloper}">${developer.name}</option>
                        </c:forEach>
                    </select>
                </th>
                <th>
                    <select name="idPaper">
                        <option disabled>Выберите тип бумаги</option>
                        <c:forEach items="${papers}" var="paper">
                            <option value="${paper.idPaper}">${paper.typePaper}</option>
                        </c:forEach>
                    </select>
                </th>
                <th>
                    <select name="idFrame">
                        <option disabled>Выберите кадр</option>
                        <c:forEach items="${frames}" var="frame">
                            <option value="${frame.idFrame}">Дата съемки:${frame.dateFrame}, место съемки:${frame.placeFrame}, тема:${frame.theme} </option>
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