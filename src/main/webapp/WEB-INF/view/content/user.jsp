<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet">
    <title>Library</title>
</head>
<body>

    <div id="cssHeader">
        <img src="<c:url value='/resources/images/library.png'/>"/>
        <%--j_spring_security_logout - специальная ссылка для разлогирования--%>
        <form action="j_spring_security_logout" style="float: right">
            <input type="submit" value="Выйти" class="cssBtn">
        </form>
    </div>

    <div id="cssLeftMenu">
        <c:if test="${not empty listAuthors}">
            <c:forEach var="authorVar" items="${listAuthors}">
                <a href="<c:url value='/getBooksByAuthorId/${authorVar.id}'/>">${authorVar.name}</a><br /><br />
            </c:forEach>
        </c:if>
    </div>

    <div id="cssRightMenu">
        <c:if test="${not empty listGenres}">
            <c:forEach var="genreVar" items="${listGenres}">
                <a href="<c:url value='/getBooksByGenreId/${genreVar.id}'/>">${genreVar.name}</a><br /><br />
            </c:forEach>
        </c:if>
    </div>

    <div id="cssContent">
        <sec:authorize access="hasRole('ROLE_ADMIN')">
        <c:set var="action" value="/addOrUpdateBook" />
        <%--Spring form--%>
        <form:form method="POST" commandName="book" action="${action}">
            <table>
                <c:if test="${book.id != 0}">
                    <rt>
                        <td>
                            <h3>Редактировать книгу</h3>
                        </td>
                    </rt>
                    <tr>
                        <td>
                            <form:label path="id">id:</form:label>
                        </td>
                        <td>
                            <form:input path="id" readonly="true" />
                        </td>
                    </tr>
                </c:if>

                <c:if test="${book.id == 0}">
                    <rt>
                        <td>
                            <h3>Добавить книгу</h3>
                        </td>
                    </rt>
                </c:if>

                <tr>
                    <td>
                        <form:label path="name">Название книги:</form:label>
                    </td>
                    <td>
                        <form:input path="name" />
                    </td>
                </tr>

                <tr>
                    <td>
                        <form:label path="author">Автор:</form:label>
                    </td>
                    <td>
                        <form:select path="author.id" >
                            <form:option value="-1">Не выбрано</form:option>
                            <form:options items="${listAuthors}" itemLabel="name" itemValue="id"/>
                        </form:select>
                    </td>
                </tr>
                <tr>
                    <td>
                        <form:label path="genre">Жанр:</form:label>
                    </td>
                    <td>
                        <form:select path="genre.id" >
                            <form:option value="-1">Не выбрано</form:option>
                            <form:options items="${listGenres}" itemLabel="name" itemValue="id"/>
                        </form:select>
                    </td>
                </tr>

                <tr>
                    <td>
                        <c:if test="${book.id == 0}">
                            <input type="submit" value="Добавить">
                        </c:if>

                        <c:if test="${book.id != 0}">
                            <input type="submit" value="Обновить">
                        </c:if>
                    </td>
                </tr>
            </table>
        </form:form>
        </sec:authorize>

        <c:if test="${not empty listBooks}">
        <table width="calc(100% - 60px)" border="2" cellspacing="5" cellpadding="5" bgcolor="#eaeaea" align="center">
            <tr align="left" bgcolor=orange>
                <th>id</th>
                <th>Книга</th>
                <th>Автор</th>
                <th>Жанр</th>
                <sec:authorize access="hasRole('ROLE_ADMIN')">
                <th>Удалить</th>
                <th>Редактировать</th>
                </sec:authorize>
            </tr>
            <c:forEach var="bookVar" items="${listBooks}">
                <tr>
                    <td>${bookVar.id}</td>
                    <td>${bookVar.name}</td>
                    <td>${bookVar.author.name}</td>
                    <td>${bookVar.genre.name}</td>
                    <sec:authorize access="hasRole('ROLE_ADMIN')">
                    <td>
                        <a href="<c:url value='/deleteBookById/${bookVar.id}'/>">Удалить книгу</a>
                    </td>
                    <td>
                        <a href="<c:url value='/updateBookById/${bookVar.id}'/>">Редактировать книгу</a>
                    </td>
                    </sec:authorize>
                </tr>
            </c:forEach>
        </table>
        </c:if>
    </div>

    <div id="cssFooter">
        <h2>Футер</h2>
    </div>

</body>
</html>