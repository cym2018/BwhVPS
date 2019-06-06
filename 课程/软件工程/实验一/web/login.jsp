<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: cym20
  Date: 2019/6/7
  Time: 0:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
<s:form action="action4">
    <s:textfield name="card_id" label="卡号"/>
    <s:textfield name="password" label="密码"/>
    <s:submit/>
</s:form>
</body>
</html>
