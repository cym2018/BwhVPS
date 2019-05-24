/*
1.
【问题描述】
定义类point，其中包括两个数据成员，均为 int 类型，为点的横坐标和纵坐标。
类的成员函数如下：
构造函数：包括两个参数，其两个参数的默认值为0。
重载运算符 +、- 、 ==、 != 
+：两个点相应的坐标相加，比如(1,1)+(2,2)=(3,3)
 -：两个点相应的坐标相减，比如(2,2)-(1,1)=(1,1)
== ：两个点相应坐标如果相等，则结果为true,否则结果为false
!= ：两个点的两个坐标只要有一个不相等，则结果为true,否则结果为false
非成员函数：
重载运算符<<，输出点的横坐标和纵坐标，如(2,3)其中2为横坐标,3为纵坐标
重载运算符>>，输入点的横坐标和纵坐标，中间以空格隔开比如输入2 3 ，给点的横坐标和纵坐标赋值.
注意：输入/输出流运算符重载不能使用友元函数 
其主函数如下：
int main()
{
         point  x, y, z1, z2;
         cin>>x>>y;
          z1=x+y;
         z2=x-y;
        cout<<z1<<z2;
         if(x==y)   cout<<"x==y"<<endl;
         else   cout<<"x!=y"<<endl;
         if(z1!=z2)   cout<<"z1!=z2"<<endl;
         else   cout<<"z1==z2"<<endl; 
         return 0;
}
【输入形式】输入有2行，每行输入一个点的横坐标和纵坐标, 中间用空格隔开
【输出形式】输出有4行，第1行输出 x,y 两点之和，即z1； 第2行输出x,y 两点之差，即z2；
第3行输出 x, y 两点的比较结果, 如果两点相等, 则输出"x==y", 否则输出"x!=y"；
第4行输出 z1, z2 两点的比较结果, 如果两点不相等, 则输出"z1!=z2", 否则输出"z1==z2"；
【样例输入】
3 4
1 2
【样例输出】
(4,6)
(2,2)
x!=y
z1!=z2
【样例说明】
【评分标准】
*/
#include<iostream>
using namespace std;
class point {
private:
public:
	int x, y;
	point() {
		x = y = 0;
	}
	friend ostream& operator<<(ostream& os, point& pt) {
		os << "(" << pt.x << "," << pt.y << ")" << endl;
		return os;
	};
	friend istream& operator>>(istream& is, point& pt) {
		int a, b;
		is >> a >> b;
		pt.x = a;
		pt.y = b;
		return is;
	};
	friend point operator+(point in1, point& in2) {
		in1.x += in2.x;
		in1.y += in2.y;
		return in1;
	}
	friend bool operator==(point& in1, point& in2) {
		return (in1.x == in2.x) && (in1.y == in2.y);
	}
	friend point operator-(point in1, point& in2) {
		in1.x -= in2.x;
		in1.y -= in2.y;
		return in1;
	}
	friend bool operator!=(point& in1, point& in2) {
		return !((in1.x == in2.x) && (in1.y == in2.y));
	}

};
int main()
{
	point  x, y, z1, z2;
	cin >> x >> y;
	z1 = x + y;
	z2 = x - y;
	cout << z1 << z2;
	if (x == y)   cout << "x==y" << endl;
	else   cout << "x!=y" << endl;
	if (z1 != z2)   cout << "z1!=z2" << endl;
	else   cout << "z1==z2" << endl;
	return 0;
}
