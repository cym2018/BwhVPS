<%--
  Created by IntelliJ IDEA.
  User: cym
  Date: 2019/5/10
  Time: 12:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login_Result</title>
</head>
<body>
<jsp:useBean id="beanUser" class="xyz.cym2018.Bean.UserBean"/>
<%
    beanUser.setStrUsername(request.getParameter("strUsername"));
    beanUser.setStrPassword(request.getParameter("strPassword"));
    if (beanUser.bLogin()) {
%>登录成功<%
} else {
%>登录失败<%
    }
%>
</body>
</html>
