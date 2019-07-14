<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: cym20
  Date: 2019/6/25
  Time: 1:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>售票系统</title>
</head>
<body>
<s:form action="buyticket">
    <s:radio name="type" label="类型" list="#{'1':'成人票','2':'儿童票','3':'学生票'}" value="1"/>
    <s:submit/>
</s:form>
</body>
</html>
