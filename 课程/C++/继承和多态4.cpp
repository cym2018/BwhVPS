/*
当前编程题：实验7 继承与多态（重修学生）---【C++继承】图形类
1.
【问题描述】
定义一个图形类(figure),其中有保护类型的成员数据：高度(height)和宽度(width)，一个公有的构造函数。由该图形类建立两个派生类：矩形类(rectangle)和等腰三角形类(triangle)。在每个派生类中都包含一个函数area（），分别用来计算矩形和等腰三角形的面积. 还有display()函数,显示对象的信息.
主函数如下:
int main()
{
double width,height;
cin>>width>>height;
triangle tri(width,height);
rectangle rect(width,height);
tri.display();
cout<<"The area is "<<tri.area()<<endl;
rect.display();
cout<<"The area is "<<rect.area()<<endl;
return 0; 
}
【输入形式】宽度和高度
【输出形式】
按主函数输出
【样例输入】3 4
【样例输出】
I am a triangle. The value of width is 3, the height is 4.The area is 6
I am a rectangle. The value of width is 3, the height is 4.The area is 12
【样例说明】
【评分标准】
*/
#include<iostream>
using namespace std;
class figure {
protected:
	double height;
	double width;
public:
	figure(double dHeight, double dWidth) :height(dWidth), width(dHeight) {}
};
class rectangle :public figure {
public:
	rectangle(double dHeight, double dWidth) :figure(dHeight, dWidth) {}
	void display() {
		cout << "I am a rectangle. The value of width is " << width << ", the height is " << height << ".";
	}
	double area() {
		return height * width;
	}
};
class triangle :public figure {
public:
	triangle(double dHeight, double dWidth) : figure(dHeight, dWidth) {}
	void display() {
		cout << "I am a triangle. The value of width is "<<width<<", the height is "<<height<<".";
	}
	double area() {
		return height * width/2;
	}
};
int main() {
	double width, height;
	cin >> width >> height;
	triangle tri(width, height);
	rectangle rect(width, height);
	tri.display();
	cout << "The area is " << tri.area() << endl;
	rect.display();
	cout << "The area is " << rect.area() << endl;
	return 0;
}
