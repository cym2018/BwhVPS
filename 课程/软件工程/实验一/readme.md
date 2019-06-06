# 银行管理系统
数据库结构:
```sql
数据库名:bank
表名:userinfo
建表语句:
create table userinfo(
id int not null primary key auto_increment,
card_id varchar(19),
name varchar(10),
id_number varchar(18),
phone_number varchar(11));

表名:account
建表语句:
create table account(
id int not null primary key,
card_id varchar(19),
password varchar(6));

表名:balance
建表语句:
create table balance(
id int not null primary key,
balance float);

表名:history
建表语句:
create table history(
id int not null auto_increment primary key,
from_id int,
to_id int,
amount float);
```
