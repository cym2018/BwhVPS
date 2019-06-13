# string实现,只有目前用的着的功能
初始化

获取长度,获取内容,

截取头部,截取尾部

子串查找

# 2019/06/13 20:54
解决了一个传值错误

重载运算符

消除内存泄漏

对当前项目来说可用,但不能通用

不自己实现一个string,都不知道C++自带的string有多好..
```C++
// MyString.h
#pragma once
#include<iostream>
using namespace std;
class MyString
{
private:
	char* cString;
	int iLength;
	void setData(const char* In);
public:
	MyString();
	MyString(const char* cIn);
	~MyString();
	int GetLength();
	int Find(const char* In);
	bool CutHead(int i);
	bool CutEnd(int i);
	const char* GetString();
	void add(const char* In);
	void remove(char c) {
		char* temp =new char[iLength];
		int j = 0;
		memset(temp, '\0', iLength);
		for (int i = 0; i < iLength; i++) {
			if (cString[i] != c) {
				temp[j++] = cString[i];
			}
		}
		setData(temp);
	}
	friend ostream& operator<<(ostream& os, MyString& ms); 
	friend istream& operator>>(istream& is, MyString& ms);
	MyString& operator=(const MyString &ms) {
		this->setData(ms.cString);
		return *this;
	}
	MyString& operator=(const char* ms) {
		this->setData(ms);
		return *this;
	}
};

// MyString.cpp
#include "MyString.h"
void MyString::setData(const char* In) {
	iLength = strlen(In)+1;
	char* temp = new char[iLength];
	strcpy_s(temp, iLength, In);
	delete cString;
	cString = temp;
}
MyString::MyString() { 
	iLength = sizeof("");
	cString = new char[iLength];
	memcpy_s(cString, sizeof(""), "", sizeof(""));
}
MyString::MyString(const char* cIn) {
	iLength = sizeof(cIn);
	cString = new char[iLength];
	strcpy_s(cString, iLength, cIn);
}
MyString::~MyString()
{
	delete cString;
}
int MyString::GetLength() {
	return iLength - 1;
}
int MyString::Find(const char* cIn) {
	int cInLen = strlen(cIn);
	for (int i = 0; i < (int)iLength - cInLen; i++)
		if (memcmp(&cString[i], cIn, cInLen * sizeof(char)) == 0)
			return i;
	return -1;
}
bool MyString::CutHead(int i) {
	if (i > (int)iLength || i < 0)
		return false;
	setData(&cString[i]);
	return true;
}
bool MyString::CutEnd(int i) {
	if (i > (int)iLength || i < 0)
		return false;
	cString[i] = '\0';
	setData(cString);
	return true;
}
const char* MyString::GetString() { return (const char*)cString; }
void MyString::add(const char* In) {
	int InLen = strlen(In);
	int newLen = iLength + InLen - 1;
	char* temp = new char[newLen+10];
	strcpy_s(temp, iLength, cString);
	strcpy_s(&temp[iLength-1], InLen+1, In);
	temp[newLen] = '\0';
	setData(temp);
	delete[] temp;
}
// 运算符重载
ostream& operator<<(ostream& os, MyString& ms) {
	os << ms.cString;
	return os;
}
istream& operator>>(istream& is, MyString& ms) {
	char buf[21];
	while (!is.eof()||!is.eofbit) {
		memset(buf, '\0', 21);
		is.read(buf, 20);
		ms.add(buf);
	}
	return is;
}
```