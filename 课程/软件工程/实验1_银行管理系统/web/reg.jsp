<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: cym20
  Date: 2019/6/6
  Time: 22:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>办卡</title>
</head>
<body>
<s:form action="action1">
    <s:textfield name="name" label="姓名"/>
    <s:textfield name="id_number" label="身份证号"/>
    <s:textfield name="card_id" label="卡号"/>
    <s:textfield name="password" label="密码"/>
    <s:textfield name="phone_number" label="手机号"/>
    <s:submit/>
</s:form>
</body>
</html>
