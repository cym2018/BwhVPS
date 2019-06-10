搬瓦工的vps被封,解封无望

本想老老实实做个好公民,不翻墙了

今天想去打印东西,又觉得用qq传文件很麻瓜.没有服务器,打印都很麻烦.

所以10块钱买了一个月阿里云的学生套餐试用

记录完整配置过程.

操作系统选择最熟悉的CentOS

```shell
#网页登陆
#切换到root用户
sudo su root
#重设密码
passwd
#修改主机名
hostnamectl set-hostname $name
#更新
yum update
#重启 并切换到远程登陆
reboot

#jdk
yum install java
# tomcat
wget http://mirrors.tuna.tsinghua.edu.cn/apache/tomcat/tomcat-9/v9.0.20/bin/apache-tomcat-9.0.20.tar.gz
tar -zxvf apache-tomcat-9.0.20.tar.gz
cd apache-tomcat-9.0.20/conf
vim server.xml
    :set nu #打开行号显示
    69行8080改为81
    75行8080改为81
    # 国内服务器不备案网站不能使用80端口
    :wq
../bin/startup.sh
```

