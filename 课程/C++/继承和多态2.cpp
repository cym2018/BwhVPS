/*
当前编程题：作业 继承和多态---【C++虚函数】动物的叫声
2.
【问题描述】
动物（Animal类）有子类Cat, Dog, Mouse. 需要描述动物的名字，每一类都有其自己的叫声。
实现其类层次关系。
主函数如下：int main()
{
   Animal *p;
Mouse m1("Jerry");
   p=&m1;
   p->cry(); 
  
   Cat c1("Tom");
   p=&c1;
   p->cry(); //输出: I am Tom， a 猫猫，我的叫声是：喵喵喵！
   Dog d1("Droopy");
   p=&d1;
   p->cry(); //输出: I am Droopy，是一条狗狗，我的叫声是：汪汪汪！
   
   return 0;
}

【输入形式】
【输出形式】按主函数输出
【样例输入】
【样例输出】
I am a mouse, my name is Jerry, zhizhi.
I am a cat, my name is Tom, miaomiao.
I am a dog, my name is Droopy, wangwang.
【样例说明】
【评分标准】
提交源文件: 
注意: 只能用 C 语言编写程序。 如果有多个源文件，压缩成 rar 或者 zip 包提交。
*/
#include<iostream>
using namespace std;
// 动物类
class Animal {
public:
	string sName;
	Animal(string sName=""):sName(sName){}
	virtual void cry() {}
};
class Cat :public Animal {
public:
	Cat(string name = "") :Animal(name) {}
	void cry() {
		cout << "I am a cat, myname is " << sName << ", miaomiao." << endl;
	}
};
class Dog :public Animal {
public:
	Dog(string name = "") :Animal(name) {}
	void cry() {
		cout << "I am a dog, myname is " << sName << ", wangwang." << endl;
	}
};
class Mouse :public Animal {
public:
	Mouse(string name=""):Animal(name) {}
	void cry() {
		cout << "I am a mouse, myname is " << sName << ",zhizhi." << endl;
	}
};
int main() {
	Animal* p;
	Mouse m1("Jerry");
	p = &m1;
	p->cry();

	Cat c1("Tom");
	p = &c1;
	p->cry(); //输出: I am Tom， a 猫猫，我的叫声是：喵喵喵！
	Dog d1("Droopy");
	p = &d1;
	p->cry(); //输出: I am Droopy，是一条狗狗，我的叫声是：汪汪汪！
	return 0;
}
