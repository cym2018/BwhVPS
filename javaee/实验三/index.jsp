<%--
  Created by IntelliJ IDEA.
  User: cym
  Date: 2019/5/11
  Time: 6:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Index</title>
</head>
<body>
<h2>添加学生信息</h2>
<s:form action="action1" method="POST">
    <s:textfield name="username" label="学号"/>
    <s:textfield name="name" label="姓名"/>
    <s:radio name="gender" label="性别" list="#{'1':'男','2':'女'}" value="1"/>
    <s:textfield name="major" label="专业"/>
    <s:textfield name="birthdate" type="date" label="出生日期" value="2000-01-01"/>
    <s:textarea name="note" label="备注"/>
    <s:submit value="添加"/><s:reset value="重置"/>
</s:form>
</body>
</html>
