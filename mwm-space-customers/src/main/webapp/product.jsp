<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<html>
    <head>
        <title>${producer} ${model} на Арсенал Веб-Маркет</title>
        <script type="text/javascript">
            function addInBasket() {
                document.location ="/order?id=${prodid}&type=${typeid}&group=${groupid}";
            }

            function goToBasket() {
                document.location ="/basket";
            }
        </script>
    </head>
    <body>
    <h5><a href="index">Главное меню</a>/<a href="group?id=${groupid}">${groupname}</a>/
        <a href="type?id=${typeid}&group=${groupid}">${typename}</a>&nbsp; &nbsp; &nbsp; &nbsp;
        <input type="button" onclick="goToBasket()" value="Перейти к вашей корзине"></h5>
            <form action="/order?id=${prodid}&type=${typeid}&group=${groupid}" method="POST">
                <h2>${producer} &nbsp; ${model}</h2>
                <hr/>
                <h2>${descr}</h2>
                <br/>
                <h3>Страна-производитель: &nbsp; ${country}</h3>
                <br/>
                <h3>Цена: &nbsp; ${price} ${type}</h3>
                <br/>
                <h5>
                    <%--<input type="hidden" name="pid" value="${prodid}">--%>
                    <input type="submit" value="Добавить в корзину" onclick="addInBasket()">
                    <input type="text" name="quant" size="1" value="1"> шт. &nbsp;</h5>
                    <%--<a href="/basket">Перейти к корзине</a></h5>--%>
            </form>
    </body>
</html>