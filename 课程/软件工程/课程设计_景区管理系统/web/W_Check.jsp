<%--
  Created by IntelliJ IDEA.
  User: dyh
  Date: 2019/6/27
  Time: 21:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>打卡</title>
    <jsp:include page="head2.txt"/>
</head>
<body>
<div id="wrapper">
    <jsp:include page="nav2.txt"/>
    <div id="page-wrapper" >
        <div id="page-inner">
            <div class="row">
                <div class="col-md-12">
                    <h1 class="page-header">
                        打卡管理 <small>员工绩效管理</small>
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
                                    <form role="form">
                                        <div class="form-group">
                                            <label>打卡类型</label>
                                            <label class="radio-inline">
                                                <input type="radio" name="optionsRadiosInline" id="optionsRadiosInline1" value="签到" checked="">签到
                                            </label>
                                            <label class="radio-inline">
                                                <input type="radio" name="optionsRadiosInline" id="optionsRadiosInline2" value="签退">签退
                                            </label>
                                        </div>
                                        <button type="submit" class="btn btn-default">打卡</button>
                                        <button type="reset" class="btn btn-default">重置</button>
                                    </form>

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
            <footer><p>Copyright &copy; 2016.Company name All rights reserved.<a target="_blank" href="#">段义浩</a></p></footer>
        </div>
        <!-- /. PAGE INNER  -->
    </div>
    <!-- /. PAGE WRAPPER  -->
</div>
<jsp:include page="footer2.txt"/>

</body>
</html>
