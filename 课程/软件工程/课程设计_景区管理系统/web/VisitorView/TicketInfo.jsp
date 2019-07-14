<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: cym20
  Date: 2019/6/25
  Time: 2:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>门票信息</title>
</head>
<body>
id:<s:property value="#request.ticket.id"/><br/>
购票时间:<s:property value="#request.ticket.buy_time"/><br/>



<s:if test="#request.ticket.state==0">
    状态:已购票.
    <s:form action="ticketoperate">
        <s:hidden name="operate" value="1"/>
        <s:submit value="入场"/>
    </s:form>
    <s:form action="ticketoperate">
        <s:hidden name="operate" value="2"/>
        <s:submit value="退票"/>
    </s:form>
    <!--退票或入场-->
</s:if>


<s:if test="#request.ticket.state==1">
    入场时间:<s:property value="#request.ticket.in_time"/><br/>
    状态:游览中
    <s:form action="ticketoperate">
        <s:hidden name="operate" value="3"/>
        <s:submit value="离场"/>
    </s:form>
    <!--离场-->
</s:if>


<s:if test="#request.ticket.state==2">
    入场时间:<s:property value="#request.ticket.in_time"/><br/>
    离场时间:<s:property value="#request.ticket.out_time"/><br/>
    状态:已离开.
</s:if>



<s:if test="#request.ticket.state==3">
<!--失效-->
    状态:过期失效.
</s:if>



<s:if test="#request.ticket.v_state==4">
    退票时间:<s:property value="#request.ticket.out_time"/><br/>
    状态:退票成功.
</s:if>



</body>
</html>
