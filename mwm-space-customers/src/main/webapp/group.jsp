<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<html>
  <head>
    <title>${title} на Арсенал Веб-Маркет</title>
      <script type="text/javascript">
          function goToBasket() {
              document.location ="/basket";
          }
      </script>
  </head>
  <body>
<%--<h2>${title}:</h2>--%>
    <h5><a href="index">Главное меню</a>/${groups}
        &nbsp; &nbsp; &nbsp; &nbsp;
        <input type="button" onclick="goToBasket()" value="Перейти к вашей корзине"></h5>
<%--<input name="groupid" id="groupid" type="hidden" value="${groupid}">--%>
    <ul>
        <c:forEach var="item" items="${types}" >
            <li>
                <form>
                    <a href="type?id=${item.id}&group=${gid}">${item.name}</a>
                </form>
            </li>
        </c:forEach>
    </ul>
  </body>
</html>