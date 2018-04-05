<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: vserg
  Date: 17.03.2018
  Time: 22:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link type="text/css"
          href="css/ui-lightness/jquery-ui-1.8.18.custom.css" rel="stylesheet"/>
    <script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
    <script type="text/javascript" src="js/jquery-ui-1.8.18.custom.min.js"></script>
    <title>Add new user</title>
</head>
<body>

<form method="POST" action='Update' name="frmAddUser">
    Id : <input
    type="text" readonly name="id"
    value=
    <c:out value="${qwert.id}" />> <br/>
    Name : <input
        type="text" name="name"
        value=
<c:out value="${qwert.name}" />> <br/>
    Pass : <input
        type="text" name="pass"
        value=
<c:out value="${qwert.pass}" />> <br/>
    Login : <input
        type="text" name="login"
        value=
<c:out value="${qwert.login}" />> <br/>
    <input
            type="submit" value="Submit"/>
</form>

</body>
</html>
