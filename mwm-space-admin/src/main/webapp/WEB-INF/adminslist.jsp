<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<html>
<head>
  <title>История заказов - MArsMarketSpace</title>
</head>
<script type="text/javascript">
  var currentPage = ${currpage}

  function changePage(increment) {
    var tmp = currentPage + increment;
    if(tmp > 0) {
      document.location ="seehistory.do?p="+ tmp;
    }
  }
</script>
<body>
<a href="/main.do">Возврат на главную страницу</a>
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
      <form action="delorder.do" method="get">
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
      <td>
        <input type="submit" value="Удалить">
      </td>
    </form>
    </tr>
  </c:forEach>
  </tbody>
</table>
<input type="button" value="&lt; &lt;" onclick="changePage(-1)">
Страница ${currpage}
<input type="button" value="&gt; &gt;" onclick="changePage(1)">
</body>
</html>