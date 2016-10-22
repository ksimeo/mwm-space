<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>Создание нового пользователя - MArsMarket</title>
</head>
<script type="application/javascript">
  function Cancel() {
    document.location = "/users.do";
  }
</script>
<body>
<p>Имя:<input type="text" name="name" required/></p>
<p>Фамилия:<input type="text" name="surname" required/></p>
<p>Логин: <input type="text" name="login" required/></p>
<p>Пароль: <input type="password" name="passw" required/></p>
<p>Подтвердить пароль:<input type="password" name="passw2" required/></p>
<hr/>
<p>
  <input type="submit" value="Сохранить"/>
  <input type="button" value="Отмена" onclick="Cancel()"/>
</p>
</body>
</html>
