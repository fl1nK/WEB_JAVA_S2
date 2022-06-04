<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Balance</title>
</head>
<body>
<div class="form">

    <h1>Replenish the balance</h1><br>
    <form method="post" action="BalanceServlet">

        <input type="number" min="1" required name="money"><br>
        <input class="button" type="submit" value="Top up">

    </form>
</div>
<p>${pay}</p><br>
<a href="UserMenuServlet">Back</a>

</body>
</html>
