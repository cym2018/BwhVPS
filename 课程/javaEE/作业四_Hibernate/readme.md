# Hibernate框架的使用
-- [x]登录功能实现
-- [x]选课功能实现
-- [x]选课结果查看功能实现
-- [x]退课功能实现
-- []其他功能完善 
## 数据库结构
```sql
表名:info
建表语句:
表名:login
建表语句:
create table login(id int primary key auto_increment not null,username varchar(20) not null,
password varchar(20) not null);
||==========||===============||
||    id    ||      int      ||
||==========||===============||
|| username ||  varchar(20)  ||
||==========||===============||
|| password ||  varchar(20)  ||
||==========||===============||

表名:courselist
建表语句:
create table courselist(id int not null primary key auto_increment,coursename varchar(20),
semester varchar(20),studyhour int,credits int)
||============||===============||===============||
||     id     ||     int       || 课程号        ||
||============||===============||===============||
|| coursename ||  varchar(20)  || 课程名        ||
||============||===============||===============||
||  semester  ||  varchar(20)  || 开课学期      ||
||============||===============||===============||
||  studyhour ||     int       || 学习时间      ||
||============||===============||===============||
||   credits  ||     int       || 学分          ||
||============||===============||===============||
测试用例:
insert into courselist (id,coursename,semester,studyhour,credits)values
(null,'语文','大一上',18,1),
(null,'数学','大一下',19,2),
(null,'英语','大二上',20,3),
(null,'物理','大二下',21,4),
(null,'化学','大三上',22,5),
(null,'生物','大三下',23,6),
(null,'历史','大四上',24,7),
(null,'地理','大四下',25,8),
(null,'政治','大五上',26,9);

表名:selectcourse
建表语句
create table selectcourse(id int primary key auto_increment not null,studentid int,courseid int)
||==========||===============||
||    id    ||      int      ||
||==========||===============||
|| studentid||      int      ||
||==========||===============||
|| courseid ||      int      ||
||==========||===============||

```
目录结构:
>javaee4
>>src
>>>xyz.cym2018
>>>>DAO
>>>>>CourseList.hbm.xml
>>>>>
>>>>>CourseListDAO.java
>>>>>
>>>>>CourseList.java
>>>>>
>>>>>GetSession.java
>>>>>
>>>>>Login.java
>>>>>
>>>>>Login.hbm.xml
>>>>>
>>>>>LoginDAO.java
>>>>>
>>>>>SelectCourse.java
>>>>>
>>>>>SelectCourse.hbm.xml
>>>>>
>>>>>SelectCourseDAO
>>>>struts
>>>>>Action1_Login.java
>>>>>
>>>>>Action2_Reg.java
>>>>>
>>>>>Action3_Logout.java
>>>>>
>>>>>Action4_ShowSelectCourse.java
>>>>>
>>>>>Action5_SelectCourse.java
>>>>>
>>>>>CourseInfo.java
>>>hibernate.cfg.xml
>>>
>>>struts.xml
>>web
>>>WEB-INF
>>>>web.xml
>>>index.jsp
>>>
>>>login.jsp
>>>
>>>reg.jsp
>>>
>>>reg_succ.jsp
>>>
>>>select_course.jsp
>>>
>>>show_select_course.jsp
