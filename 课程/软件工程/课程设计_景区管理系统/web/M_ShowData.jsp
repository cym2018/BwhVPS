<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: dyh
  Date: 2019/6/27
  Time: 16:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>统计</title>
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
                                                        <th>统计项目</th>
                                                        <th>统计结果</th>
                                                    </tr>
                                                    </thead>
                                                    <tbody>
                                                    <tr class="success">
                                                        <td>1</td>
                                                        <td>过去三十天游客总数:</td>
                                                        <td><s:property value="#request.V30"/></td>
                                                    </tr>
                                                    <tr class="info">
                                                        <td>2</td>
                                                        <td>过去24小时游客人：</td>
                                                        <td><s:property value="#request.V1"/></td>
                                                    </tr>
                                                    <tr class="warning">
                                                        <td>3</td>
                                                        <td>景区内人数：</td>
                                                        <td><s:property value="#request.V0"/></td>
                                                    </tr>
                                                    <tr class="danger">
                                                        <td>4</td>
                                                        <td>过去三十天收支:</td>
                                                        <td><s:property value="#request.balance30"/></td>
                                                    </tr>
                                                    <tr class="success">
                                                        <td>5</td>
                                                        <td>过去24小时收支：</td>
                                                        <td><s:property value="#request.balance1"/></td>
                                                    </tr>
                                                    <tr class="info">
                                                        <td>6</td>
                                                        <td>过去三十天收入:</td>
                                                        <td><s:property value="#request.income30"/></td>
                                                    </tr>
                                                    <tr class="warning">
                                                        <td>7</td>
                                                        <td>过去24小时收入:</td>
                                                        <td><s:property value="#request.income1"/></td>
                                                    </tr>
                                                    <tr class="danger">
                                                        <td>8</td>
                                                        <td>过去三十天支出:</td>
                                                        <td><s:property value="#request.spend30"/></td>
                                                    </tr>
                                                    <tr class="success">
                                                        <td>9</td>
                                                        <td>过去24小时支出:</td>
                                                        <td><s:property value="#request.spend1"/></td>
                                                    </tr>
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
