<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: cym20
  Date: 2019/6/25
  Time: 8:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加员工</title>
</head>
<body>
<s:form action="addworker">
    <s:textfield label="姓名" name="name"/>
    <s:textfield label="工资" name="salary"/>
    <s:textfield label="职位" name="work"/>
    <s:submit/>
</s:form>
</body>
</html>
