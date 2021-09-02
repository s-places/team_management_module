<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <style type="text/css">
        .tg  {margin-right:20px;border-collapse:collapse;border-color:#9ABAD9;border-spacing:0;border-style:solid;border-width:1px;}
        .tg td{background-color:#EBF5FF;border-color:#9ABAD9;border-style:solid;border-width:0px;color:#444;
            font-family:Arial, sans-serif;font-size:12px;overflow:hidden;padding:10px 5px;word-break:normal;}
        .tg th{background-color:#409cff;border-color:#9ABAD9;border-style:solid;border-width:0px;color:#fff;
            font-family:Arial, sans-serif;font-size:14px;font-weight:normal;overflow:hidden;padding:10px 5px;word-break:normal;}
        .tg .tg-18eh{border-color:#000000;font-weight:bold;text-align:center;vertical-align:middle}
        .tg .tg-5cz4{background-color:#D2E4FC;font-size:11px;font-weight:bold;border-color:inherit;text-align:center;vertical-align:middle}
        .tg .tg-uzvj{border-color:inherit;font-size:14px;font-weight:bold;text-align:center;vertical-align:middle}
        .tg .tg-td2w{border-color:inherit;font-size:24px;font-weight:bold;text-align:center;vertical-align:middle}
    </style>
    <title>Team List</title>
</head>
<body>
            <table style="float: left" class="tg">
            <thead>
            <tr>
                <th class="tg-td2w" colspan="8">List of Persons in our team</th>
            </tr>
            <tr>
                <th class="tg-uzvj">First Name</th>
                <th class="tg-uzvj">Last Name</th>
                <th class="tg-uzvj">Age</th>
                <th class="tg-uzvj">Education</th>
                <th class="tg-uzvj">Position</th>
                <th class="tg-uzvj">Salary</th>
                <th class="tg-uzvj">Other info.</th>
                <th class="tg-uzvj">Action</th></tr>
            </thead>

                <c:forEach var="temp" items="${listOfPersons}"> <tbody>
                <c:url var="deleteLink" value="/team/deleteProcessForm">
                    <c:param name="personId" value="${temp.id}"/>
                </c:url>
            <tr>
                <td class="tg-5cz4">${temp.firstName}</td>
                <td class="tg-5cz4">${temp.lastName}</td>
                <td class="tg-5cz4">${temp.profile.age}</td>
                <td class="tg-5cz4">${temp.profile.education}</td>
                <td class="tg-5cz4">${temp.position.name}</td>
                <td class="tg-5cz4">${temp.position.salary}</td>
                <td class="tg-5cz4">${temp.profile.other}</td>
                <td class="tg-5cz4">
                    <a href="${deleteLink}" onclick="return confirm('Are you sure?')">Delete</a></td>

            </tr></tbody></c:forEach></table>

            <table style="float: left" class="tg">
                <thead>
                <tr>
                    <th class="tg-td2w" colspan="3">List of Positions</th>
                </tr>
                <tr>
                    <th class="tg-uzvj">Position name</th>
                    <th class="tg-uzvj">Salary</th>
                    <th class="tg-uzvj">Tasks</th>

                </thead>
                <c:forEach var="temp2" items="${listOfPositions}"> <tbody>
                <tr>
                    <td class="tg-5cz4">${temp2.name}</td>
                    <td class="tg-5cz4">${temp2.salary}</td>
                    <td class="tg-5cz4">
                        <c:forEach var="task" items="${temp2.tasksSet}">
                          ${task}<br>
                        </c:forEach>
                    </td>
                </tr></tbody></c:forEach></table>
</div>
</body>
</html>