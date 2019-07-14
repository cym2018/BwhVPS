<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>骊珠风景区</title>
    <jsp:include page="head1.txt"/>
</head>
<body>
<jsp:include page="header1.txt"/>
<!--==============================Content=================================-->
<div class="content">
    <div class="ic">More Website Templates @ TemplateMonster.com - February 10, 2014!</div>
    <div class="container_12">
        <div class="grid_8">
            <h3>购 票</h3>
            <div class="block2">
                <img src="images/page3_img1.jpg" alt="" class="img_inner fleft">
                <div class="extra_wrapper">
                    <div class="text1 col1"><a href="#">成人票</a></div>
                    <p>购买成人票时，应提供相关有效证件。
                    </p>
                    <br>
                    <!--a href="#" class="link1">购 买</a-->
                    <s:form action="buyticket" theme="simple">
                        <s:hidden value="1" name="type"/>
                        <s:submit value="购 买"/>
                    </s:form>
                </div>
            </div>
            <div class="block2">
                <img src="images/page3_img2.jpg" alt="" class="img_inner fleft">
                <div class="extra_wrapper">
                    <div class="text1 col1"><a href="#">学生票</a></div>
                    <p>
                        在普通大、专院校（含国家教育主管部门批准有学历教育资格的民办大学）、军事院校，中、小学和中等专业学校、技工学校就读，没有工资收入的学生、研究生，家庭居住地和学校不在同一城市时，凭附有加盖院校公章的减价优待证的学生证可半价购票。
                    </p>
                    <br>
                    <s:form action="buyticket" theme="simple">
                        <s:hidden value="2" name="type"/>
                        <s:submit value="购 买"/>
                    </s:form>
                </div>
            </div>
            <div class="block2">
                <img src="images/page3_img3.jpg" alt="" class="img_inner fleft">
                <div class="extra_wrapper">
                    <div class="text1 col1"><a href="#">儿童票</a></div>
                    <p>国家规定一名成年人旅客可以免费携带一名身高不足1.2米的儿童。儿童身高为1.2～1.5米的，请购买儿童票；超过1.5米的，请购买全价票。
                    </p>
                    <br>
                    <s:form action="buyticket" theme="simple">
                        <s:hidden value="3" name="type"/>
                        <s:submit value="购 买"/>
                    </s:form>
                    <!--a href="#" class="link1">购 买</a-->
                </div>
            </div>
        </div>
        <div class="grid_3 prefix_1">
            <h5>骊珠风景区</h5>
            <ul class="list">
                <li><a href="#">落魄山</a></li>
                <li><a href="#">神秀峰</a></li>
                <li><a href="#">仙草山</a></li>
                <li><a href="#">真珠峰</a></li>
                <li><a href="#">彩云峰</a></li>
                <li><a href="#">书简湖</a></li>
                <li><a href="#">宝箓山</a></li>
                <li><a href="#">倒悬山</a></li>
            </ul>
            <a href="#" class="link1">VIEW A<span class="low">ll</span></a>
        </div>
    </div>
</div>
<jsp:include page="footer1.txt"/>
</body>
</html>