/*
Problem B: 【C++模版】求x的y次幂（函数模版）
Time Limit: 1 Sec  Memory Limit: 128 MB
Submit: 782  Solved: 517
[Submit][Status][Web Board]
Description
编写模板函数power(x, y)，返回x的y次幂，函数的第一个参数为底数x，可以为任意数值类型；第二个参数为y为幂，类型为整数；返回值类型与底数类型相同。
注：考虑0次幂的情况，输出为1
Input
输入数据有多2，第1个行输入2个整数，第2行第1个为实数，第2个数必须为整数
Output
输出2行，每行输出一个结果
Sample Input
12 4
3.6 7
Sample Output
20736
7836.42
HINT
*/
#include<iostream>
using namespace std;
template<class T>
T power(T x, int y) {
	T ret = 1;
	for (int i = 0; i < y; i++) {
		ret = ret * x;
	}
	return ret;
}
int main(int arvc, char** arvg) {
	int i, j;
	double k;
	cin >> i >> j;
	cout << power(i, j) << endl;
	cin >> k >> j;
	cout << power(k, j) << endl;
	return 0;
}