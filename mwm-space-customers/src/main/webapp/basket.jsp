<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>Оформление заказ на Арсенал Веб-Маркет</title>
    <script type="text/javascript">
//        function buy() {
//                document.location ="/buy";
//        }

        function del(id) {
                document.location ="/delete?id=" + id;
        }

        function change(id) {
            document.location ="/change?id=" + id;
        }
    </script>
</head>
<body>
<h2>В вашей корзине на данный момент:</h2>

<form method="GET" action="/ordering">
    <table border="1">
        <tr>
            <th>Наименования товаров</th>
            <th>Количество</th>
        </tr>
        <c:forEach var="entry" items="${orders}" varStatus="status">
            <tr>
                <td>${entry.key.name} ${entry.key.producer} ${entry.key.model}</td>
                <td>${entry.value}</td>
                <td>
                    <a href="/edit?id=${entry.key.id}&quant=${entry.value}">Изменить</a>&nbsp;<a href="/delete?id=${entry.key.id}">Удалить</a>
                    <%--<input type="button" value="Изменить" onclick="change(${entry.key.id})"><input type="button" value="Удалить" onclick="del(${entry.key.id})">--%>
                </td>
            </tr>
            <%--<script type="text/javascript">--%>
                <%--function del() {--%>
                    <%--document.location ="/delete?id=${entry.key.id}";--%>
                <%--}--%>
            <%--</script>--%>
        </c:forEach>
    </table>
    <br/>
    ИТОГО: ${summ} ГРН.
    <input type="submit" value="Сделать заказ"/>
</form>
</body>
</html>