<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Report</title>
  </head>
  <body>
  <h1>ADMIN Login  ${login} !!!</h1>
  <a href="<c:url value="/"/>">Back</a>
  <form method="post" action="ReportController">
    <p>Sort by date
    <button value="dateUp" name="sort">Up</button>
    <button value="dateDown" name="sort">Down</button></p>
    <p>Sort by price
    <button value="priceUp" name="sort">Up</button>
    <button value="priceDown" name="sort">Down</button></p>
    <p>Sort by status
    <button value="statusUp" name="sort">Up</button>
    <button value="statusDown" name="sort">Down</button></p>
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
    <c:forEach items="${listReport}" var="list">
      <tr>
        <td>${list.getID()}</td>
        <td>${list.getUserLogin()}</td>
        <td>${list.getDevice()}</td>
        <td>${list.getDate()}</td>
        <td>${list.getPrice()}</td>
        <td>${list.getMasterLogin()}</td>
        <td>${list.getStatus()}</td>
      </tr>
    </c:forEach>
  </table>

  </body>
</html>
