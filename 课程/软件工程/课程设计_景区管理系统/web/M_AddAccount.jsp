<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: dyh
  Date: 2019/6/27
  Time: 15:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>账号管理</title>
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
                        账号注册
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
                                    <s:form method="post" theme="simple" action="createuser" role="form">
                                        <div class="form-group">
                                            <label>账号:</label>
                                            <input name="username" type="text" class="form-control" lable="账号："
                                                   onFocus=" if(this.value=='输入ID或用户名') this.value=''"
                                                   onBlur="if(this.value=='') this.value='输入ID或用户名'"
                                                   value="输入ID或用户名">
                                        </div>
                                        <div class="form-group">
                                            <lable>密码：</lable>
                                            <input name="password" type="password" class="form-control" lable="密码："
                                                   onFocus="$('.login_password').hide()"
                                                   onBlur="if(this.value=='') $('.login_password').show()" value="">
                                        </div>
                                        <div class="form-group">
                                            <label class="radio-inline">
                                                <input name="type" type="radio" name="optionsRadiosInline" id="optionsRadiosInline1"
                                                       value="1" checked="">管理
                                            </label>
                                            <label class="radio-inline">
                                                <input name="type" type="radio" name="optionsRadiosInline" id="optionsRadiosInline2"
                                                       value="2">员工
                                            </label>
                                            <label class="radio-inline">
                                                <input name="type" type="radio" name="optionsRadiosInline" id="optionsRadiosInline3"
                                                       value="3">商户
                                            </label>
                                        </div>
                                        <button type="submit" class="btn btn-default">注册</button>
                                        <button type="reset" class="btn btn-default">重置</button>
                                    </s:form>

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
