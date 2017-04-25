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
    <table border="1">
        <tr>
            <td>idFilm</td>
            <td>priceFilm</td>
            <td>sensibility</td>
            <td>numFrame</td>
            <td>dateStartingSnapshot</td>
            <td>dateManifestation</td>
            <td>placeManifestation</td>
            <td>placeStorage</td>
            <td>idTypeOfFilm</td>
            <td>Удалить</td>
        </tr>
        <c:forEach items="${posts}" var="post">
            <tr>
                <td>${post.idFilm}</td>
                <td>${post.priceFilm}</td>
                <td>${post.sensibility}</td>
                <td>${post.numFrame}</td>
                <td>${post.dateStartingSnapshot}</td>
                <td>${post.dateManifestation}</td>
                <td>${post.placeManifestation}</td>
                <td>${post.placeStorage}</td>
                <td>${post.idTypeOfFilm}</td>
                <td><a href="delete/table=${requestScope.table}&id=${post.idFilm}">Удалить</a></td>
            </tr>
        </c:forEach>
    </table>

</body>
</html>
