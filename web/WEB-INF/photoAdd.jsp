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
    <title>Title</title>
</head>
<body>
    <form action="/addpost?table=photo" method="POST">
    <table border="1">
        <tr>
            <td>datePrinting</td>
            <td>size</td>
            <td>number</td>
            <td>pricePhoto</td>
            <td>placePhoto</td>
            <td>idDeveloper</td>
            <td>idPaper</td>
            <td>idFrame-idFilm</td>
        </tr>
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

    <input type="submit" value="Добавить">
    </form>

</body>
</html>
