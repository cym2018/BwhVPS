# 安装
yum install python-setuptools && easy_install pip

pip install shadowsocks
# 配置
ss.json

{

"server":"0.0.0.0",

"server_port":1000,(对外)

"local_address":"127.0.0.1",

"local_port":1080,(本地端口)

"password":"password",(密码)

"timeout":300,(超时时间)

"method":"aes-256-cfb",(加密方式)

"fast_open":false

}
# 启动
ssserver -d start -c ./ss.json

# python3
以前在openssl，有

EVP_CIPHER_CTX_cleanup函数.

1.1.0版本中

替换成为
EVP_CIPHER_CTX_reset

解决办法：

找到报错的文件
vim /usr/local/lib/python2.7/dist-packages/shadowsocks/crypto/openssl.py

全文搜索cleanup


将所有
EVP_CIPHER_CTX_cleanup
替换成为
EVP_CIPHER_CTX_reset

:%s/cleanup/reset/

:x

https://www.cnblogs.com/hanzg/p/11629128.html
