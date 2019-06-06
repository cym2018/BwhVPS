<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: cym
  Date: 2019/6/1
  Time: 12:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>注册成功</title>
</head>
<body>
<h1>注册成功</h1>
你的用户名:<s:property value="#request.username"/><br/>
你的密码:<s:property value="#request.password"/><br/>
你的用户id:<s:property value="#request.userid"/>
<br/><br/>
<s:a href="index.jsp">主页</s:a>
<s:a href="login.jsp">登录</s:a>
<s:a href="reg.jsp">注册</s:a>
<s:a action="action3_logout">退出登录</s:a>
<s:a action="action4_showcourse">已选课程</s:a>
<s:a action="action5_selectcourse">选课</s:a>
</body>
</html>
