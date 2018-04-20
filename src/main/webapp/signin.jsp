<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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

<table align="center">
            <form action='signin' method="POST">
                    <tr>
                        <td align="right">Login:</td><br>
                        <td><input type="text" name="login"/></td><br>
                    </tr>
                    <tr>
                        <td>Password:</td>
                        <td><input type="password" name="password"/></td>
                    </tr>
                <td align="right"><button type="submit" value="Sign in">Sign in</button></td>
                <td align="right"><input type="button" value="Sign up" onClick='location.href="Create?action=insert"'></td>
                <form>

                </form>
            </form>
</table>
</body>
</html>