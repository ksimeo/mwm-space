<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>Арсенал Веб-Маркет - пространство ваших удачных приобретений</title>
        <style>
        body {
            background-color: darkgray;
        }

        form {
            font-family: italic, coursive;
            color: tomato;
        }
        #signboard {
            text-align: center;
            color: aquamarine;
            background-color: dimgray;

        }

        #tagline {
            text-align: left;
            color: darkgray;
        }
        </style>
    </head>
    <body>
        <h1>Добро пожаловать в Арсенал Веб-Маркет!</h1>
        <h3>Арсенал Веб-маркет - пространство ваших решений</h3>
        <ul>
            <c:forEach var="item" items="${groups}">
            <li>
                <form>
                    <a href="group?id=${item.id}">${item.name}</a>
                </form>
            </li>
            </c:forEach>
        </ul>
        <a target="_blank" href="http://www.the-radio.ru/radio-1377" title="Слушать Будда радио (Buddha Radio)"><img src="http://www.the-radio.ru/up/btn.gif" border="0"></a>
    </body>
</html>