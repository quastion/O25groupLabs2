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
    <script src="https://code.jquery.com/jquery-1.10.2.js"></script>

    <link rel="stylesheet" type="text/css" href="style.css" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body>
<div>
    <div id = "header">
        <a href="/menu" class="without_"><h1>Фототека</h1></a>
    </div>
    <div id = "content">
        <ul>
            <li><a href = "/menu">Главная</a> </li>
            <c:if test="${delete == true}">
                <li><input type="button" onclick="deleteRows(); return false;" value="Удалить" /> </li>
            </c:if>
        </ul>
        <table  id = "tbl" class="simple-little-table"
               style = "padding: 10px 0 10px 0;" cellspacing='0'>
            <tr>
                <td>X</td>
                <td>Цена</td>
                <td>Чувств.</td>
                <td>Количество</td>
                <td>Дата снимка</td>
                <td>Дата проявки</td>
                <td>Место проявки</td>
                <td>Хранение</td>
                <td>Тип пленки</td>
                <td>Рейтинг</td>
                <td>Рейтинг пользователя</td>
                <c:if test="${edit == true}">
                    <td>Редактировать</td>
                </c:if>



            </tr>
            <c:forEach items="${posts}" var="post">
                <tr id ="${post.idFilm}">
                    <td><input  type="checkbox"/> </td>
                    <td>${post.priceFilm}</td>
                    <td>${post.sensibility}</td>
                    <td>${post.numFrame}</td>
                    <td>${post.dateStartingSnapshot}</td>
                    <td>${post.dateManifestation}</td>
                    <td>${post.placeManifestation}</td>
                    <td>${post.placeStorage}</td>
                    <td>${post.typeOfFilm}</td>

                    <td id = "rating_${post.idFilm}">
                        ${post.rating} / 5
                    </td>
                    <td id="${post.idFilm}">
                        <div class="reviewStars-input" style="width:150px;">
                            <input id="star-4_${post.idFilm}" class="star-4" type="radio" name="reviewStars"  onclick="saveUsersRating(5, this.parentElement.parentElement.id);"/>
                            <label title="gorgeous" for="star-4_${post.idFilm}"></label>

                            <input id="star-3_${post.idFilm}" class="star-3" type="radio" name="reviewStars" onclick="saveUsersRating(4, this.parentElement.parentElement.id);"/>
                            <label title="good" for="star-3_${post.idFilm}"></label>

                            <input id="star-2_${post.idFilm}" class="star-2" type="radio" name="reviewStars" onclick="saveUsersRating(3, this.parentElement.parentElement.id);"/>
                            <label title="regular" for="star-2_${post.idFilm}"></label>

                            <input id="star-1_${post.idFilm}" class="star-1" type="radio" name="reviewStars" onclick="saveUsersRating(2, this.parentElement.parentElement.id);"/>
                            <label title="poor" for="star-1_${post.idFilm}"></label>

                            <input id="star-0_${post.idFilm}" type="radio" class="star-0" name="reviewStars" onclick="saveUsersRating(1, this.parentElement.parentElement.id);"/>
                            <label title="bad" for="star-0_${post.idFilm}"></label>
                        </div>
                    </td>
                    <c:if test="${edit == true}">
                        <td><a href="/edit?table=film&id=${post.idFilm}">Редактировать</a> </td>
                    </c:if>
                </tr>
            </c:forEach>
        </table>
    </div>
    <div id = "footer"></div>
</div>

<script>
    function saveUsersRating(mark, idFilm1) {
        $.ajax(
            {
                type: 'POST',
                data: {mark:mark, idUser: ${idUser}, idFilm: idFilm1},
                url: 'userrating',
                success: function (result) {
                    $('#rating_'+idFilm1).html(result);

                }
            }
        );
    }
    t = document.getElementById('tbl');
    function deleteRows() {
        arDelete = new Array();
        for (var i =1 ;i< t.rows.length;i++){
             if (t.rows[i].cells[0].childNodes[0].checked == true)
                arDelete.push(document.getElementById('tbl').rows[i].id);

        }
        document.location.href='/delete?table=film&id='+arDelete.toString();
    }
</script>

</body>
</html>