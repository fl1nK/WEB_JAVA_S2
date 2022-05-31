<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ADMIN</title>
</head>
<body>

<h1>ADMIN Login  ${login} !!!</h1>
<a href="<c:url value="/logout"/>">Logout</a>
<form method="post" action="ReportController">
    <button>Report menu</button>
</form>

<p>Фільтрувати по статусу</p>
<form method="post" action="FilterController">
    <p><select name="statusList">
        <option>Choose a value</option>
        <option value="1">Awaiting processing</option>
        <option value="2">Awaiting payment</option>
        <option value="3">Awaiting renovation</option>
        <option value="4">Now under renovation</option>
    </select>
        <button>Send</button></p>
</form>

<p>Фільтрувати по майстру</p>
<form method="post" action="FilterController">
    <p><input type="text" name="master"><button>Send</button></p>
</form>

<form method="post" action="FilterController">
    <button>Оновити таблицю</button>
</form>

<table>
    <tr>
        <td>ID</td>
        <td>User</td>
        <td>Device</td>
        <td>Date</td>
        <td>Price</td>
        <td>Master</td>
        <td>Status</td>
    </tr>
    <c:forEach items="${listForAdmin}" var="list">
        <tr>
            <td>${list.getID()}</td>
            <td>${list.getUserLogin()}</td>
            <td>${list.getDevice()}</td>
            <td>${list.getDate()}</td>
            <td>${list.getPrice()}</td>
            <td>${list.getMasterLogin()}</td>
            <td>${list.getStatus()}</td>
            <td>
                <c:if test = "${list.getStatus() == 'Awaiting processing'}" >
                <form method="post" action="AdminFormController">
                <input type="number" min="1" required placeholder="price" name="price"><br>
                <input type="text" required placeholder="master" name="master"><br>
                 <button value="${list.getID()}" name="id">Send</button>
                </form>
                </c:if>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>