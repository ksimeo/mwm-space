<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>Изменение пароля - MArsMarketSpace</title>
</head>
<script type="text/javascript">
  function cancel() {
      document.location ="/main.do";
  }
</script>
<body>
<form action="/savechange.do" method="post">
  <h4>Для изменения пароля, заполните <br/> поля ниже и введите "ОК"</h4>
  <hr/>
  <br/>
  <p>Введите старый пароль:<input type="password" name="oldpassword" required="required"/></p>
  <br/>
  <p>Введите новый пароль:<input type="password" name="newpassword1" required="required"/></p>
  <br/>
  <p>Подтвердите новый пароль:<input type="password" name="newpassword2" required="required"/></p>
  <br/>
  <input type="submit" value="OK"/>
  <input type="button" value="Отмена" onclick="cancel()"/>
</form>
</body>
</html>
