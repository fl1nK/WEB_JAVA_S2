<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Hello MASTER ${login}!</h1>
<a href="<c:url value="/logout"/>">Logout</a><br>
<a href="<c:url value="/"/>">Back</a>
<table>
    <tr>
        <td>Comments</td>
    </tr>
    <c:forEach items="${listComments}" var="list">
        <tr>
            <td>${list.getComment()}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
