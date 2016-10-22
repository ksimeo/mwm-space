<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<html>
    <head>
        <title>Оформление заказа на Арсенал Веб-Маркет</title>
        <script type="text/javascript">
            function cancel() {
                document.location ="/basket";
            }
        </script>
    </head>
    <body>
        <form action="/dorder" method="POST">
            <input type="text" name="name" value="${param.name}"/>
            <br/>
            <input type="tel" name="tel" value="${param.tel}"/>
            <br/>
            <input type="submit" value="Заказать"/>
            <input type="button" value="Отмена" onclick="cancel()">
            <p style="color: red">
                ${ErrorField}
            </p>
        </form>
    </body>
</html>