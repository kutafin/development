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
    <tr><td>
    <a href="${contextPath}/registration">
    <button type="submit">Регистрация</button>
    </a></td>
    </tr>
    <tr>
        <td><h2>Вход</h2></td>
    </tr>
    <form method="POST" action="${contextPath}/login">
        <div class="form-group ${error != null ? 'has-error' : ''}">
            <tr>
                <td><input name="username" type="text" class="form-control" placeholder="Имя пользователя"/></td>
                <td><span>${message}</span><td>
            </tr>
            <tr>
                <td><input name="password" type="password" class="form-control" placeholder="Пароль"/></td>
                <td><span>${error}</span></td>
            </tr>
            <tr>
                <td><button type="submit">Войти</button></td>
                <td><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/></td>
            </tr>
        </div>
    </form>
</table>
<c:if test="${!empty shUrls}">
    <table border="0">
        <tr>
            <td width="120">Сокращенная ссылка</td>
            <td width="120">Описание</td>
            <td><a width="40" css><a href="<c:url value="tags"/>"/>Тэг</a></td>
            <td width="80">Подробности</td>
                    </tr>
        <c:forEach items="${shUrls}" var="shUrl">
            <tr>
                <td>${shUrl.shortUrl}</td>
                <td>${shUrl.description}</td>
                <td>${shUrl.tag.tagname}</td>
                <td><a href="<c:url value="/shortu${shUrl.idUrl}" /> "><label  >Подробнее</label></a></td>
</tr>
        </c:forEach>
    </table>
</c:if>
<script>
    type='text/javascript'
    var javascriptVariable = "${shUrl.views}";
    javascriptVariable+1;
    var count=0;
    function inc(aaaa) {
        javascriptVariable=javascriptVariable+1;
        aaaa++;
        console.log(javascriptVariable);
    };
</script>
</body>
</html>