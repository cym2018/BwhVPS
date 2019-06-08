<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: cym20
  Date: 2019/6/7
  Time: 1:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>转账</title>
</head>
<body>
<s:form action="action8">
    <s:textfield name="strName" label="对方姓名"/>
    <s:textfield name="strCard_id" label="对方卡号"/>
    <s:textfield name="password" label="密码"/>
    <s:textfield name="amount" label="金额"/>
    <s:submit/>
</s:form>
</body>
</html>
