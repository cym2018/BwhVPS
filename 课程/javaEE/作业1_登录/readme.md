# 2019年5月10日
javaee 作业

简单登录功能

javaBean+jsp+mysql

MySQL配置:
数据库名:javaee

建表语句:
```sql
create table user(id int primary key auto_increment,username varchar(10) not null,password varchar(20) not null);
```
数据库名,表名,数据库用户名,数据库密码,用户名和密码长度限制可在UserBean构造函数内修改
