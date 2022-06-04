<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<a href="<c:url value="/"/>">Back</a>

<div class="form">

    <h1>Регістрація</h1><br>
    <form method="post" action="<c:url value="/RegistrationControllers"/>">

        <input type="text" required name="login"><br>
        <input type="password" required name="password"><br><br>
        <input class="button" type="submit" value="Register">

    </form>
</div>
<p>${error}</p>
</body>
</html>
