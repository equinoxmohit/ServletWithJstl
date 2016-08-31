<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <ul>
            <c:forEach var="course" items="${requestScope.courses}">
                <li><a href="course?id=${course.id}">${course.name}</a></li>
            </c:forEach>
     </ul>
    </body>
</html>
