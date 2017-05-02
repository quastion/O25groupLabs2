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
            <td>datePrinting</td>
            <td>size</td>
            <td>number</td>
            <td>pricePhoto</td>
            <td>placePhoto</td>
            <td>idDeveloper</td>
            <td>idPaper</td>
            <td>idFrame</td>
            <td>idFilm</td>
            <td>Удалить</td>
        </tr>
        <c:forEach items="${posts}" var="post">
            <tr>
                <td>${post.datePrinting}</td>
                <td>${post.size}</td>
                <td>${post.number}</td>
                <td>${post.pricePhoto}</td>
                <td>${post.placePhoto}</td>
                <td>${post.idDeveloper}</td>
                <td>${post.idPaper}</td>
                <td>${post.idFrame}</td>
                <td>${post.idFilm}</td>
                <td><a href="/delete?table=photo&id=${post.idPhoto}">Удалить</a> </td>
            </tr>
        </c:forEach>
    </table>

</body>
</html>
