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
    <title>Вход</title>
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
        <td><h2>Вход</h2></td>
    </tr>
    <form method="POST" action="${contextPath}/login">
        <div class="form-group ${error != null ? 'has-error' : ''}">
           <tr>
               <td><input name="username" type="text" class="form-control" placeholder="Username"/></td>
               <td><span>${message}</span><td>
            </tr>
            <tr>
                <td><input name="password" type="password" class="form-control" placeholder="Password"/></td>
                        <td><span>${error}</span></td>
            </tr>
            <tr>
                <td><button type="submit">Войти</button></td>
            <td><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/></td>
                            </tr>
        </div>
    </form>
    </table>
<h3><a href="${contextPath}/registration">Регистрация</a></h3>
</body>
</html>
