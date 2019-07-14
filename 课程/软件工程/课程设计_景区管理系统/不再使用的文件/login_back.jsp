<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: cym20
  Date: 2019/6/25
  Time: 1:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆</title>
</head>
<body>
<s:form action="login">
    <s:textfield name="username" label="用户名"/>
    <s:textfield name="password" label="密码"/>
    <s:submit/>
</s:form>
</body>
</html>
