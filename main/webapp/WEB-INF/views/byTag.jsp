<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Ссылки по тегу</title>
    <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/style.css">
</head>
<body>
<table border="0,8">
    <tr>
        <th>Ссылка</th>
        <th>Тэг</th>
        <th>Короткая ссылка</th>
    </tr>
    <c:forEach items="${shUrls}" var="shUrl">
        <tr>
            <th> ${shUrl.url}</th>
            <th> ${shUrl.tag.tagname}</th>
            <th><a href="http://${shUrl.url}">
                <label>${shUrl.shortUrl}</label> </a></th>
            <th><a href="<c:url value="/shortu${shUrl.idUrl}" /> ">
                <label>Подробнее</label></a>
            </th>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
