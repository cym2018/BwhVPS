# 银行管理系统
由java+struts+mysql制作的简易银行管理系统.

[成品](http://cym2019.xyz:81/bank/)

数据库结构:
```sql
#数据库名:bank

#表名:userinfo
#建表语句:
create table userinfo(id int not null primary key auto_increment,card_id varchar(19),name varchar(10),id_number varchar(18),phone_number varchar(11));
#表名:account
#建表语句:
create table account(id int not null primary key,card_id varchar(19),password varchar(6));
#表名:balance
#建表语句:
create table balance(id int not null primary key,balance float);
#表名:history
#建表语句:
create table history(id int not null auto_increment primary key,from_id int,to_id int,amount float);
```

# 2019年6月7日
idea更新后出现了问题,全新tomcat+全新struts+全新jdk环境,运行报错,甚至之前做的javaee作业也无法运行.

由于这个月的windows insider版本极不稳定,tim崩溃,微信崩溃,edge崩溃,一开始怀疑是windows系统的问题.

退出了windows insider计划,全盘格式化并重新安装系统.

用一下午把之前使用的软件下载回来,运行运行项目仍然失败.

解决的方法是在网上下载一个javassist.jar放到tomcat的lib文件夹下.

究竟为什么出现这个问题也不太确定,初步怀疑是idea更新的原因.

不知是我的个例还是所有人都如此.

# 2019年6月12日
改正代码逻辑变更导致的办卡功能错误

已知问题:
记录交易历史时应该记下时间.