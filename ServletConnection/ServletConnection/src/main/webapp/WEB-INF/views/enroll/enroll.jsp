<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Page</title>
    </head>
    <body>
        <h1>Enroll Now In ${requestScope.course.name}</h1>
        <form method="post">
            <div>
                <label>First Name</label>
                <input type="text" name="firstName" required="required"/>
            </div>
            <div>
                <label>Last Name</label>
                <input type="text" name="lastName" required="required"/>
            </div>
            <div>
                <label>Contact Number</label>
                <input type="text" name="contactNumber" required="required"/>
            </div>
            <div>
                <label>Email Address</label>
                <input type="text" name="emailAddress" required="required"/>
            </div>
            <div>
                <label>Course</label>
                <select name="course" required="required">
                    <c:forEach var="co" items="${requestScope.courses}">
                        <option val="${co.id}">${co.name}</option>
                    </c:forEach>
                </select>
            </div>
            <div>
                <button>Submit</button>
            </div>
        </form>
    </body>
</html>
