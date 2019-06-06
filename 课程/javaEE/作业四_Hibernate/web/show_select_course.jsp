<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: cym
  Date: 2019/6/1
  Time: 15:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>选课信息</title>
</head>
<body>
<h1>已选课程</h1>
<table>
    <tr><th>课程号</th><th>课程名</th><th>开课时间</th><th>学习时间</th><th>学分</th></tr>
    <s:iterator value="#request.list">
        <tr>
            <td><s:property value="id"/></td>
            <td><s:property value="coursename"/></td>
            <td><s:property value="semester"/></td>
            <td><s:property value="studyhour"/></td>
            <td><s:property value="credits"/></td>
        </tr>
    </s:iterator>
</table>
<br/><br/>
<s:a href="index.jsp">主页</s:a>
<s:a href="login.jsp">登录</s:a>
<s:a href="reg.jsp">注册</s:a>
<s:a action="action3_logout">退出登录</s:a>
<s:a action="action4_showcourse">已选课程</s:a>
<s:a action="action5_selectcourse">选课</s:a>
</body>
</html>
