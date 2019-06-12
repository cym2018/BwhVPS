<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: cym20
  Date: 2019/6/7
  Time: 0:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查看信息</title>
</head>
<body>
卡号:<s:property value="#session.card_id"/><br/>
持有者:<s:property value="#session.name"/><br/>
余额:<s:property value="#session.balance"/>
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
