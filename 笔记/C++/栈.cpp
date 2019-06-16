// 这个可能是我最古老的代码
// 大概写于大二
#pragma once
#include<iostream>
using namespace std;
template<class T>
class stack
{
public:
	stack(int N=10);
	~stack();
	bool push(T In);//进栈
	T pop();//出栈
	int size();//判断大小
	bool empty();//判断是否为空
private:
	T data[10];
	int top;
	int Max;
};

=========================================================
#include "stack.h"


template<class T>
stack<T>::stack(int N)
{
	Max = N;
	top = -1;
}

template<class T>
stack<T>::~stack()
{
}


template<class T>
bool stack<T>::push(T In)//入栈函数
{
	if (top + 1 <= Max) 
	{
		data[++top] = In;
		return true;
	}
	return false;
}

template<class T>
T stack<T>::pop()
{
	if (top > -1)
		return data[top--];
	else
		return false;
}

template<class T>
int stack<T>::size()
{
	return Max;
}

template<class T>
bool stack<T>::empty()
{
	if (top == -1)
		return true;
	else
		return false;
}

