<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: cym20
  Date: 2019/6/7
  Time: 1:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>账单</title>
</head>
<body>
<table>
    <tr>
        <th>交易类型</th>
        <th>操作</th>
        <th>对象</th>
        <th>金额</th>
    </tr>
    <s:iterator value="#session.list" status="st">
        <tr>
            <td><s:property value="type"/></td>
            <td><s:property value="operate"/></td>
            <td><s:property value="object"/></td>
            <td><s:property value="amount"/></td>
        </tr>
    </s:iterator>
</table>
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
