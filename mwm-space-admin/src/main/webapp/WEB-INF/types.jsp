<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<html>
<head>
  <title>Редактирование списка типов товаров - MArsMarketSpace</title>
</head>
<script type="text/javascript">
  function createType() {
    var type = prompt("Пожалуйста, введите название нового типа товаров");
    if (type != null) {
      document.location = "/newtype.do?name=" + type;
    }
  }

  function cancel() {
    document.location="/products.do?tid=0&gid=0&prev_tid=0";
  }
</script>
<body>
<h4>Вы находитесь на странице редактирования списка типов продуктов</h4>
<table>
  <thead>
  <tr>
    <th>#</th>
    <th>Название</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach var="item" items="${types}">
    <tr>
      <td>${item.id}</td>
      <td>${item.name}</td>
    </tr>
  </c:forEach>
  </tbody>
</table>
<input type="button" value="Создать новый тип товаров" onclick="createType()">
<input type="button" value="Отмена" onclick="cancel()">
</body>
</html>