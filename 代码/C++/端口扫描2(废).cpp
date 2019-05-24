// 来自微软文档,无法正常运行
#ifndef WIN32_LEAN_AND_MEAN
#define WIN32_LEAN_AND_MEAN
#endif
#pragma warning(disable:4996) 
#include <windows.h>
#include<process.h>
#include <winsock2.h>
#include <ws2tcpip.h>
#include <iphlpapi.h>
#include <malloc.h>
#include <stdio.h>
#pragma comment(lib, "Ws2_32.lib")
int scant(char *Ip, int StartPort, int EndPort);
typedef struct _tagValue
{
	int start;
	int end;
}PortNums;
void _cdecl beginThreadFunc1(LPVOID lpParam);

int a();

int main() {
	a();
	//scant("95.169.2.214", 75, 100);
	return 0;
}
int scant(char *Ip, int StartPort, int EndPort)
{
	WSADATA wsa;
	SOCKET s;
	struct sockaddr_in server;
	int CurrPort;    //当前端口
	int ret;		//返回值
	WSAStartup(MAKEWORD(2, 2), &wsa);    //使用winsock函数之前，必须用WSAStartup函数来装入并初始化动态连接库
	server.sin_family = AF_INET;    //指定地址格式，在winsock中只能使用AF_INET
	server.sin_addr.s_addr = inet_addr(Ip); //指定被扫描的IP地址
	for (CurrPort = StartPort; CurrPort <= EndPort; CurrPort++){
		s = socket(PF_INET, SOCK_STREAM, IPPROTO_TCP);
		server.sin_port = htons(CurrPort); //指定被扫描IP地址的端口号
		ret = connect(s, (struct sockaddr *)&server, sizeof(server)); //连接
		if (0 == ret) { //判断连接是否成功
			printf("%s:%d Success\n", Ip, CurrPort);
			closesocket(s);
		}
		else {printf("%s:%d Failed\n", Ip, CurrPort);}
	}
	WSACleanup();    //释放动态连接库并释放被创建的套接字
	return 1;
}


void _cdecl beginThreadFunc1(LPVOID lpParam) {
	PortNums *pnInt = (PortNums*)lpParam;
	scant("95.169.2.214", pnInt->start, pnInt->end);
}

int a()
{
	PortNums m1;
	m1.start = 10;
	m1.end = 20;
	PortNums m2;
	m2.start = 20;
	m2.end = 30;
	_beginthread(beginThreadFunc1, 0, &m1);
	_beginthread(beginThreadFunc1, 0, &m2);
	getchar();
	return 0;
}
