# 下载
http://tomcat.apache.org/
# 安装
1.给startup.sh加执行权限
2.执行startup.sh


[Tomcat 自动加载更新配置](https://blog.csdn.net/lismooth/article/details/52886205)
1.找到tomacat的安装目录。

2,找到conf文件夹下的server.xml（关于server.xml的介绍可以看这个 http://blog.csdn.net/weinianjie1/article/details/7954425）

3.加上
```xml
<Context path="/test" docBase="test" reloadable="true"/>  
```
Context属性有：

className:指定实现org.apache.catalina.Context接口的类,默认值为org.apache.catalina.core.StandardContext.          

path:指定访问该Web应用的URL入口.          

docBase:指定Web应用的文件路径.可以给定绝对路径,也可以给定相对于Host的appBase属性的相对路径.     如果Web应用采用开放目录结构,那就指定Web应用的根目录;如果Web应用是个WAR文件,那就指定WAR文件的路径.          

reloadable:如果这个属性设为true,Tomcat服务器在运行状态下会监视在WEB-INF/class和WEB-INF/lib目录下CLASS文件的改动.如果检测到有calss文件被更新,服务器会自动重新加载Web应用.          

cookies:指定是否通过Cookie来支持Session,默认为true.          

useNaming:指定是否支持JNDI,默认为true。
