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
    <title>Редактирование участника</title>
    <link rel="stylesheet" type="text/css" href="../style.css" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body>
<div>
    <div id = "header">
        <h1>Фототека</h1>
    </div>
    <div id = "content">
        <form action="/editpost?table=member&id=${member.idMember}" method="POST">
            <ul>
                <li><a href = "/menu">Главная</a> </li>
                <li><a><input type="submit" value="Добавить"></a> </li>
            </ul>

            <table class="simple-little-table" style = "padding: 10px 0 10px 0;" cellspacing='0'>
                <tr>
                    <td>Фамилия</td>
                    <td>Имя</td>
                    <td>Отчество</td>
                </tr><!-- Table Header -->
                <tr>
                    <td><input name="surname" type="text" value="${member.surname}"></td>
                    <td><input name="name" type="text" value="${member.name}"></td>
                    <td><input name="middleName" type="text" value="${member.middleName}"></td>
                </tr>
            </table>
        </form>
    </div>
    <div id = "footer"></div>
</div>

</body>
</html>