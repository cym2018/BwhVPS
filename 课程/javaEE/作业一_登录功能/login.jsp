<%--
  Created by IntelliJ IDEA.
  User: cym
  Date: 2019/5/10
  Time: 12:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<form action="login_result.jsp" method="get">
    用户名:<input type="text" name="strUsername"/>
    <br/>
    密码:<input type="password" name="strPassword"/>
    <br/>
    <input type="submit" value="登录"/>  <a href="register.jsp"><input type="button" value="注册"/></a>
</form>
</body>
</html>
