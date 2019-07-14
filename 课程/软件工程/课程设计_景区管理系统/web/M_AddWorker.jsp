<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: dyh
  Date: 2019/6/27
  Time: 16:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加员工信息</title>
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
                        添加员工信息
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
                                    <s:form action="addworker" method="POST" theme="simple" role="form">
                                        <div class="form-group">
                                            <label>姓名:</label>
                                            <input name="name" type="text" class="form-control"
                                                   onFocus=" if(this.value=='输入员工姓名') this.value=''"
                                                   onBlur="if(this.value=='') this.value='输入员工姓名'"
                                                   value="输入员工姓名">
                                        </div>
                                        <div class="form-group">
                                            <lable>工资：</lable>
                                            <input type="text" name="salary" class="form-control"
                                                   onFocus=" if(this.value=='输入员工工资') this.value=''"
                                                   onBlur="if(this.value=='') this.value='输入员工工资'"
                                                   value="输入员工工资">
                                        </div>
                                        <div class="form-group">
                                            <lable>职务：</lable>
                                            <input name="work" type="text" class="form-control"
                                                   onFocus=" if(this.value=='输入员工职务') this.value=''"
                                                   onBlur="if(this.value=='') this.value='输入员工职务'"
                                                   value="输入员工职务">
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
