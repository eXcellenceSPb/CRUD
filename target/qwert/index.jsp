<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link type="text/css"
          href="css/ui-lightness/jquery-ui-1.8.18.custom.css" rel="stylesheet"/>
    <script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
    <script type="text/javascript" src="js/jquery-ui-1.8.18.custom.min.js"></script>
    <title>Web App</title>
</head>
<body>
<a href="SigninServlet">Click here to see servlet</a>
<jsp:forward page="/signin" />

<%--<form action='signin' method="POST">--%>
    <%--Login: <input type="text" name="login"/>--%>
    <%--Password: <input type="password" name="password"/>--%>
    <%--<input type="submit" value="Sign in">--%>
<%--</form>--%>
<%--<br>--%>

<a href="Create?action=insert">Sign Up</a></p>

</body>
</html>