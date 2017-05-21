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
    <title>Редактирование фото</title>
    <link rel="stylesheet" type="text/css" href="../style.css" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body>
<div>
    <div id = "header">
        <h1>Фототека</h1>
    </div>
    <div id = "content">
        <form action="/editpost?table=photo&id=${photo.idPhoto}" method="POST">
            <ul>
                <li><a href = "/menu">Главная</a> </li>
                <li><a><input type="submit" value="Сохранить"></a> </li>
            </ul>

            <table class="simple-little-table" style = "padding: 10px 0 10px 0;" cellspacing='0'>
                <tr>
                    <td>Дата печати</td>
                    <td>Размер</td>
                    <td>Количество</td>
                    <td>Цена</td>
                    <td>Хранение</td>
                    <td>Производитель</td>
                    <td>Бумаги</td>
                    <td>Пленка</td>
                </tr><!-- Table Header -->
                <tr>
                    <td><input name ="datePrinting" type="date" value="${photo.datePrinting}"></td>
                    <td><input name ="size" type="number" value="${photo.size}"></td>
                    <td><input name ="number" type="number" value="${photo.number}"></td>
                    <td><input name ="pricePhoto" type="number" value="${photo.pricePhoto}"></td>
                    <td><input name="placePhoto" type="text" value="${photo.placePhoto}"></td>
                    <td>
                        <select name="idDeveloper">
                            <option disabled>Выберите изготовителя</option>
                            <c:forEach items="${developers}" var="developer">
                                <option value="${developer.idDeveloper}"
                                        <c:if test="${developer.idDeveloper == photo.idDeveloper}">
                                            selected
                                        </c:if>
                                >${developer.name}</option>
                            </c:forEach>
                        </select>
                    </td>
                    <td>
                        <select name="idPaper">
                            <option disabled>Выберите тип бумаги</option>
                            <c:forEach items="${papers}" var="paper">
                                <option value="${paper.idPaper}"
                                        <c:if test="${paper.idPaper == photo.idPaper}">
                                            selected
                                        </c:if>
                                >${paper.typePaper}</option>
                            </c:forEach>
                        </select>
                    </td>
                    <td>
                        <select name="idFrame">
                            <option disabled>Выберите кадр</option>
                            <c:forEach items="${frames}" var="frame">
                                <option value="${frame.idFrame}"
                                        <c:if test="${frame.idFrame == photo.idFrame}">
                                            selected
                                        </c:if>
                                >Дата съемки:${frame.dateFrame}, место съемки:${frame.placeFrame}, тема:${frame.theme} </option>
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