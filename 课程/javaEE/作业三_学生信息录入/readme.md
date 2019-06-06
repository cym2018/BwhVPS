# struts2
- [x] struts基本开发
- [x] 验证框架
- [x] 国际化
- [x] 拦截器
- [x] 单文件上传
- [x] 多文件上传
## 2019/05/17
校验框架有问题.无论输入是否正确都会报错

重写了一遍,莫名其妙的好了.前后代码几乎没有差别.

所以希望下次上课检查不要出问题了
## 2019/05/22
给action写了一个构造函数处理输入为空的状态,

然后报错了.

用了一小时查找错误!

17:24

多文件上传不做了,安排!

20:17

都做完了



## 数据库结构
```sql
set global time_zone = '+8:00';
数据库:web
表名:info
建表语句:
create table info(
id int not null primary key auto_increment,
username varchar(20),
name varchar(20),
password varchar(20),
gender int,
major varchar(10),
birthday date,
note varchar(20)
);
测试语句:
    增:
        insert into info (id,username,name,password,gender,birthday,note,major) values (null,'username1','name1','password1',1,'2019-01-01','note1','major1');
        Query OK, 1 row affected (0.07 sec)
    改:
        update info set name='name1update', password='passwordupdate' where username='username1';
```
```cpp
使用的jar包
    commons-fileupload-1.4.jar
    commons-fileupload.jar
    commons-io-2.6.jar
    commons-io.jar
    commons-lang.jar
    freemarker.jar
    log4j.jar
    ognl.jar
    readme.md
    struts2-core.jar
```
