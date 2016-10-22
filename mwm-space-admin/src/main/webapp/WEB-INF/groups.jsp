<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<html>
<head>
  <title>Редактирование списка групп товаров типа "${typename}" - MArsMarketSpace</title>
</head>
<script type="text/javascript">
  function createGroup() {
    var group = prompt("Пожалуйста, введите название нового типа товаров", "");
    if (group != null) {
      document.location = "/newgroup.do?name=" + group + "&id=${type_id}";
    }
  }
  function cancel() {
    document.location="/products.do?tid=${type_id}&gid=0&prev_tid=0";
  }
</script>
<body>
<h4>Вы находитесь на странице редактирования списка типов продуктов, группы "${typename}"</h4>
<table>
  <thead>
  <tr>
    <th>#</th>
    <th>Название</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach var="item" items="${groups}">
    <tr>
      <td>${item.id}</td>
      <td>${item.name}</td>
    </tr>
  </c:forEach>
  </tbody>
</table>
<input type="button" value="Создать новый тип товаров" onclick="createGroup()">
<input type="button" value="Отмена" onclick="cancel()">
</body>
</html>