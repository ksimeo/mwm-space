<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>Работа со списком продуктов - MArsMarketSpace</title>
</head>
<script type="text/javascript">
  function selectType() {
    document.location="/prodedit.do?tid=" + document.getElementById('tid').value + "&gid="
            + document.getElementById('gid').value;
  }

  function editType() {
    document.location="/typedit.do";
  }

  function editGroup() {
    document.location="/groupedit.do?tid=" + document.getElementById('tid').value;
  }

  function editProd(id) {
    document.location = "/corprod.do?id=" + id + "&tid=${typeID}&gid=${groupID}";
  }

  function delProd(id) {
  document.location = "/delprod.do?id=" + id + "&tid=${typeID}&gid=${groupID}";
  }

  function pressTypeButton() {
    document.location = "/types.do";
  }

  function pressGroupButton(id) {
    document.location = "/groupes.do?tid=" + id;
  }

  function enterNewGroupName() {
    var group = prompt("Пожалуйста, введите название новой группы товаров", "");
    if (group != null) {
      document.location = "/addnewgroup.do?name=" + group;
    }
  }

  var tID;
  var gID;
  function onSelect(ptid) {
    tID = document.getElementById('tid');
    gID = document.getElementById('gid');
    if (tID != 0) {
      document.location = "/products.do?tid=" + document.getElementById('tid').value + "&gid="
              + document.getElementById('gid').value + "&prev_tid=" + ${prev_tid};
    }
  }

  function pressNewProductButton() {
    document.location = "/createprod.do?tid=${typeID}&gid=${groupID}";
  }

  function cancel() {
    document.location = "/main.do";
  }
</script>
<body onchange="onSelect()">
<form>
  <br/>
  <h3>Страница редактирования предлагаемой продукции</h3>
  <br/>
  <hr/>
  <p>Тип продукции: &nbsp;
    <label>
      <select name="types" id="tid" size="1">
        <option value="0">-Выберите-тип-продукции-</option>
        <c:forEach items="${types}" var="item">
          <option name="type" id="${item.id}" value="${item.id}" ${item.id == typeID ? 'selected="selected"' : ''}>
              ${item.name}</option>
        </c:forEach>
      </select>
      <input type="button" value="Редактировать список" onclick="pressTypeButton()">
    </label>
  </p>
  <p>Группа товаров:
    <label>
      <select name="goups" id="gid" size="1" ${disabled}>
        <option value="0" ${selected}>-Выберите-группу-товаров-</option>
        <c:forEach items="${groups}" var="item">
          <option name="group" value="${item.id}" ${item.id == groupID ? 'selected="selected"' : ''}>
              ${item.name}
          </option>
        </c:forEach>
      </select>
      <input type="button" value="Редактировать список" onclick="pressGroupButton(${type_id})">
    </label>
  </p>
  <div ${tabler}>
    <h4>Предлагаемые товары:</h4>
    <table>
      <thead>
      <tr>
        <td>#</td>
        <td>Наименование товара</td>
        <td>Производитель</td>
        <td>Модель</td>
        <td>Страна-производитель</td>
        <td>Описание</td>
        <td>Цена</td>
        <td>&nbsp;</td>
      </tr>
      </thead>
      <tbody>
      <c:forEach var="item" items="${products}">
        <tr>
          <td>${item.id}</td>
          <td>${item.name}</td>
          <td>${item.producer}</td>
          <td>${item.model}</td>
          <td>${item.country}</td>
          <td>${item.description}</td>
          <td>${item.price}</td>
          <td>
            <input type="button" value="Удалить" onclick="delProd(${item.id})">
            <input type="button" value="Редактировать" onclick="editProd(${item.id})">
          </td>
        </tr>
      </c:forEach>
      </tbody>
    </table>
    <br/>
  </div>
  <input type="button" value="Добавить новый продукт" onclick="pressNewProductButton()" ${disabled_}/>
  <input type="button" value="Отмена" onclick="cancel()">
  <div ${t_instead}>
    <h4 style="color : grey"><i>Выберите тип продукции и группу товаров</i></h4>
  </div>
</form>
</body>
</html>