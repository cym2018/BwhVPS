# Hibernate 框架
## 下载
http://hibernate.org/orm/downloads/
## 导入
在File/Project Structure/Libraries/Hibernate/

添加hibernate 核心包(hibernate-core-6.0.0.Alpha2.jar)

同理导入mysql驱动
## hibernate.cfg.xml
属性|作用
-|-
dialect|sql版本格式
driver_class|驱动程序
url|数据库url
username|username
password|password
show_sql|将sql语句输出到控制台,方便调试程序
mapping resource|映射文件位置
## hibernate接口
## 主键生成策略
key|策略
-|-
assigned|添加数据时自己设置id
native|数据库自动生成int id
uuid.hex|hibernate生成16进制uuid主键
