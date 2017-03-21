<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Регистрация</title>
    <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/style.css">
</head>
<body>
<table>
    <thead>
    <tr>
        <h1>URLSHORTENER</h1>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td><h2>Регистрация</h2></td>
    </tr>
    <form:form method="POST" modelAttribute="userForm">
                <spring:bind path="username">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <tr>
                <td><form:input type="text" path="username" class="form-control" placeholder="Имя пользователя"
                                autofocus="true"></form:input></td>
                    <td><form:errors path="username"></form:errors></td>
                </tr>
            </div>
        </spring:bind>
        <spring:bind path="email">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <tr>
                <td><form:input type="text" path="email" class="form-control" placeholder="Электронная почта"
                                autofocus="true"></form:input></td>
                    <td><form:errors path="email"></form:errors></td>
                </tr>
            </div>
        </spring:bind>
        <spring:bind path="password">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <tr>
                    <td><form:input type="password" path="password" class="form-control" placeholder="Пароль"></form:input></td>
                    <td><form:errors path="password"></form:errors></td>
                </tr>
            </div>
            </spring:bind>
        <spring:bind path="confirmPassword">
            <div class="form-group ${status.error ? 'has-error' : ''}">
              <tr>
               <td><form:input type="password" path="confirmPassword" class="form-control"
                               placeholder="Повторите пароль"></form:input></td>
               <td><form:errors path="confirmPassword"></form:errors></td>
              </tr>
            </div>
            </spring:bind>
<tr>
        <td><button type="submit">Зарегистрироваться</button></td>
</tr>
    </form:form>

</body>
</html>