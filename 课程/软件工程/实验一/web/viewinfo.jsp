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
</body>
</html>
