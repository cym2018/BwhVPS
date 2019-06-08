# struts2是如何实现MVC的
M:action

应用程序核心,用于处理数据

V:jsp页面

负责显示页面

C:struts框架.

拦截request参数,传递给action,获取action处理结果并返回页面
# struts2的开发步骤及工作流程
### 开发步骤
1.设计程序逻辑,编写action

2.编写jsp页面

3.修改struts.xml
### 工作流程
1.http请求首先被struts框架处理,获取提交的参数
d
2.根据web.xml的设置,选择响应的action

3.使用执行set函数向action提交参数值

4.action执行后返回结果,struts根据返回结果和struts.xml的设置,选择返回的页面
# 如何将Struts2.3.37升级为2.5.20版本
web.xml
```xml
删除
<filter-class>org.apache.struts2.dispatcher.ng.filter.StrutsPrepareAndExecuteFilter</filter-class>
添加
<filter-class>org.apache.struts2.dispatcher.filter.StrutsPrepareAndExecuteFilter</filter-class>
```
升级jdk版本

升级tomcat版本
