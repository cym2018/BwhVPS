<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: dyh
  Date: 2019/6/27
  Time: 14:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>票务管理</title>
    <jsp:include page="head2.txt"/>
</head>
<body>
<div id="wrapper">
    <jsp:include page="nav.txt"/>
    <div id="page-wrapper">
        <div id="page-inner">
            <div class="row">
                <div class="col-md-12">
                    <h1 class="page-header">
                        票务管理
                        <small>由工作人员操作</small>
                    </h1>
                </div>
            </div>
            <!-- /. ROW  -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-lg-6">
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
                                    <s:if test="#request.ticket.state==4">
                                        退票时间:<s:property value="#request.ticket.out_time"/><br/>
                                        状态:退票成功.
                                    </s:if>
                                </div>
                            </div>
                            <!-- /.row (nested) -->
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <footer><p>Copyright &copy; 2016.Company name All rights reserved.<a target="_blank" href="#">段义浩</a></p>
            </footer>
        </div>
        <!-- /. PAGE INNER  -->
    </div>
</div>
<jsp:include page="footer2.txt"/>
</body>
</html>
