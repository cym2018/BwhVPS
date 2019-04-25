# 设置密码
SET PASSWORD='';
alter user 'dzy'@'%' identified by '123456' #修改密码
# 设置时区
set global time_zone = '+8:00';
# 输出唯一值
select distinct(*) from table;
# 结果排序
select * from essay order by id asc 从小到大
select * from essay order by id desc 从大到小
# JDBC连接
Class.forName("com.mysql.cj.jdbc.Driver");	加载驱动
conn = DriverManager.getConnection("jdbc:mysql://localhost/bus?user=root&password=ab370126"); 	连接
rs = conn.prepareStatement(s1).executeQuery();	s1为查询语句

