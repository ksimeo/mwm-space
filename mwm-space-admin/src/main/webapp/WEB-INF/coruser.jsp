<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<html>
<head>
  <title>Изменение данных пользователя - MArsMarketSpace</title>
</head>
<script type="text/javascript">

  function cancel() {
    document.location = "/users.do";
  }
</script>
<body>
<form method="post" action="/coruser.do">
  <table>
    <tr>
      <td><h4>Для изменения данных пользователя<br/>откорректируйте неободимые поля и нажмите "Сохранить"</h4></td>
    </tr>
    <tr>
      <td><input type="hidden" name="id" value="${id}"/>Логин:<input type="text" name="login" value="${login}"/></td>
    </tr>
    <tr>
      <td>Имя:<input type="text" name="name" value="${name}"/></td>
    </tr>
    <tr>
      <td>Фамилия:<input type="text" name="surname" value="${surname}"/></td>
    </tr>
    <tr>
      <td>Статус:<select name="status" size="1">
        <option value="true" ${adm}>администратор</option>
        <option value="false" ${usr}>пользователь</option>
      </select></td>
    </tr>
    <tr>
      <td><input type="submit" value="Сохранить"/>
        <input type="button" value="Отмена" onclick="cancel()"/>
      </td>
    </tr>
  </table>
</form>
</body>
</html>
