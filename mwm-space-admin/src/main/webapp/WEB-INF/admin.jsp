<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>Главная страница администрирования системы - MArsMarket</title>
</head>
<script type="text/javascript">
    function pressButtonChangePassword() {
        document.location = "/changepassw.do";
    }

    function pressButtonEditUserList() {
        document.location = "/users.do";
    }

    function pressButtonEditProdList() {
        document.location = "/products.do?tid=0&gid=0&prev_tid=0";
    }

    function pressButtonSeeHistory() {
        document.location = "/seehistory.do?p=1";
    }

    function pressButtonConsider(id) {
        document.location = "/consider.do?id=" + id;
    }
</script>
<body>
<h2>Здравствуйте, ${username}! Вы находитесь на главной странице администрирования системы.</h2>
<p>
    <input type="button" value="Сменить пароль" onclick="pressButtonChangePassword()"/>
    <input type="button" value="Редактировать список пользователей системы" onclick="pressButtonEditUserList()"/>
    <input type="button" value="Редактировать список продуктов" onclick="pressButtonEditProdList()"/>
    <input type="button" value="История заказов" onclick="pressButtonSeeHistory()"/>
</p>
<table>
    <thead>
    <tr>
        <th>N заказа</th>
        <th>Дата Время</th>
        <th>Как обращаться</th>
        <th>Эл. почта</th>
        <th>Телефон</th>
        <th>Заказ</th>
        <th>Действия</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="item" items="${orders}">
        <tr>
            <form action="/consider.do?id=${item.id}" method="get">
                <td>${item.id}</td>
                <td><fmt:formatDate pattern="dd.MM.yy HH:mm" value="${item.date}"/></td>
                <td>${item.name} ${item.surname}</td>
                <td>${item.telnumber}</td>
                <td>${item.email}</td>
                <td>
                    <table>
                        <c:forEach var="item2" items="${item.orders}">
                            <tr>
                                <td>${item2.key.id} ${item2.key.name} ${item2.key.model} ${item2.key.producer} </td>
                                <td>${item2.value}</td>
                            </tr>
                        </c:forEach>
                    </table>
                </td>
                <th>
                    <input type="button" value="Учтено" onclick="pressButtonConsider(${item.id})"/>
                </th>
            </form>
        </tr>
    </c:forEach>
    </tbody>
</table>
<p style="color: grey">
    ${Error}
</p>
</body>
</html>