<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/registration" method="post">
    <label for="name">Имя:
        <input type="text" name="name" id="name">
    </label><br>
    <label for="birthday">Дата рождения:
        <input type="date" name="birthday" id="birthday">
    </label><br>
    <label for="email">Почта:
        <input type="email" name="email" id="email">
    </label><br>
    <label for="passwordId">Password:
        <input type="password" name="password" id="passwordId">
    </label><br> 
    <select name="role" id="role">
        <c:forEach var="role" items="${requestScope.roles}">
            <option value="${role}">${role}</option>
        </c:forEach>
    </select><br>
    <c:forEach var="gender" items="${requestScope.genders}">
        <input type="radio" name="gender" value="${gender}"> ${gender}
        <br>
    </c:forEach>
    
    <button type="submit">Отправить</button>
    <br>
</form>
</body>
</html>
