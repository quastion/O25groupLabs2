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
    <form action="/addpost?table=member" method="POST">
    <table border="1">
        <tr>
            <td>surname</td>
            <td>name</td>
            <td>middleName</td>
        </tr>
        <tr>
            <td><input name="surname" type="text"></td>
            <td><input name="name" type="text"></td>
            <td><input name="middleName" type="text"></td>
        </tr>
    </table>

    <input type="submit" value="Добавить">
    </form>

</body>
</html>
