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
			<h1>Авторизация<h1>
		</div>
		<div id = "content">
		<ul></ul>
		<form action="/addpost?table=user" method="POST">
			<table class="auth-table" style="margin: 20 auto;" cellspacing='0'>
				<tr>
					<td>Логин</td>
					<td><input name ="login" type="text"></td>
				</tr>
				<tr>
					<td>Пароль</td>
					<td><input name ="password" type="text"></td>
				</tr>
			</table>
			<div style="text-align: center;"><a><input type="submit" value="Вход"></a></div>
		</form>
		</div>
		<div id = "footer"></div>
	</div>

</body>
</html>