<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>Создание новго продукта - MArsMarketSpace</title>
</head>
<script type="text/javascript">
  function pressComeBack() {
    document.location = "/products.do?tid=${tid}&gid=${gid}&prev_tid=${tid}";
  }
</script>
<body>
<form method="post" action="/createprod.do?tid=${tid}&gid=${gid}&prev_tid=${tid}">
  <br/>
  <h3>Для создания нового продукта, пожалуйста,<br/>
    заполните все поля и нажмите "Создать"</h3>
  <br/>
  <hr/>
  <label>Имя товара:<input type="text" name="prod_name"/></label>
  <br/>
  <br/>
  <label>Номер модели:<input type="text" name="prod_model"/></label>
  <br/>
  <br/>
  <label>Брэнд-производитель:<input type="text" name="producer"/></label>
  <br/>
  <br/>
  <label>Страна-изготовитель:<input type="text" name="country"/></label>
  <br/>
  <br/>
  <label>
    Описание:<textarea rows="10" cols="45" name="description"></textarea></label>
  <br/>
  <label>
    Цена:<input type="text" name="price"/>
  </label>
  <br/>
  <br/>
  <input type="submit" value="Cоздать"/>
  <input type="button" value="Отмена" onclick="pressComeBack()"/>
  <br/>
  <p style="color: firebrick">
    ${formError}
  </p>
</form>
</body>
</html>