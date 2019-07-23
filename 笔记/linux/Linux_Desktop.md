# Install Linux Desktop
## 修改分辨率
```
# 1920x1080 59.96 Hz (CVT 2.07M9) hsync: 67.16 kHz; pclk: 173.00 MHz
# Modeline "1920x1080_60.00"  173.00  1920 2048 2248 2576  1080 1083 1088 1120 -hsync +vsync
"mode1"  173.00  1920 2048 2248 2576  1080 1083 1088 1120 -hsync +vsync

https://www.jianshu.com/p/940f2514582e

Hyper-v Centos7 修改分辨率
修改分辨率，重启就好了
grubby --update-kernel=ALL --args="video=hyperv_fb:1280x768"
```

# 安装google-chrome
```
# 已知问题:在校园网环境下安装chrome,会导致无法联网
https://www.cnblogs.com/ianduin/p/8727333.html
cd /etc/yum.repo.d/
touch google-chrome.repo
[google-chrome]
name=google-chrome
baseurl=http://dl.google.com/linux/chrome/rpm/stable/$basearch
enabled=1
gpgcheck=1
gpgkey=https://dl-ssl.google.com/linux/linux_signing_key.pub
yum -y install google-chrome-stable --nogpgcheck
```

# 启用网络
```shell
cd /etc/sysconfig/network-scripts/
# 找到
# ifcfg-*
# 将ONBOOT=no改为ONBOOT=yes
# 重启服务
service network restart
```
