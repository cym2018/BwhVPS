<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: cym20
  Date: 2019/6/25
  Time: 2:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>票务相关</title>
</head>
<body>
<s:form action="ticketinfo">
    <s:textfield label="门票id" name="id"/>
    <s:submit/>
</s:form>
</body>
</html>
