<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: cym20
  Date: 2019/6/26
  Time: 12:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>流水</title>
</head>
<body>
<table>
    <tr>
        <th>id</th>
        <th>交易时间</th>
        <th>交易类型</th>
        <th>金额</th>
    </tr>
    <s:iterator value="#request.list">
        <tr>
            <td><s:property value="id"/></td>
            <td><s:property value="time"/></td>
            <td><s:property value="type"/></td>
            <td><s:property value="money"/></td>
        </tr>
    </s:iterator>
</table>
</body>
</html>
