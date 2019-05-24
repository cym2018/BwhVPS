<%--
  Created by IntelliJ IDEA.
  User: cym
  Date: 2019/5/10
  Time: 9:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<body>
<form action="register_result.jsp" method="get">
    用户名:<input type="text" name="strUsername"/>
    <br/>
    密码:<input type="password" name="strPassword"/>
    <br/>
    <input type="submit" value="注册"/> <a href="login.jsp"><input type="button" value="登录"/></a>
</form>
</body>
</html>
