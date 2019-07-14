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
                                    <s:form action="buyticket" theme="simple" method="POST" name="" role="form">
                                        <div class="form-group">
                                            <label>购票类型</label>
                                            <label class="radio-inline">
                                                <input name="type" type="radio" name="optionsRadiosInline" id="optionsRadiosInline1"
                                                       value="1" checked="">成人票
                                            </label>
                                            <label class="radio-inline">
                                                <input name="type" type="radio" name="optionsRadiosInline" id="optionsRadiosInline2"
                                                       value="2">学生票
                                            </label>
                                            <label class="radio-inline">
                                                <input name="type" type="radio" name="optionsRadiosInline" id="optionsRadiosInline3"
                                                       value="3">儿童票
                                            </label>
                                        </div>
                                        <button type="submit" class="btn btn-default">购票</button>
                                        <button type="reset" class="btn btn-default">重置</button>
                                    </s:form>


                                </div>
                                <div class="col-lg-6">
                                    <label>已出票管理</label>
                                    <s:form  class="form" action="ticketinfo" method="POST" theme="simple">
                                        <!-- 1 入场 2 退票 3 离场 -->
                                        <div class="form-group">
                                            <lable>门票id：</lable>
                                            <input type="text" name="id" class="form-control"
                                                   onFocus=" if(this.value=='输入门票id') this.value=''"
                                                   onBlur="if(this.value=='') this.value='输入门票id'"
                                                   value="输入门票id">
                                        </div>

                                        <button type="submit" class="btn btn-default">提交</button>

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
