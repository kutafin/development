<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Список тэгов</title>
    <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/style.css"/>
</head>
<body>
<c:if test="${!empty tags}">
    <table border="0">
        <tr>
            <td width="120">Тэг</td>
        </tr>
        <c:forEach items="${tags}" var="tags">
            <tr>
                <td><a href="<c:url value="/byTag/${tags.tagname}"/>">${tags.tagname}</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>
