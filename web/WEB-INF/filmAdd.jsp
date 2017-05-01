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
    <form action="/addpost?table=film" method="POST">
    <table border="1">
        <tr>
            <td>priceFilm</td>
            <td>sensibility</td>
            <td>numFrame</td>
            <td>dateStartingSnapshot</td>
            <td>dateManifestation</td>
            <td>placeManifestation</td>
            <td>placeStorage</td>
            <td>TypeOfFilm</td>
        </tr>

        <tr>

            <td><input name ="priceFilm" type="number"></td>
            <td><input name ="sensibility" type="number"></td>
            <td><input name ="numFrame" type="number"></td>
            <td><input name ="dateStartingSnapshot" type="date"></td>
            <td><input name ="dateManifestation" type="date"></td>
            <td><input name ="placeManifestation" type="text"></td>
            <td><input name="placeStorage" type="text"></td>
            <td>
                <select name="idTypeOfFilm">
                       <option disabled>Выберите тип пленки</option>
                       <c:forEach items="${posts}" var="post">
                           <option value="${post.idTypeOfFilm}">${post.typeFilm}</option>
                       </c:forEach>
                </select>


            </td>
        </tr>
    </table>

    <input type="submit" value="Добавить">
    </form>

</body>
</html>
