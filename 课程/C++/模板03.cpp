/*
Problem A: 【C++模版】求数组中最大元素（函数模版）
Time Limit: 1 Sec  Memory Limit: 128 MB
Submit: 581  Solved: 479
[Submit][Status][Web Board]
Description
Write a function template  largest_element()  that returns the largest value in an array.  The array may contain elements of any one data type. The function has two parameters.  The first parameters is the name of the array and the second parameter is the integer number of elements in the array. The return type of the function is the same type as its first parameter.
编写一个函数模板largest_element()用来计算数组的最大值。数组元素可以是任意数据类型。该函数有两个参数，第一个数数组名，第二个是数组元素的个数，返回值类型为数组元素类型。

Input
输入有3 行，每行数据的第1个数n, 表示数组元素的个数，后面跟n个数组元素
Output
输出有3行，每行输出对应数组的最大元素值
Sample Input
5 3 7 1 9 6
4 5.7 8.9 2.4 3.1
6 fHyAxk
Sample Output
9
8.9
y
HINT

要求main函数中使用指针变量，根据输入的数组元素个数进行动态内存分配。注意输入字符数据时，字符间没有空格。
*/
#include<iostream>
using namespace std;
template<class T>
T max(T* arr, int max) {
	T ret=arr[0];
	for (int i = 1; i < max; i++) {
		if (arr[i] > ret)
			ret = arr[i];
	}
	return ret;
}
int main(int arvc, char** arvg) {
	int iInputC;
	int* iInput;
	double* dInput;
	char* cInput;
	cin >> iInputC;
	iInput = new int[iInputC];
	for (int i = 0; i < iInputC; i++)
		cin >> iInput[i];
	cout << max(iInput, iInputC)<<endl;
	cin >> iInputC;
	dInput = new double[iInputC];
	for (int i = 0; i < iInputC; i++)
		cin >> dInput[i];
	cout << max(dInput, iInputC) << endl;
	cin >> iInputC;
	cInput = new char[iInputC];
	cin >> cInput;
	cout << max(cInput, iInputC) << endl;
}