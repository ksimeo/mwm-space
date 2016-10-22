<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Создание новой группы - MArsMarket</title>
</head>
<script type="text/javascript">
  function cancel() {
    document.location = "/typedit.do";
  }
</script>
<body>
<form>
  <input type="hidden" name="gip" value="${gip}"/>
  <h2>Введите название новой группы:</h2>
  <input type="submit" value="Создать"/>
  <input type="button" value="Отмена" onclick="cancel()"/>
</form>
</body>
</html>