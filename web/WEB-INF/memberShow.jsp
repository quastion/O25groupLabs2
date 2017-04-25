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
            <td>idMember</td>
            <td>surname</td>
            <td>name</td>
            <td>middleName</td>

        </tr>
        <c:forEach items="${posts}" var="post">
            <tr>
                <td>${post.idMember}</td>
                <td>${post.surname}</td>
                <td>${post.name}</td>
                <td>${post.middleName}</td>

            </tr>
        </c:forEach>
    </table>

</body>
</html>
