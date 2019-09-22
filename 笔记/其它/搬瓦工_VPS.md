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
