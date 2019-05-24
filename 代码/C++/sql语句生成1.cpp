// 以前玩游戏的时候喜欢收集名字,记录在数据库里.
// 手写sql太麻烦,当时还不会数据库的连接,
// 所以写了一个从剪贴板读取数据,生成sql语句再放入剪切板的程序.
// 对windows剪切板的api使用不完整,在某些情况下,会导致剪切板内容失效.
// 重新注释于2019年4月25日
// 原注释:

//2018年7月17日
//崔雨鸣
//程序功能：输入id name 转换为sql语句 
//参照内容：https://blog.csdn.net/heihei36/article/details/46636275
//改进：将语句直接写入剪切板

#include<iostream>
#include<fstream>
#include<string>
#include<Windows.h>
using namespace std;
int Creat();
int GetIni();
int Add();
int UpdateName();
int UpdateId();
int DeleteName();
int ClipboardWrite(string);
string DATABASE, TABLE;
int main()
{
	int MENU;
	GetIni();
	cout << "数据库:" << DATABASE << endl;
	cout << "表:" << TABLE << endl;
	while (1)
	{
		cout << "1.增加 2.修改name3.修改id 4.name删除 0.修改数据库和表名" << endl;
		cin >> MENU;
		switch (MENU)
		{
		case 1:Add(); break;
		case 2:UpdateName(); break;
		case 3:UpdateId(); break;
		case 4:DeleteName(); break;
			break;
		}
	}
	system("pause>nul");
	return 0;
}
int Creat()
{
	string DATABASE, TABLE;
	fstream data("mxsj2_friends.ini", ios::out | ios::trunc);
	if (!data.is_open())
		cout << "无法创建文件!";
	cout << "数据库名 表名" << endl;
	cin >> DATABASE >> TABLE;
	data << "D0" << DATABASE << "D1" << endl << "T0" << TABLE << "T1" << endl;
	data.close();
	return 0;
}
int GetIni()
{
	char a[100];
	fstream data("mxsj2_friends.ini");
	if (!data.is_open()) {
		cout << "找不到记录" << endl;
		Creat();
	}
	data.getline(a, 100);
	DATABASE = a;
	data.getline(a, 100);
	TABLE = a;
	data.close();
	if (DATABASE[0] == 'D'&&DATABASE[1] == '0'&&DATABASE[DATABASE.size() - 2] == 'D'&&DATABASE[DATABASE.size() - 1] == '1'&&
		TABLE[0] == 'T'&&TABLE[1] == '0'&&TABLE[TABLE.size() - 2] == 'T'&&TABLE[TABLE.size() - 1] == '1')
	{
		DATABASE.erase(0, 2).erase(DATABASE.size() - 4, 2);
		TABLE.erase(0, 2).erase(TABLE.size() - 4, 2);
		return 0;
	}
	cout << "文件格式不正确!" << DATABASE << TABLE << endl;
	Creat();
	return 0;
}
int Add()
{
	string id, name, command;
	while (1) {
		cout << "id,name(id长度=1时退出循环)" << endl;
		cin >> id;
		if (id.size() == 1)
			return 0;
		cin >> name;
		command = "insert into " + TABLE + " value (" + id + ",'" + name + "');";
		cout << command << endl;
		ClipboardWrite(command);
	}
}
int UpdateName()
{
	string id, name, command;
	cout << "id,name" << endl;
	cin >> id;
	if (id.size() == 1)
		return 0;
	cin >> name;
	command = "update " + TABLE + " set name = '" + name + "' where id = '" + id + "';";
	cout << command << endl;
	ClipboardWrite(command);
	return 0;
}
int UpdateId()
{
	string id, name, command;
	cout << "id,name" << endl;
	cin >> id;
	if (id.size() == 1)
		return 0;
	cin >> name;
	command = "update " + TABLE + " set id = '" + id + "' where name = '" + name + "';";
	cout << command << endl;
	ClipboardWrite(command);
	return 0;
}
int DeleteName()
{
	string id, name, command;
	while (1)
	{
		cout << "name(name长度=1时退出循环)" << endl;
		cin >> name;
		if (name.size() == 1)
			return 0;
		command = "delete from " + TABLE + " where name = '" + name + "';";
		cout << command << endl;
		ClipboardWrite(command);
	}
	return 0;
}
int ClipboardWrite(string command)
{
	const char * char_command = command.data();
	HWND hwnd = NULL;
	OpenClipboard(hwnd);
	EmptyClipboard();
	HANDLE hHandle = GlobalAlloc(GMEM_FIXED, 1000);//分配内存
	char* pData = (char*)GlobalLock(hHandle);//锁定内存，返回申请内存的首地址
	strcpy_s(pData, 100, char_command);
	SetClipboardData(CF_TEXT, hHandle);//设置剪切板数据
	GlobalUnlock(hHandle);//解除锁定
	CloseClipboard();//关闭剪切板
	return 0;
}
string ClipboardRead()
{
	HWND hwnd=NULL;
	HANDLE h = GetClipboardData(CF_TEXT);
	char* p = (char*)GlobalLock(h);
	GlobalUnlock(h);
	CloseClipboard();
	return p;
}


