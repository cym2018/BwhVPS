/*
2.
【问题描述】
复数形如k = a + bi, a是实部，b是虚部。定义类如下：
class complex
{
public:
...
private:
    double real ;          
    double imaginary ;
}
成员函数要求包括：
(a) 重载运算符”+”和”-”,实现两个复数的加减运算，重载 ”==”, ”!=” ，”<” ，” >” 实现两个复数的比较运算，注意复数的">"和"<"的比较，当虚部不等于0时，规定按复数的模的大小进行比较，当虚部为0时，则直接比较实部
(b) 设置实部函数 setReal(double realVal), 设置虚部函数setImag(double imagVal)
(c) 返回实部函数getReal() ，返回虚部函数getImag()
(d) 重载流运算符”>>”， ”<<” 实现复数的输入输出（注意不能用友元函数）
主函数的测试代码如下:
int main()
{
complex c1, c2, c3, c4, c5 ;
cin >> c1 >> c2 ;
c3 = c1 + c2 ;
c4 = c1 - c2 ;
if ( c3 != c4 )
{
if (c3 < c4)
{    cout << "c3 is less than c4" ;
     c5 = c4 - c3 ;
}
if ( c3 > c4 )
{    cout << "c3 is greater than c4" ;
     c5 = c3 - c4 ;
}
}
if ( c3 == c4 )
{   cout << "c3 and c4 are equal";
    c5 = c4 ;
}
cout<<endl;
cout << c5 ;
return 0;
}
【输入形式】以a+bi的形式输入两个复数，一行输入一个复数
【输出形式】第1行输出c3和c4比较大小的结果，第2行输出c5, 实部，虚部均保留两位小数
【样例输入】
3+4i
5-6i
【样例输出】
c3 is less than c4
-10.00+12.00i
【提示说明】
输入按 a+bi 的格式，可以参考以下方法（最好自己想想还有什么其他的方法进行输入）
double real, imag;
 char c1,c2;
 is>>real>>c1>>imag>>c2;
注意：当读取的c1是 “-” 时，需要将imag变成负数
*/
#include<iostream>
#include<iomanip>
using namespace std;
class complex {
private:
	double real;
	double imaginary;
public:
	friend istream& operator>>(istream& in1, complex& in2) {
		char c1, c2;
		in1 >> in2.real >> c1 >> in2.imaginary >> c2;
		if (c1 == '-') {
			in2.imaginary = 0 - in2.imaginary;
		}
		return in1;
	}
	friend ostream& operator<<(ostream& in1, complex& in2) {
		if (in2.imaginary > 0)
			in1 << in2.real << "+" << in2.imaginary << "i" << endl;
		else
			in1 << in2.real << in2.imaginary << "i" << endl;
		return in1;
	}
	friend complex operator+(complex in1, complex& in2) {
		in1.real += in2.real;
		in1.imaginary += in2.imaginary;
		return in1;
	}
	friend complex operator-(complex in1, complex& in2) {
		in1.real -= in2.real;
		in1.imaginary -= in2.imaginary;
		return in1;
	}
	friend bool operator==(complex& in1, complex& in2) {
		return (in1.imaginary == in2.imaginary && in1.real == in2.real);
	}
	friend bool operator!=(complex& in1, complex& in2) {
		return !(in1 == in2);
	}
	friend bool operator<(complex& in1, complex& in2) {
		return in1.real * in1.real + in1.imaginary * in1.imaginary < in2.real * in2.real + in2.imaginary * in2.imaginary;
	}
	friend bool operator>(complex& in1, complex& in2) {
		return in1.real * in1.real + in1.imaginary * in1.imaginary > in2.real * in2.real + in2.imaginary * in2.imaginary;
	}
};
int main()
{
	cout << setiosflags(ios::fixed) << setprecision(2);
	complex c1, c2, c3, c4, c5;
	cin >> c1 >> c2;
	c3 = c1 + c2;
	c4 = c1 - c2;
	if (c3 != c4)
	{
		if (c3 < c4)
		{
			cout << "c3 is less than c4";
			c5 = c4 - c3;
		}
		if (c3 > c4)
		{
			cout << "c3 is greater than c4";
			c5 = c3 - c4;
		}
	}
	if (c3 == c4)
	{
		cout << "c3 and c4 are equal";
		c5 = c4;
	}
	cout << endl;
	cout << c5;
	return 0;
}
