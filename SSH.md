# 文件传输
scp -P 10000 C:\Users\cuige\IdeaProjects\DWNews2Mail\out\artifacts\DWNews2Mail_jar\DWNews2Mail.jar root@6.cym2018.xyz:/root/ 上传文件到服务器



scp -P 10000 -r root@6.cym2018.xyz:/root/.ssh ./下载服务器的文件到本地



# 解决超时自动断开



在/etc/ssh/sshd_config中加入：
ClientAliveInterval=60

source .bash_profile

断开重连


https://www.cnblogs.com/williamjie/p/9996946.html
