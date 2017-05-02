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
<form action="/addpost?table=frame" method="POST">
    <table border="1">
        <tr>
            <td>dateFrame</td>
            <td>placeFrame</td>
            <td>theme</td>
            <td>idFilm</td>
        </tr>
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

    <input type="submit" value="Добавить">
</form>
</body>
</html>
