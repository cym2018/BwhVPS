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
</body>
</html>
