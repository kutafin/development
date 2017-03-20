<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Подробная информация</title>
    <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/style.css">
</head>
<body>
<table>
    <tr>
        <th>Ссылка</th>
        <th>Короткая ссылка</th>
        <th>Описание</th>
        <th>Количество просмотров</th>
        <th>Создатель</th>
        <th>Тэг</th>
    </tr>
    <tr>
        <th>${shUrl.url}</th>
        <th><a href="http://${shUrl.url}" target="_blank">
            <label>${shUrl.shortUrl}</label> </a></th>
        <th>${shUrl.description}</th>
        <th>${shUrl.views}</th>
        <th>${shUrl.user.username}</th>
        <th><a href="<c:url value="byTag/${shUrl.tag.tagname}"/>  "><label>${shUrl.tag.tagname}</label></a></th>
    </tr>
</table>
<script type='text/javascript'>
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
