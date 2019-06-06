<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: cym20
  Date: 2019/6/6
  Time: 23:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>现金业务</title>
</head>
<body>
<s:form action="action5">
    <s:radio name="state" label="存取" list="#{'1':'存钱','2':'取钱'}" value="1"/>
    <s:textfield name="amount" value="100" label="金额"/>
    <s:submit/>
</s:form>
</body>
</html>
