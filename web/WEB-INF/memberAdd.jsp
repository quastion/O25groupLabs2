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
    <title>Пленки</title>
    <link rel="stylesheet" type="text/css" href="style.css" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body>
<div>
    <div id = "header">
        <h1>Фототека<h1>
    </div>
    <div id = "content">
        <ul>
            <li><a href="/addpost?table=member" method="POST">Добавить</a>
        </ul>

        <table class="simple-little-table" cellspacing='0'>
            <tr>
                <th>Фамилия</th>
                <th>Имя</th>
                <th>Отчество</th>
            </tr><!-- Table Header -->
            <tr>
                <th><input name="surname" type="text"></th>
                <th><input name="name" type="text"></th>
                <th><input name="middleName" type="text"></th>
            </tr>
        </table>
    </div>
    <div id = "footer"></div>
</div>

</body>
</html>