# string实现,只有目前用的着的功能
初始化

获取长度,获取内容,

截取头部,截取尾部

子串查找

```C++
// MyString.h
#pragma once
#include<iostream>
using namespace std;
class MyString{
private:
	char* cString;
	size_t iLength;
	void setData(const char* In);
public:
	MyString();
	MyString(const char* cIn);
	size_t GetLength();
	size_t Find(const char* In);
	bool CutHead(int i);
	bool CutEnd(int i);
	char* GetString();
};
// MyString.cpp
#include "MyString.h"
void MyString::setData(const char* In) {
	delete cString;
	iLength = strlen(In) + 1;
	cString = new char[iLength];
	strcpy_s(cString, iLength, In);
}
MyString::MyString() { setData(""); }
MyString::MyString(const char* cIn = "") { setData(cIn); }
size_t MyString::GetLength() { return iLength - 1; }
size_t MyString::Find(const char* cIn) {
	int cInLen = strlen(cIn);
	for (int i = 0; i < iLength - cInLen; i++)
		if (memcmp(&cString[i], cIn, cInLen * sizeof(char)) == 0)
			return i;
	return -1;
}
bool MyString::CutHead(int i) {
	if (i > iLength || i < 0)
		return false;
	setData(&cString[i]);
	return true;
}
bool MyString::CutEnd(int i) {
	if (i > iLength || i < 0)
		return false;
	cString[i] = '\0';
	setData(cString);
	return true;
}
char* MyString::GetString() { return cString; }
```