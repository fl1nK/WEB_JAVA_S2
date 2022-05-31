<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>USER</title>
</head>
<body>

<h1>LOGIN USER ${login} !!!</h1>
<p>MONEY: ${money} </p>
<a href="<c:url value="/balance.jsp"/>">Replenish the balance</a><br>
<a href="<c:url value="/logout"/>">Logout</a>

<div class="form">

    <h1>ЗАКАЗ</h1><br>
    <form method="post" action="OrdersController">

        <input type="text" required name="device"><br>
        <input class="button" type="submit" value="Отправить заказ">

    </form>
</div>
<p>${error}</p>
<table>
    <tr>
        <td>ID</td>
        <td>Device</td>
        <td>Date</td>
        <td>Price</td>
        <td>Master</td>
        <td>Status</td>
        <td></td>

    </tr>
<c:forEach items="${list}" var="list">
    <tr>
        <td>${list.getID()}</td>
        <td>${list.getDevice()}</td>
        <td>${list.getDate()}</td>
        <td>${list.getPrice()}</td>
        <td>${list.getMasterLogin()}</td>
        <td>${list.getStatus()}</td>
        <td>
           <c:if test = "${list.getStatus() == 'Awaiting payment'}" >
               <form method="post" action="AcceptController">
                   <button value="${list.getID()}" name="pay">Pay</button>
               </form>
           </c:if>
            <c:if test = "${list.getStatus() == 'Awaiting processing' || list.getStatus() == 'Awaiting payment'}" >
            <form method="post" action="CancelController">
                <button value="${list.getID()}" name="cancel">Cancel</button>
            </form>
            </c:if>
            <c:if test = "${list.getStatus() == 'Repair completed' && list.getComment() == null}" >
                <form method="post" action="CommentController">
                    <input type="text" required name="comment"><br>
                    <button value="${list.getID()}" name="id">Send</button>
                </form>
            </c:if>
        </td>
    </tr>
</c:forEach>
</table>


<script>

</script>

</body>
</html>