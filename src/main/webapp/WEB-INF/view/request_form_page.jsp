<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head><style>
    .error {
    color:red;
    } </style>
<title>Request Form</title>
    <h1>Please fill the next fields</h1>
</head>
<body>


    
<form:form action="processFormPage" modelAttribute="personalDataForm">


    First Name: <form:input path="firstName"/>
    <form:errors path="firstName" cssClass="error"/>
    <br>


    Last Name: <form:input path="lastName"/>
    <form:errors path="lastName" cssClass="error"/>
    <br>


    <form:radiobutton path="sex" value="Male" label="Male"/>
    <form:radiobutton path="sex" value="Female" label="Female"/><br>

    Country <form:select path="country">
        <form:option value="USA" label="USA"/>
        <form:option value="Canada" label="Canada"/>
        <form:option value="Mexico" label="Mexico"/>
        <form:option value="Guatemala" label="Guatemala"/>
        <form:option value="El Salvador" label="El Salvador"/>
    </form:select><br>


         <form:checkbox path="education" value="High school" label="High school"/>
        <form:checkbox path="education"  value="College" label="College"/>
        <form:checkbox path="education"  value="University" label="University"/>
        <form:checkbox path="education"  value="Graduate School" label="Graduate School"/><br>


    &nbsp<input type="submit" value="Submit"/><input type="reset" value="Reset"/>
</form:form>
</body>
</html>