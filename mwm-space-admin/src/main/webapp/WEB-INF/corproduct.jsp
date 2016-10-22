<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<html>
<head>
  <title>Изменение существующего продукта - MArsMarketSpace</title>
</head>
<script type="text/javascript">
  function pressComeBack() {
    document.location = "/products.do?tid=0&gid=0&prev_tid=0";
  }
</script>
<body>
<form method="post" action="/corprod.do">
  <br/>
  <h3>Для корректировки существующего продукта, пожалуйста,<br/>
    измените необходимые поля и нажмите "Сохранить"</h3>
  <br/>
  <hr/>
  <input type="hidden" name="prod_id" value="${prod_id}"/>
  <input type="hidden" name="group_id" value="${group_id}"/>
  <input type="hidden" name="type_id" value="${type_id}"/>
  <label>Имя товара:<input type="text" name="prod_name" value="${prev_name}"/></label>
  <br/>
  <br/>
  <label>Номер модели:<input type="text" name="prod_model" value="${prev_model}"/></label>
  <br/>
  <br/>
  <label>Брэнд-производитель:<input type="text" name="producer" value="${producer}"/></label>
  <br/>
  <br/>
  <label>Страна-изготовитель:<input type="text" name="country" value="${country}"/></label>
  <br/>
  <br/>
  <label>
    Описание:<textarea rows="10" cols="45" name="description">${description}</textarea></label>
  <br/>
  <label>
    Цена:<input type="number" name="prod_price" value="${prev_price}"/> грн.
  </label>
  <br/>
  <br/>
  <input type="submit" value="Cохранить"/>
  <input type="button" value="Отмена" onclick="pressComeBack()"/>
  <br/>
  <p style="color: firebrick">
    ${formError}
  </p>
</form>
</body>
</html>