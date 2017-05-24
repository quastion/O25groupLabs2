<%--
  Created by IntelliJ IDEA.
  User: fil-n
  Date: 22.04.17
  Time: 14:59
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Авторизация</title>
  <link rel="stylesheet" type="text/css" href="style.css" />
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body>
<div>
  <div id = "header">
    <h1>Авторизация</h1>
  </div>
  <div id = "content">
    <ul></ul>
    <form action="/menu" method="POST">
      <table class="auth-table" style="margin: 20px auto;" cellspacing='0'>
        <tr>
          <td>Логин</td>
          <td><input name ="login" type="text"></td>
        </tr>
        <tr>
          <td>Пароль</td>
          <td><input name ="password" type="password"></td>
        </tr>
      </table>
      <div style="text-align: center;"><a><input type="submit" value="Вход"></a></div>
    </form>
  </div>
  <div id = "footer"></div>
</div>

</body>
</html>