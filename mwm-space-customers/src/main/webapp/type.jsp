<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<html>
  <head>
    <title>${typename} на Арсенал Веб-Маркет</title>
    <script type="text/javascript">
      function goToBasket() {
        document.location ="/basket";
      }
    </script>
  </head>
  <body>
<%--<h2>${typename}</h2>--%>
    <h5><a href="index">Главное меню</a>/<a href="group?id=${gid}">${groupname}</a>/${typename}
    &nbsp; &nbsp; &nbsp; &nbsp;
        <input type="button" value="Перейти к вашей корзине" onclick="goToBasket()"/></h5>
        <%--<input id="typeid" type="hidden" value="${typeid}"/>--%>
        <%--<input id="groupid" name="groupid" type="hidden" value="${groupid}"/>--%>
        <ul>
        <c:forEach var="item" items="${products}">
        <li>
          <form>
            <a href="product?id=${item.id}&type=${tid}&group=${gid}">${item.producer} ${item.model}</a>
            <br/> ${item.price} ${item.currType}  <hr/>
          </form>
        </li>
        </c:forEach>
    </ul>
  </body>
</html>