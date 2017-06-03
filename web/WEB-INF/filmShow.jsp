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
    <meta charset="utf-8">
    <script src="https://code.jquery.com/jquery-1.10.2.js"></script>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css" >


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
                <li><input type="button" onclick="deleteRows(); return false;" value="Удалить" style="
                    text-decoration: none; /*убираем подчеркивание текста ссылок*/
                    background:#819A32; /*добавляем фон к пункту меню*/
                    color:#fff; /*меняем цвет ссылок*/
                    padding:0px 15px; /*добавляем отступ*/
                    font-family: arial; /*меняем шрифт*/
                    line-height:46px; /*ровняем меню по вертикали*/
                    display: block;
                    border-right: 0px solid #677B27; /*добавляем бордюр справа*/
                    border-left: 0px solid #677B27;
                    border-top: 0px solid #677B27;
                    border-bottom: 0px solid #677B27;
                    -moz-transition: all 0.3s 0.01s ease; /*делаем плавный переход*/
                    -o-transition: all 0.3s 0.01s ease;
                    -webkit-transition: all 0.3s 0.01s ease;"/> </li>
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
                    <td id="${post.idFilm}" >
                        <c:forEach items="${rat}" var="rat">
                            <c:if test="${rat.idFilm == post.idFilm}">
                                <c:set var="ratin" value="${rat.rating}" />
                            </c:if>
                        </c:forEach>

                        <form id="user-rating-form">
                            <span class="user-rating">
                                <input type="radio" name="rating" value="5"
                                    <c:if test="${ratin == 5}"> checked </c:if>
                                onclick="saveUsersRating(5, ${post.idFilm});"><span class="star"></span>

                                <input type="radio" name="rating" value="4"
                                    <c:if test="${ratin == 4}"> checked </c:if>
                                onclick="saveUsersRating(4, ${post.idFilm});"><span class="star"></span>

                                <input type="radio" name="rating" value="3"
                                    <c:if test="${ratin == 3}"> checked </c:if>
                                onclick="saveUsersRating(3, ${post.idFilm});"><span class="star"></span>

                                <input type="radio" name="rating" value="2"
                                    <c:if test="${ratin == 2}"> checked </c:if>
                                onclick="saveUsersRating(2, ${post.idFilm});"><span class="star"></span>

                                <input type="radio" name="rating" value="1"
                                    <c:if test="${ratin == 1}"> checked </c:if>
                                onclick="saveUsersRating(1, ${post.idFilm});"><span class="star"></span>
                            </span>
                        </form>

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

    $('#user-rating-form').on('change','[name="rating"]',function(){
        $('#selected-rating').text($('[name="rating"]:checked').val());
    });


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