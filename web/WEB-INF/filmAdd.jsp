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
        </tr>
            <tr>
                <td></td>
                <td><input type="number">
                </td>
                <td><input type="number"></td>
                <td><input type="number"></td>
                <td><input type="date"></td>
                <td><input type="date"></td>
                <td><input type="text"></td>
                <td><input type="text"></td>
                <td></td>
            </tr>
    </table>

    <input type="submit" value="Добавить">

</body>
</html>
