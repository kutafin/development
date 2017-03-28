<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jstl/sql" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>
        Сокращатель ссылок
    </title>
    <link href="${contextPath}/resources/css/style.css" rel="stylesheet">
</head>
<body>
    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <form id="logoutForm" method="POST" action="${contextPath}/logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>
        <h3>Добро пожаловать, ${pageContext.request.userPrincipal.name} | <a onclick="document.forms['logoutForm'].submit()">Выход</a>
        </h3>
    </c:if>
<h1>URLSHORTENER</h1>
    <table>
    <tr>
        <td><h2>Создание ссылки</h2></td>
    </tr>
<c:url var="addAction" value="/main/add"/>
<form:form action="${addAction}" commandName="shUrl">
                <tr>
            <td>
                <form:label path="url">
                    <spring:message text="URL"/>
                </form:label>
            </td>
            <td>
                <form:input path="url"/>
            </td>
        </tr>
        <tr>
           <td>
                <form:input path="shortUrl" type="hidden"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="description">
                    <spring:message text="Описание"/>
                </form:label>
            </td>
            <td>
                <form:input path="description"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="tag.tagname">
                    <spring:message text="Тэг"/>
                </form:label>
            </td>
            <td>
                <form:input path="tag.tagname" />
            </td>
        </tr>
        <td>
            <form:input path="user.username" type="hidden"/>
        </td>
        <td>
            <form:input path="user.password" type="hidden"/>
        </td>
        <tr>
            <td colspan="2">
                <c:if test="${!empty shUrl.url}">
                    <input type="submit"
                           value="<spring:message text="Обновить ссылку"/>"/>
                </c:if>
                <c:if test="${empty shUrl.url}">
                    <input type="submit"
                           value="<spring:message text="Создать ссылку"/>"/>
                </c:if>
            </td>
        </tr>
    </table>
</form:form>
    <c:if test="${!empty shUrls}">
    <table border="1">
        <tr>
            <th width="120">Url</th>
            <th width="120">ShortUrl</th>
            <th width="120">Описание</th>
            <th width="120">Тэг</th>
            <th width="60">Изменить</th>
            <th width="60">Удалить</th>
        </tr>
        <c:forEach items="${shUrls}" var="shUrl">
               <tr>
                <td>${shUrl.url}</td>
                <td>${shUrl.shortUrl}</td>
                <td>${shUrl.description}</td>
                   <td>${shUrl.tag.tagname}</td>
                <td><a href="<c:url value='/edit/${shUrl.idUrl}'/>">Edit</a></td>
                <td><a href="<c:url value='/remove/${shUrl.idUrl}'/>">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>