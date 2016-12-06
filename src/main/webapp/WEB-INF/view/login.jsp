<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <%--<link href="resources/css/style.css" rel="stylesheet"/>--%>
    <link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet">
    <title>Login</title>
</head>
<body>

<form name="form_login" action="j_spring_security_check" method="POST" class="cssFormLogin">
    <table>
        <tr>
            <td>Имя пользователя:</td>
            <td><input type="text" name="user_login"></td>
        </tr>
        <tr>
            <td>Пароль:</td>
            <td><input type="password" name="password_login" /></td>
        </tr>
        <tr>
            <td><input name="submit" type="submit" value="Войти" class="cssBtn" /></td>
        </tr>
        <tr>
            <td>
                <c:if test="${not empty error}">
                    <div class="cssError">
                            ${error}
                    </div>
                </c:if>

                <c:if test="${not empty logout}">
                    <div class="cssError">
                            ${logout}
                    </div>
                </c:if>
            </td>
        </tr>
    </table>
</form>

</body>
</html>
