# ipv6解除gfw封锁方法
1.给服务器分配ipv6地址

https://tunnelbroker.net/

在上述网址注册一个账号,登录后选择'Create Regular Tunnel',输入vps的ipv4地址.

在Example Configuration栏选择Linux-net-tools

复制文本框的命令

2.服务器ipv6网络配置

粘贴

3.影梭配置
修改ss.json
```
{
"server":"::",
"server_port":1000,
"local_address":"127.0.0.1",
"local_port":1080,
"password":"password",
"timeout":300,
"method":"aes-256-cfb",
"fast_open":false
}
```

4.运行
ssserver -d start -c ss.json



亲测可用

# 2019年10月12日更新
[ipv4访问ipv6平台](http://6plat.org/)

在上述网站申请一个账号(一天左右可以申请通过)

使用其提供的ipv4转ipv6隧道,配合影梭,可在任意网络条件下翻墙



# 记录一次重装过程
2019年10月17日 02点26分
### 起因
半夜睡不着觉,放弃睡觉,尝试在服务器运行一个邮箱服务

系统升级挂了(yum update),出现依赖错误.

重启失败不起来了.

### 网页操作
系统选择centos8x86x64

收到系统安装完毕的邮件后,在控制台选择html5支持的终端.

输入用户名密码,进入系统.

passwd修改root密码

在 https://tunnelbroker.net/ 找到ipv6地址设置脚本

网页终端不能复制粘贴,一行一行打进去.
 
本地ping 6.cym2018.xyz 命令收到回复,证明ipv6设置成功.

Ctrl+D 退出登录,关闭网页,返回本地客户端操作.

### 本地操作

Win+R 输入cmd打开命令行

ssh 6.cym2018.xyz -l $用户名 -p $端口号

命令执行失败,提示'远程计算机的身份改变'

切换到用户文件夹,执行 del .ssh

重新连接成功.

惯例:yum update

看了一下python没有默认安装
 
但听说yum是基于python的.

看了一下yum代码
```python
#!/usr/libexec/platform-pythone enhancement relevant packages, in updates#!/usr/libexec/platform-python
```

因为要安装影梭,影梭不支持python3 所以安装python2

yum install python2

然后安装影梭

pip2 install shadowsocks

新建一个文件夹存储配置文件

mkdir ~/myconfig
cd ~/myconfig

安装vim

yum install vim

配置文件略,配置完执行

ssserver -c ./ss.json -d start

TMD 翻车了

```bash
[root@cym2019 myconfig]# ssserver -c ./ss.json -d start
INFO: loading config from ./ss.json
2019-10-16 14:54:24 INFO     loading libcrypto from libcrypto.so.1.1
Traceback (most recent call last):
  File "/usr/bin/ssserver", line 11, in <module>
    load_entry_point('shadowsocks==2.8.2', 'console_scripts', 'ssserver')()
  File "/usr/lib/python2.7/site-packages/shadowsocks/server.py", line 34, in main
    config = shell.get_config(False)
  File "/usr/lib/python2.7/site-packages/shadowsocks/shell.py", line 262, in get_config
    check_config(config, is_local)
  File "/usr/lib/python2.7/site-packages/shadowsocks/shell.py", line 124, in check_config
    encrypt.try_cipher(config['password'], config['method'])
  File "/usr/lib/python2.7/site-packages/shadowsocks/encrypt.py", line 44, in try_cipher
    Encryptor(key, method)
  File "/usr/lib/python2.7/site-packages/shadowsocks/encrypt.py", line 83, in __init__
    random_string(self._method_info[1]))
  File "/usr/lib/python2.7/site-packages/shadowsocks/encrypt.py", line 109, in get_cipher
    return m[2](method, key, iv, op)
  File "/usr/lib/python2.7/site-packages/shadowsocks/crypto/openssl.py", line 76, in __init__
    load_openssl()
  File "/usr/lib/python2.7/site-packages/shadowsocks/crypto/openssl.py", line 52, in load_openssl
    libcrypto.EVP_CIPHER_CTX_cleanup.argtypes = (c_void_p,)
  File "/usr/lib64/python2.7/ctypes/__init__.py", line 374, in __getattr__
    func = self.__getitem__(name)
  File "/usr/lib64/python2.7/ctypes/__init__.py", line 379, in __getitem__
    func = self._FuncPtr((name_or_ordinal, self))
AttributeError: /lib64/libcrypto.so.1.1: undefined symbol: EVP_CIPHER_CTX_cleanup
```

### 百度
https://www.iteye.com/blog/haohetao-2423078

cd /usr/lib/python2.7/site-packages/shadowsocks/crypto/

vim openssl.py


:set nu

#显示行号

52L,111L的cleanup改为reset.

### 安装网页服务器
不想写动态页面了反正也没人看 静态省内存

yum install httpd

二进制文件位置:/etc/httpd/

网页位置:/var/www/html/

新建一个 index.html

外部访问成功.


  ~
  
结束 03点17分

### 收回刚才的话
反正睡不着觉,继续尝试搞一个邮件服务

yum install mailx

尝试发送邮件

mail 87622XXXX@qq.com
subject:nothing

Ctrl+D
```
/usr/sbin/sendmail: No such file or directory
"/root/dead.letter" 9/223
. . . message not sent.
```

yum install sendmail

第二次尝试发送邮件

mail 87622XXXX@qq.com
subject:nothing

Ctrl+D

```
Null message body; hope that's ok
```

N次后确认发送失败

###百度
https://www.jianshu.com/p/9a769903a12f

vim /etc/mail/sendmail.mc

121行127.0.0.1改为0.0.0.0

困了 不想写步骤了

告辞

03点55分
