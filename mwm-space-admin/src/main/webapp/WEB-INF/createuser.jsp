<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>Создание нового товара - MArsMarketSpace</title>
</head>
<script type="text/javascript">

  function cancel() {
    document.location = "/users.do";
  }
</script>
<body>
<form method="post" action="/adduser.do">
  <table>
    <tr>
      <td><h4>Для создания нового пользователя<br/>заполните все поля и нажмите "Создать"</h4></td>
    </tr>
    <tr>
      <td>Логин:<input type="text" name="login"/></td>
    </tr>
    <tr>
      <td>Пароль:<input type="text" name="password"/></td>
    </tr>
    <tr>
      <td>Имя:<input type="text" name="name"/></td>
    </tr>
    <tr>
      <td>Фамилия:<input type="text" name="surname"/></td>
    </tr>
    <tr>
      <td>Статус:<select name="status" size="1">
        <option value="true">администратор</option>
        <option value="false">пользователь</option>
      </select></td>
    </tr>
    <tr>
      <td><input type="submit" value="Создать"/>
      <input type="button" value="Отмена" onclick="cancel()"/>
      </td>
    </tr>
  </table>
</form>
</body>
</html>