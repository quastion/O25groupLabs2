<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Ник
  Date: 01.03.17
  Time: 15:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Films</title>
</head>
<body>
<table border="=1">
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
    </tr>
    <c:forEach items="${films}" var="film">
        <tr>
            <td>${film.idFilm}</td>
            <td>${film.priceFilm}</td>
            <td>${film.sensibility}</td>
            <td>${film.numFrame}</td>
            <td>${film.dateStartingSnapshot}</td>
            <td>${film.dateManifestation}</td>
            <td>${film.placeManifestation}</td>
            <td>${film.placeStorage}</td>
            <td>${film.idTypeOfFilm}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
