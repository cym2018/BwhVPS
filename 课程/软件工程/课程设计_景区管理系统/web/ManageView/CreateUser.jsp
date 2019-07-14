 <%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: cym20
  Date: 2019/6/25
  Time: 7:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加用户</title>
</head>
<body>
`<s:form action="createuser">
    <s:textfield name="username" label="用户名"/>
    <s:textfield name="password" label="密码"/>
    <s:radio name="type" label="用户类型" list="#{'1':'管理','2':'员工','3':'商户'}" value="1"/>
    <s:submit/>
</s:form>
</body>
</html>
