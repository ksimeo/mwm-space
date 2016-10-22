<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>Создание нового типа товаров - MArsMarketSpace</title>
</head>
<body>
<form action="/addtype.do" method="post">
<h4>Введите название новго типа товаров:</h4>
<input type="text" name="typetitle" autofocus/>
<input type="submit">
</form>
</body>
</html>
