<%--
  Created by IntelliJ IDEA.
  User: cym
  Date: 2019/5/17
  Time: 17:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>welcome</title>
</head>
<body>
学号:<s:property value="#request.username"/><br/>
姓名:<s:property value="#request.name"/><br/>
性别:<s:property value="#request.gender"/><br/>
专业:<s:property value="#request.major"/><br/>
出生时间:<s:property value="#request.birthdate"/><br/>
备注:<s:property value="#request.note"/>
</body>
</html>
