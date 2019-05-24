/*
当前编程题：作业 继承和多态---C++[交通工具]
1.
【问题描述】
定义交通工具类(vehicle)，成员包括编号,颜色. 成员函数包括构造函数,包括两个参数分别对成员进行赋值,display()用于显示成员的值.
定义交通工具类的子类自行车类(bike),成员包括编号,颜色,重量(weight整型),重写display()函数显示其所有成员值.
主函数如下:
int main() 
{ 
 int ID;
 string name;
 int weight;
 cin>>ID>>name;
 class vehicle vehicle1(ID,name);
 vehicle1.display();
 cout<<endl;
 cin>>ID>>name>>weight;
 class bike bike1(ID,name,weight);
 bike1.display();
 cout<<endl;
    return 0; 
}
【输入形式】
输入交通工具对象的编号，名称
输入自行车的编号，名称，重量
【输出形式】
输出交通工具的信息
输出自行车的信息
【样例输入】
1 vehicle1
2 bike1 30
【样例输出】
vehicleID=1 vehicleName=vehicle1
vehicleID=2 vehicleName=bike1 weight=30
【样例说明】
【评分标准】
提交源文件: 
注意: 只能用 C++ 语言编写程序。 如果有多个源文件，压缩成 rar 或者 zip 包提交。 
*/
#include<iostream>
using namespace std;
// 交通工具类
class vehicle {
public:
	int iId;
	string sColor;
	vehicle(int id = 0, string color = "") {
		iId = id;
		sColor = color;
	}
	virtual void display() {
		cout <<"vehicleID="<< iId<<" vehicleName=" << sColor;
	};
};
// 自行车类
class bike :public vehicle {
private:
	int iWeight;
public:
	bike(int id = 0, string color = "", int weight=0) {
		iId = id;
		sColor = color;
		iWeight = weight;
	}
	void display() {
		cout << "vehicleID="<<iId << " vehicleName="<<sColor <<" weight="<< iWeight;
	}
};
int main() {
	int ID;
	string name;
	int weight;
	cin >> ID >> name;
	class vehicle vehicle1(ID, name);
	vehicle1.display();
	cout << endl;
	cin >> ID >> name >> weight;
	class bike bike1(ID, name, weight);
	bike1.display();
	cout << endl;
	return 0;
}
