<%--
  Created by IntelliJ IDEA.
  User: cym
  Date: 2019/5/10
  Time: 11:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register_Result</title>
</head>
<body>
<jsp:useBean id="beanUser" class="xyz.cym2018.Bean.UserBean" scope="page"/>
<jsp:setProperty name="beanUser" property="*"/>
<%

    beanUser.setStrUsername(request.getParameter("strUsername"));
    beanUser.setStrPassword(request.getParameter("strPassword"));
    if (beanUser.bRegister()) {
%>注册成功<%
} else {
%>注册失败,用户名已存在<%
    }
%>
<br/>
用户名:<%=beanUser.getStrUsername()%>
<br/>
密码:<%=beanUser.getStrPassword()%>
</body>
</html>
