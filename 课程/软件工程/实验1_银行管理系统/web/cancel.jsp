<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: cym20
  Date: 2019/6/6
  Time: 22:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>销户</title>
</head>
<body>
<s:form action="action2">
<s:textfield name="name" label="姓名"/>
<s:textfield name="id_number" label="身份证号"/>
<s:textfield name="card_id" label="卡号"/>
<s:textfield name="password" label="密码"/>
<s:submit/>
</s:form>
<br/>
<s:a href="reg.jsp">办卡</s:a><br>
<s:a href="cancel.jsp">销户</s:a><br>
<s:a href="money.jsp">现金业务</s:a><br>
<s:a href="changepass.jsp">修改密码</s:a><br/>
<s:a href="login.jsp">登录</s:a><br/>
<s:a action="action6">查看信息</s:a><br/>
<s:a action="action7">查询账单</s:a><br/>
<s:a href="transfer.jsp">转账</s:a>
</body>
</html>