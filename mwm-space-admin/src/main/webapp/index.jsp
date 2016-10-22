<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>MArsMarketSpace - Администрирование ресурса</title>
    <link rel="stylesheet" typa="text/css" href="content/css/style.css"/>
</head>
<body>
<form action="login" method="post">
    <h2>Вы находитесь на странице авторизации системы адми ресурса MArsMarketSpace</h2>
    <hr/>
    <h4>Логин: &nbsp; <input type="text" name="login" required="required" value="${login}"></h4>
    <h4>Пароль: &nbsp; <input type="password" name="password" required="required" value="${password}"></h4>
    <p style="color: #ff5a49">
        ${Error}
    </p>
    <input type="submit" value="&nbsp; &nbsp; &nbsp; Войти &nbsp; &nbsp; &nbsp;">
</form>
</body>
</html>