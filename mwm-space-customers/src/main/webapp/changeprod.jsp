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
<form action="/savechangequant?prodid=${prodid}" method="POST">
  <h2>${name} ${producer} &nbsp; ${model}</h2>
  <hr/>
  <h2>${descr}</h2>
  <br/>
  <h3>Страна-производитель: &nbsp; ${country}</h3>
  <br/>
  <h3>Цена: &nbsp; ${price} ${type}</h3>
  <br/>
    <%--<input type="hidden" name="pid" value="${prodid}">--%>
  <h2>Количество: <input type="text" name="quant" size="1" value="${q}"> шт. &nbsp;</h2>
    <input type="submit" value="Сохранить">
    <a href="/basket">Вернуться к корзине</a></h5>
</form>
</body>
</html>
