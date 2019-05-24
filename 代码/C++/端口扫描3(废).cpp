// 来自微软文档,无法运行
#ifndef WIN32_LEAN_AND_MEAN
#define WIN32_LEAN_AND_MEAN
#endif
#include <windows.h>
#include <winsock2.h>
#include <ws2tcpip.h>
#include <iphlpapi.h>
#include <stdio.h>
#pragma comment(lib, "Ws2_32.lib")
int sca(char*, const char*);

int main() {
	int StartPoint = 0, EndPoint = 0;
	char *ip = new char[20];
	int start = 0, end = 0;
	scanf_s("%s %d %d", ip, 15, &start, &end);
	for (start; start < end; start++) {
		char *port = new char[2];
		int port_;
		port_ = start;
		int j = 0;
		for (j = 0; port_ > 0; j++)
			port_ = port_ / 10;
		for (int k = 0; k < j; k++) {
			int M = 1;
			for (int l = 1; l < j - k; l++)M = M * 10;
			port[k] = start / M % 10 + 48;
		}
		printf("\nIP:%s 端口号:%s \n", ip, port);
		const char *po =new char[20] ;
		po = port;
		sca(ip, po);
	}
	return 0;
}
int sca(char *ip,const char* port) {
	/*	1.WSAStartup 初始化
	 *	2.创建三个结构体 存储结果,指针,参数
	 *	3.ZeroMemory 给参数填0/设置参数
	 *	4.getaddrinfo 尝试连接
	 *	5.prt指向result
	 *	6.验证
	*/
	WSADATA wsaData;
	int iResult;
	iResult = WSAStartup(MAKEWORD(2, 2), &wsaData);//初始化
	if (iResult != 0) { printf("WSAStartup failed: %d\n", iResult); return 1; }//查错
	struct addrinfo *result = NULL, *ptr = NULL, hints;//创建三个结构体
	ZeroMemory(&hints, sizeof(hints));
	hints.ai_family = AF_UNSPEC;
	hints.ai_socktype = SOCK_STREAM;
	hints.ai_protocol = IPPROTO_TCP;
	"1234";
	printf("\nIP:%s 端口号:%s \n", ip, port);
	iResult = getaddrinfo(ip, port, &hints, &result);// 解析服务器地址和端口
	if (iResult != 0) { printf("getaddrinfo failed: %d\n", iResult); WSACleanup(); return 1; }//查错
	SOCKET ConnectSocket = INVALID_SOCKET;
	//调用getaddrinfo 尝试连接到所返回的第一个地址
	ptr = result;
	// 创建一个连接到服务器的socks
	ConnectSocket = socket(ptr->ai_family, ptr->ai_socktype, ptr->ai_protocol);
	if (ConnectSocket == INVALID_SOCKET) { printf("Error at socket(): %ld\n", WSAGetLastError()); freeaddrinfo(result); WSACleanup(); return 1; }//查错
	// Connect to server.
	iResult = connect(ConnectSocket, ptr->ai_addr, (int)ptr->ai_addrlen);
	if (iResult == SOCKET_ERROR) {
		closesocket(ConnectSocket);
		ConnectSocket = INVALID_SOCKET;
	}
	freeaddrinfo(result);
	if (ConnectSocket == INVALID_SOCKET) { printf("连接%s端口失败", port); WSACleanup(); return 1; }//查错
	printf("%s端口开放", port);
	return 0;
}
