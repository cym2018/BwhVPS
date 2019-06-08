<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: cym20
  Date: 2019/6/6
  Time: 23:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改密码</title>
</head>
<body>
<s:form action="action3">
    <s:textfield name="card_id" label="卡号"/>
    <s:textfield name="password" label="旧密码"/>
    <s:textfield name="password1" label="新密码"/>
    <s:submit/>
</s:form>
</body>
</html>
