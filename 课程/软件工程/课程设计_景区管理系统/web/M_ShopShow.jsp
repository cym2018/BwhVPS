<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: dyh
  Date: 2019/6/27
  Time: 19:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商铺管理</title>
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
                        统计信息查看
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
                                    <div class="panel panel-default">

                                        <div class="panel-heading">
                                            统计信息查看
                                        </div>

                                        <div class="panel-body">
                                            <div class="table-responsive">
                                                <table class="table">
                                                    <thead>
                                                    <tr>
                                                        <th>#</th>
                                                        <th>名称</th>
                                                        <th>位置</th>
                                                        <th>状态</th>
                                                        <th>操作</th>
                                                    </tr>
                                                    </thead>
                                                    <tbody>
                                                    <s:iterator value="#request.list">
                                                        <tr class="info">
                                                            <td><s:property value="id"/></td>
                                                            <td><s:property value="name"/></td>
                                                            <td><s:property value="place"/></td>
                                                            <s:if test="state==1">
                                                                <td>闲置</td>
                                                            </s:if>
                                                            <s:elseif test="state==2">暂停营业</s:elseif>
                                                            <s:else>
                                                                <td>营业中</td>
                                                            </s:else>
                                                            <td><s:form action="manageshop">
                                                                <s:hidden name="selectid" value="%{id}"/>
                                                                <s:submit theme="simple" value="管理"/>
                                                            </s:form></td>
                                                        </tr>
                                                    </s:iterator>
                                                    </tbody>
                                                </table>
                                            </div>
                                        </div>
                                    </div>
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




