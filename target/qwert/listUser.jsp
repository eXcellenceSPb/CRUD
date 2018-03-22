<%--
  Created by IntelliJ IDEA.
  User: vserg
  Date: 17.03.2018
  Time: 22:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Show All Users</title>
</head>
<body>
<table border=1>
    <thead>
    <tr>
        <th>User Id</th>
        <th>User Name</th>
        <th>User Pass</th>
        <th>User Login</th>
        <th colspan=2>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${qwert}" var="qwert">
        <tr>
            <td><c:out value="${qwert.id}" escapeXml="false"/></td>
            <td><c:out value="${qwert.name}"/></td>
            <td><c:out value="${qwert.pass}"/></td>
            <td><c:out value="${qwert.login}"/></td>
            <td><a href="TestServlet?action=edit&id=${qwert.id}">Update</a></td>
            <td><a href="TestServlet?action=delete&id=${qwert.id}">Delete</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<p><a href="TestServlet?action=insert">Add User</a></p>
</body>
</html>
