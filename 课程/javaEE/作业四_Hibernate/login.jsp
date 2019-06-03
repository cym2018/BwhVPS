<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: cym
  Date: 2019/6/1
  Time: 11:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
<h1>登录</h1>
<s:form action="action1_login" method="POST">
    <s:textfield label="用户名" name="username"/>
    <s:password label="密码" name="password"/>
    <s:submit/>
</s:form>
<br/><br/>
<s:a href="index.jsp">主页</s:a>
<s:a href="login.jsp">登录</s:a>
<s:a href="reg.jsp">注册</s:a>
<s:a action="action3_logout">退出登录</s:a>
<s:a action="action4_showcourse">已选课程</s:a>
<s:a action="action5_selectcourse">选课</s:a>
</body>
</html>
