<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Team's profiles management</title>
    <style>
        .error {
            color:red;
        } </style>
</head>
<body>
<form:form action="profileManagementProcess" modelAttribute="profile">
    Person <form:select path="tempPerson">
    <c:forEach var="temp" items="${persons}">
        <form:option  value="${temp.id}" label="${temp.firstName} ${temp.lastName}"/>
    </c:forEach>
</form:select>
    <br>
Age: <form:input type="number" path="age"/>
<form:errors path="age" cssClass="error"/>
<br>
Education<form:checkbox path="education"  value="High school" label="High school"/>
<form:checkbox path="education"  value="College" label="College"/>
<form:checkbox path="education"  value="University" label="University"/>
<form:checkbox path="education"  value="Graduate School" label="Graduate School"/><br>
Other: <form:input path="other"/>
<form:errors path="other" cssClass="error"/>
    <br>  &nbsp<input type="submit" value="Submit"/><input type="reset" value="Reset"/>
</form:form>
</body>
</html>