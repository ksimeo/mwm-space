<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Создание новой группы товаров - MArsMarket</title>
</head>
<script type="text/javascript">
  function cancel() {
    document.location = "/groupedit.do";
  }
</script>
<body>
<form method="post" action="/newgroup.do">
  <h2>Введите название новой группы товаров:
    <input type="text" name="groupname"/>
    <input type="submit">
    <input type="button" ></h2>
</form>
</body>
</html>
