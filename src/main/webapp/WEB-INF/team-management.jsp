
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib  uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Team Management</title>
    <style>
        .error {
            color:red;
        } </style>
</head>
<body>
<h2>Team Management</h2><hr>

<form:form action="teamManagementProcess" modelAttribute="person">
  First Name: <form:input path="firstName"/>
    <form:errors path="firstName" cssClass="error"/>
    <br>


    Last Name: <form:input path="lastName"/>
    <form:errors path="lastName" cssClass="error"/>
    <br>

    Position <form:select path="tempPosition">
    <c:forEach var="temp" items="${positions}">
        <form:option  value="${temp.id}" label="${temp.name}"/>
    </c:forEach>
</form:select>
    <br>  &nbsp<input type="submit" value="Submit"/><input type="reset" value="Reset"/>
<br>
</form:form>
</body>
</html>