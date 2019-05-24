# 安装
yum install python-setuptools && easy_install pip

pip install shadowsocks
# 配置
ss.json

{

"server":"1.1.1.1",(本机IP)

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
