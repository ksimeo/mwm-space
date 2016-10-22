<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>Ваш чек покупки товаров на Арсенал Веб-Маркет</title>
</head>
<body>
<form method="POST" action="/acquire">
  <strong>Магазин "Арсенал Веб-Маркет"</strong><br>
    Горячая линия:
  e-mail: hotline@arsenal-wm.com
  <table border="0">
    <c:forEach var="entry" items="${orders}" varStatus="status">
      <tr>
        <td>${entry.key.name} ${entry.key.producer} ${entry.key.model}</td>
        <td>${entry.value}x</td>
        <td>${entry.key.price} ${entry.key.currType}</td>
      </tr>
    </c:forEach>
  </table>
  <hr/>
  <strong>К оплате: ${summ} UAH </strong> <br/>
  Ваше Имя: <input type="text" value="${firstname}" size="5" placeholder="обязательно" required="required"/> <br/>
  Ваша фамилия: <input type="text" value="${secondname}" size="5"/> <br/>
  Ваш контактный номер телефона: <input type="number" value="${phonenumb}" placeholder="обязательно"
                                        required="required" size="5"/> <br/>
  Ваш e-mail: <input type="email" value="${email}" size="5"/> <br/>
  <input type="submit" value="Сделать заказ"/>
  <a href="/basket">Вернуться в корзину</a>
  </h4>
</form>
</body>
</html>
