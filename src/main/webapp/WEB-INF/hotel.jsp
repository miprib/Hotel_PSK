<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <table>
        <th>Id</th>
        <th>Name</th>
        <c:forEach items="${hotels}" var="hotel">
            <tr>
                <td>${hotel.id}</td>
                <td>${hotel.name}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
