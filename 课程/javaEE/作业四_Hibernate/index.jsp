<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: cym
  Date: 2019/6/1
  Time: 11:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
  <head>
    <title>主页</title>
  </head>
  <body>
  <h1>主页</h1>
<br/>
  <s:if test="#session.userid==null">
    <s:a href="login.jsp">登录</s:a>
    <br/>
    <s:a href="reg.jsp">注册</s:a>
  </s:if>
  <s:else>
    用户id:<s:property value="#session.userid"/>
    <s:a action="action3_logout">退出登录</s:a>
    <br/>
    <s:a action="action4_showcourse">查看选课信息</s:a>
    <br/>
    <s:a action="action5_selectcourse">进入选课</s:a>
  </s:else>
  <br/><br/>
  <s:a href="index.jsp">主页</s:a>
  <s:a href="login.jsp">登录</s:a>
  <s:a href="reg.jsp">注册</s:a>
  <s:a action="action3_logout">退出登录</s:a>
  <s:a action="action4_showcourse">已选课程</s:a>
  <s:a action="action5_selectcourse">选课</s:a>
  </body>
</html>
