/*
当前编程题：作业 模板---【C++模板】数组类
1.
【问题描述】建立模板数组类:array
成员方法如下：
array(int n)；其中n用来设置数组元素的个数
~array();
int sizeOfArray();返回数组中元素的个数
重载 operator[](int index)，返回下标为index的数组元素。
定义setElement（）函数 ，该函数有2个参数，其中第一个参数为数组元素的下标，第二个参数为数组元素的值。
【输入形式】输入有3行，第1行输入模板数组类型，其中1代表建立整数数组类, 2代表建立double数组类，3代表char数组类;
第2行输入数组中元素的个数;第3行输入数组中各个元素.
【输出形式】输出数组中各元素，元素之间用一个空格分开，注意最后一个元素后没有空格
【样例输入】
1
3
1 2 3
【样例输出】
1 2 3
【样例说明】
【评分标准】
提交源文件:
注意: 只能用 C++ 语言编写程序。 如果有多个源文件，压缩成 rar 或者 zip 包提交
*/
#include<iostream>
using namespace std;
template <class T>
class arr
{
private:
	T* data;
	int maxCount;
public:
	arr(int num) :maxCount(num) {
		data = new T[num];
	}
	~arr() {
		delete data;
	}
	int sizeOfArray() {
		return maxCount;
	}
	T operator[](int index) {
		return data[index];
	}
	void setElement(int i, T item) {
		data[i] = item;
	}
};
int main()
{
	int i = 0, j = 0;
	cin >> i >> j;
	if (i == 1) {
		arr<int> p(j);
		int temp;
		for (int m = 0; m < j; m++) {
			cin >> temp;
			p.setElement(m, temp);
		}
		for (int m = 0; m < j - 1; m++) {
			cout << p[m] << " ";
		}
		cout << p[j - 1];
		return 0;
	}
	if (i == 2) {
		arr<double> p(j);
		double temp;
		for (int m = 0; m < j; m++) {
			cin >> temp;
			p.setElement(m, temp);
		}
		for (int m = 0; m < j - 1; m++) {
			cout << p[m] << " ";
		}
		cout << p[j - 1];
		return 0;
	}
	if (i == 3) {
		arr<char> p(j);
		char temp;
		for (int m = 0; m < j; m++) {
			cin >> temp;
			p.setElement(m, temp);
		}
		for (int m = 0; m < j - 1; m++) {
			cout << p[m] << " ";
		}
		cout << p[j - 1];
		return 0;
	}
	return 0;
}
