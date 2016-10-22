<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>Редактирование списка пользователей системы - MArsMarket</title>
</head>
<script type="text/javascript">
  function editButton(id) {
    document.location = "/edituser.do?id=" + id;
  }

  function addNewUser() {
    document.location = "/adduser.do";
  }

  function delUser(id) {
    document.location = "/deluser.do?id=" + id;
  }

  function cancel() {
    document.location = "/main.do";
  }
</script>
<body>
<table>
  <thead>
  <tr>
    <th>#</th>
    <th>Логин</th>
    <th>Имя</th>
    <th>Фамилия</th>
    <th>Статус админа</th>
    <th>    </th>
  </tr>
  </thead>
  <tbody>
    <c:forEach var="item" items="${users}">
      <tr>
        <td>${item.id}</td>
        <td>${item.login}</td>
        <td>${item.name}</td>
        <td>${item.surname}</td>
        <td>${item.admin}</td>
        <td><input type="button" value="Удалить" onclick="delUser(${item.id})">
        <input type="button" value="Редактировать" onclick="editButton(${item.id})"></td>
      </tr>
    </c:forEach>
  </tbody>
</table>
<input type="button" value="Создать нового пользователя" onclick="addNewUser()"/>
<input type="button" value="Отмена" onclick="cancel()">
</body>
</html>