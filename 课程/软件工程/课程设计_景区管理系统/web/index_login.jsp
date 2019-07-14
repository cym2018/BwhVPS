<%--
  Created by IntelliJ IDEA.
  User: dyh
  Date: 2019/6/24
  Time: 14:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>骊珠风景区</title>
    <link rel="stylesheet" type="text/css" href="css/scenic.css"/>
</head>
<body>
<script src="js/jquery-1.7.2.min.js" type="text/javascript"></script>
<div class="logo_box">
    <h3>骊珠风景区欢迎你</h3>
    <s:form action="login" name="f" theme="simple" method="post">
        <div class="input_outer">
            <span class="u_user"></span>
            <input name="username" class="text" onFocus=" if(this.value=='输入ID或用户名登录') this.value=''"
                   onBlur="if(this.value=='') this.value='输入ID或用户名登录'" value="输入ID或用户名登录"
                   style="color: #FFFFFF !important" type="text">
        </div>
        <div class="input_outer">
            <span class="us_uer"></span>
            <label class="l-login login_password" style="color: rgb(255, 255, 255);display: block;">输入密码</label>
            <input name="password" class="text" style="color: #FFFFFF !important; position:absolute; z-index:100;"
                   onFocus="$('.login_password').hide()" onBlur="if(this.value=='') $('.login_password').show()"
                   value="" type="password">
        </div>
        <div class="mb2">
            <input type="submit" class="act-but submit" style="color: #FFFFFF" value="登录"/>
                <%--<a class="act-but submit" href="javascript:;" style="color: #FFFFFF">登录</a>--%>
        </div>
        <input name="savesid" value="0" id="check-box" class="checkbox" type="checkbox"><span>记住用户名</span>
    </s:form>
    <a href="#" class="login-fgetpwd" style="color: #FFFFFF">忘记密码？</a>


    <div class="sas">
        <!--a href="#">还没注册账号！</a-->
    </div>

</div>

</body>
</html>
