<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>ЛОГІН</title>
</head>
<body>

<br/>
<div class="form">
    <h1>Вхід</h1><br>
    <form method="post" action="">

        <input type="text" required name="login"><br>
        <input type="password" required name="password"><br><br>
        <input class="button" type="submit" value="Войти">

    </form>
</div>
${error}<br>
<a href="/registration_menu.jsp">Registration</a>
</body>
</html>