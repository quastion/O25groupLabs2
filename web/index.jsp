<%--
  Created by IntelliJ IDEA.
  User: fil-n
  Date: 22.04.17
  Time: 14:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
  <title>Главная</title>
  <link rel="stylesheet" type="text/css" href="WEB-INF/style.css" />
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body>
<div>
  <div id = "header">
    <h1>Фототека<h1>
  </div>
  <div id = "content">
    <ul>
      <li><a href="#">Добавить</a>
        <ul>
          <li><a href="/add?table=film">Пленка</a></li>
          <li><a href="/add?table=photo">Фото</a></li>
          <li><a href="/add?table=frame">Кадр</a></li>
          <li><a href="/add?table=member">Учистники</a></li>
        </ul>
      </li>
      <li><a href="#">Показать</a>
        <ul>
          <li><a href="/show?table=film">Пленка</a></li>
          <li><a href="/show?table=photo">Фото</a></li>
          <li><a href="/show?table=frame">Кадр</a></li>
          <li><a href="/show?table=member">Учистники</a></li>
        </ul>
      </li>
    </ul>
  </div>
  <div id = "footer"></div>
</div>


</body>
</html>
