// 不记得从哪个网站上抄来
// 本来不能运行,各种瞎改,神奇的可以运行了
// 看不懂,没有用,实验品
#pragma warning(disable:4996)
#include <stdio.h>
#include <Winsock2.h>
#pragma comment(lib,"Ws2_32.lib")

//目标地址
#define IP "114.114.114.114"
//线程个数
#define THREADCOUNT 60
DWORD WINAPI ThreadProc(LPVOID lpParameter);
//端口号
int PortNum = 0;
//临界区变量
CRITICAL_SECTION cs;
//线程函数
DWORD WINAPI ThreadProc(LPVOID lpParameter)
{
	//创建套接字
	SOCKET TryConnect;
	while (1)
	{
		if (PortNum > 65535)
		{
			break;
		}
		//进入临界区
		EnterCriticalSection(&cs);
		//领取任务
		int tmpport = PortNum;
		PortNum++;
		//离开临界区
		LeaveCriticalSection(&cs);

		TryConnect = socket(AF_INET, SOCK_STREAM, 0);
		if (INVALID_SOCKET == TryConnect)
		{
			printf("socket");
		}
		//尝试连接
		sockaddr_in addrMe = { 0 };
		addrMe.sin_family = AF_INET;
		DWORD threadID = GetCurrentThreadId();
		//printf("线程%d正在检测端口%d\n",threadID,PortNum);
		addrMe.sin_port = htons(tmpport);
		addrMe.sin_addr.S_un.S_addr = inet_addr(IP);
		int retCon = connect(TryConnect, (sockaddr*)&addrMe, sizeof(sockaddr_in));
		if (SOCKET_ERROR != retCon)
		{
			printf("----------------检测到目标主机开放%d端口\n", tmpport);
		}
	}
	return 0;
}
int main(int argc, char* argv[])
{
	//初始化套接字
	WSADATA ws;
	::WSAStartup(MAKEWORD(2, 0), &ws);

	//初始化临界区
	InitializeCriticalSection(&cs);

	//多线程扫描
	HANDLE hThread[THREADCOUNT];
	for (int i = 0; i < THREADCOUNT; i++)
	{
		hThread[i] = CreateThread(NULL, 0, (LPTHREAD_START_ROUTINE)ThreadProc, (LPVOID)0, 0, NULL);
	}
	WaitForMultipleObjects(THREADCOUNT, hThread, true, INFINITE);

	//删除临界区
	DeleteCriticalSection(&cs);

	system("pause");
	return 0;
}
