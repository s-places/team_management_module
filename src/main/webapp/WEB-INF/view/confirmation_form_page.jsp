<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<title>Confirmation Page</title>
</head>
<body>
First Name: ${personalDataForm.firstName}<br>
Last Name: ${personalDataForm.lastName}<br>
County: ${personalDataForm.country}<br>
Sex: ${personalDataForm.sex}<br>
Education:
<sl><c:forEach var="temp" items="${personalDataForm.education}">
        <li>${temp}</li>
    </c:forEach></sl>
</body>
</html>