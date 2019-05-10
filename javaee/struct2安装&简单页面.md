# 适用于 IDEA,struts2.5.20

## 新建项目
打开IDEA,新建struts2项目,选择"Set up library later".

## 导入jar
[下载struts](https://struts.apache.org/download.cgi#struts2520)

将struts解压到项目的WEB-INF/lib文件夹中,同时给tomcat/lib复制一份.
###### 遇到的问题:导入完整版本(65M)会出错,但4M版本没有问题.
## web.xml
照抄老师的代码
```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-app_4_0.xsd"
         version="4.0">
    <filter>
        <filter-name>default</filter-name>
        <filter-class>org.apache.struts2.dispatcher.filter.StrutsPrepareAndExecuteFilter</filter-class>
    </filter>
    <filter-mapping>
        <filter-name>default</filter-name>
        <url-pattern>*.action</url-pattern>
    </filter-mapping>
</web-app>
```
## struts.xml
同上,稍微改一下class的内容
```xml
<?xml version="1.0" encoding="UTF-8"?>

<!DOCTYPE struts PUBLIC
        "-//Apache Software Foundation//DTD Struts Configuration 2.5//EN"
        "http://struts.apache.org/dtds/struts-2.5.dtd">
<struts>
    <package name="default" extends="struts-default">
        <action name="action1" class="xyz.cym2018.struts.action.Action1">
            <result name="success">/welcome.jsp</result>
            <result name="error">/index.jsp</result>
        </action>
    </package>
</struts>
```
## jsp文件
index.jsp
```jsp
<%--
  Created by IntelliJ IDEA.
  User: cym
  Date: 2019/5/11
  Time: 6:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Index</title>
</head>
<body>
<form action="action1.action" method="post">
    <input type="text" name="name"><br>
    <input type="submit">
</form>
</body>
</html>
```
welcome.jsp
```jsp
<%--
  Created by IntelliJ IDEA.
  User: cym
  Date: 2019/5/11
  Time: 6:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>welcome</title>
</head>
<body>
hello,<s:property value="#request.name"/>!
</body>
</html>
```
## 运行
结束

