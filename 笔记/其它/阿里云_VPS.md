搬瓦工的vps被封,解封无望

本想老老实实做个好公民,不翻墙了

今天想去打印东西,又觉得用qq传文件很麻瓜.没有服务器,打印不方便.

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

# 卸载和屏蔽阿里云自带的监控程序 CTRL+C FROM laod.cn/security/quartz_uninstall.html
wget http://update.aegis.aliyun.com/download/quartz_uninstall.sh
chmod +x quartz_uninstall.sh
./quartz_uninstall.sh
iptables -I INPUT -s 140.205.201.0/28 -j DROP
iptables -I INPUT -s 140.205.201.16/29 -j DROP
iptables -I INPUT -s 140.205.201.32/28 -j DROP
iptables -I INPUT -s 140.205.225.192/29 -j DROP
iptables -I INPUT -s 140.205.225.200/30 -j DROP
iptables -I INPUT -s 140.205.225.184/29 -j DROP
iptables -I INPUT -s 140.205.225.183/32 -j DROP
iptables -I INPUT -s 140.205.225.206/32 -j DROP
iptables -I INPUT -s 140.205.225.205/32 -j DROP
iptables -I INPUT -s 140.205.225.195/32 -j DROP
iptables -I INPUT -s 140.205.225.204/32 -j DROP

# 影梭
yum install python-setuptools && easy_install pip
pip install shadowsocks
#配置 ss.json
#{
#"server":"0.0.0.0",
#"server_port":1000,(对外)
#"local_address":"127.0.0.1",
#"local_port":1080,(本地端口)
#"password":"password",(密码)
#"timeout":300,(超时时间)
#"method":"aes-256-cfb",(加密方式)
#"fast_open":false
#}
#启动
ssserver -d start -c ss.json
# 虽然不能翻墙,但可以解除十教看视频的限制
# 下载5.50mbps 上传 5.47mbps  凑合

# 数据库安装 mariadb(=mysql) CTRL+C FROM https://blog.csdn.net/qq_39719589/article/details/81835330
yum install mariadb
yum install mariadb-server
# 启动mariadb
service mariadb start
# 第一次登陆,修改密码
mysql -u root -p
# 初始密码为空 登陆时直接回车
# 设置密码
set password=password('$password');
# 设置开机启动
systemctl enable mariadb
# 时区
set global time_zone='+8:00';


```
