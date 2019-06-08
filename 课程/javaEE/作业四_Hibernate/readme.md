# Hibernate框架的使用
 - [x] 登录功能实现
 - [x] 选课功能实现
 - [x] 选课结果查看功能实现
 - [x] 退课功能实现
 - [ ] 其他功能完善 (注册,退出登录)
## 数据库结构
```sql
#表名:info
#建表语句:
#表名:login
#建表语句:
create table login(id int primary key auto_increment not null,username varchar(20) not null,password varchar(20) not null);
#||==========||===============||
#||    id    ||      int      ||
#||==========||===============||
#|| username ||  varchar(20)  ||
#||==========||===============||
#|| password ||  varchar(20)  ||
#||==========||===============||

#表名:courselist
#建表语句:
create table courselist(id int not null primary key auto_increment,coursename varchar(20),semester varchar(20),studyhour int,credits int);
#||============||===============||===============||
#||     id     ||     int       || 课程号        ||
#||============||===============||===============||
#|| coursename ||  varchar(20)  || 课程名        ||
#||============||===============||===============||
#||  semester  ||  varchar(20)  || 开课学期      ||
#||============||===============||===============||
#||  studyhour ||     int       || 学习时间      ||
#||============||===============||===============||
#||   credits  ||     int       || 学分          ||
#||============||===============||===============||
#测试用例:
insert into courselist (id,coursename,semester,studyhour,credits) values
(null,'语文','大一上',18,1),
(null,'数学','大一下',19,2),
(null,'英语','大二上',20,3),
(null,'物理','大二下',21,4),
(null,'化学','大三上',22,5),
(null,'生物','大三下',23,6),
(null,'历史','大四上',24,7),
(null,'地理','大四下',25,8),
(null,'政治','大五上',26,9);

#表名:selectcourse
#建表语句
create table selectcourse(id int primary key auto_increment not null,studentid int,courseid int);
#||==========||===============||
#||    id    ||      int      ||
#||==========||===============||
#|| studentid||      int      ||
#||==========||===============||
#|| courseid ||      int      ||
#||==========||===============||
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
    struts2-core.jar
    antlr-runtime-3.5.2.jar
    antlr4-4.7.1.jar
    antlr4-runtime-4.7.1.jar
    byte-buddy-1.9.5.jar
    c3p0-0.9.5.2.jar
    classmate-1.3.4.jar
    dom4j-2.1.1.jar
    FastInfoset-1.2.15.jar
    hibernate-c3p0-6.0.0.Alpha2.jar
    hibernate-commons-annotations-5.1.0.Final.jar
    hibernate-core-6.0.0.Alpha2.jar
    hibernate-jpamodelgen-6.0.0.Alpha2.jar
    icu4j-58.2.jar
    istack-commons-runtime-3.0.7.jar
    jandex-2.0.5.Final.jar
    javassist-3.24.0-GA.jar
    javax.activation-api-1.2.0.jar
    javax.json-1.0.4.jar
    javax.persistence-api-2.2.jar
    jaxb-api-2.3.1.jar
    jaxb-runtime-2.3.1.jar
    jboss-logging-3.3.2.Final.jar
    jboss-transaction-api_1.2_spec-1.1.1.Final.jar
    mchange-commons-java-0.2.11.jar
    org.abego.treelayout.core-1.0.3.jar
    ST4-4.0.8.jar
    stax-ex-1.8.jar
    txw2-2.3.1.jar
```