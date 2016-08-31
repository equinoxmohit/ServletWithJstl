<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <h1>Enroll In :${requestScope.course.name}</h1>
        <h2>Fees:${requestScope.course.fees}</h2>
        <a href="enroll?id=${requestScope.course.id}">Enroll</a>
    </body>
</html>
