<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">

<jsp:include page="../fragments/header.jsp" />

<h2>It`s users login form</h2>
<%--<div class="container">--%>
    <%--<h2>Enter your login and password:</h2>--%>
        <%--<form:form class="form-horizontal" method="post"--%>
           <%--modelAttribute="loginForm" action="${userActionUrl}">--%>
        <%--<div class="form-group">--%>
            <%--<label for="email">Login:</label>--%>
            <%--<form:input path="login" type="text" class="form-control" id="email" placeholder="Enter email"/>--%>
        <%--</div>--%>
        <%--<div class="form-group">--%>
            <%--<label for="pwd">Password:</label>--%>
            <%--<form:input path="passw" type="password" class="form-control" id="pwd" placeholder="Enter password"/>--%>
        <%--</div>--%>
        <%--<div class="checkbox">--%>
            <%--<label><input type="checkbox"> Помнить меня</label>--%>
        <%--</div>--%>
    <%--<button type="submit" class="btn btn-default">Войти</button>--%>
    <%--<form:errors path="name" />--%>
    <%--</form:form>--%>
<%--</div>--%>
<jsp:include page="../fragments/footer.jsp" />
</body>
</html>