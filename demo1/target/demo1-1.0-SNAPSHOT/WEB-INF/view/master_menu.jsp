<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>USER</title>
</head>
<body>

<h1>Hello MASTER ${login}!</h1>
<a href="<c:url value="/logout"/>">Logout</a>

<form method="post" action="MasterCommentServlet">
    <button>View comments</button>
</form>
<table>
    <tr>
        <td>ID</td>
        <td>Device</td>
        <td>Status</td>
        <td></td>
    </tr>
    <c:forEach items="${listForMaster}" var="list">
        <tr>
            <td>${list.getID()}</td>
            <td>${list.getDevice()}</td>
            <td>${list.getStatus()}</td>
            <td>
                <c:if test = "${list.getStatus() == 'Awaiting renovation'}" >
                <form method="post" action="MasterAcceptController">
                    <button value="${list.getID()}" name="id">Accept</button>
                </form>
                </c:if>
                <c:if test = "${list.getStatus() == 'Now under renovation'}" >
                <form method="post" action="MasterEndRepairController">
                    <button value="${list.getID()}" name="id">End repair</button>
                </form>
                </c:if>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>