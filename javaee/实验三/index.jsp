<%--
  Created by IntelliJ IDEA.
  User: cym
  Date: 2019/5/17
  Time: 17:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>index</title>
</head>
<body>
<s:i18n name="messageResource">
    <h2>添加学生信息</h2>
    <s:form action="action1" method="POST" enctype="multipart/form-data">
        <s:file name="upload" label="照片1"/>
        <s:file name="upload" label="照片2"/>
        <s:textfield name="username" key="username"/>
        <s:textfield name="name" label="姓名"/>
        <s:radio name="gender" label="性别" list="#{'1':'男','2':'女'}" value="1"/>
        <s:textfield name="major" label="专业"/>
        <s:textfield name="birthday" type="date" label="出生日期" value="2000-01-01"/>
        <s:textarea name="note" label="备注"/>
        <s:submit key="login"/><s:reset value="重置"/>
    </s:form>
</s:i18n>
</body>
</html>
