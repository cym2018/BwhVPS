/*
当前编程题：实验7 继承与多态（重修学生）---【C++动态多态】eat
2.
【问题描述】
三个类student,teacher,boss具有共同的基类person，person包含数据成员name，带参构造函数和纯虚函数eat
编写上述四个类，将程序补充完成。
主函数如下:
int main()
{
int choice;
person *p = NULL;
string nameValue;
//cout<<"please input a number(1=student, 2=teacher, 3=boss) .";
cin>>choice;
// cout<<"please enter the name.";
cin>>nameValue;
if(choice==1)
 p=new student(nameValue);
else
 if(choice==2)
  p=new teacher(nameValue);
 else
  if(choice==3)
   p=new boss(nameValue);
p->eat(); 
if(p!=NULL) delete p;
return 0;
}

【输入形式】
角色的选择:1=student, 2=teacher, 3=boss
录入已选角色的姓名

【输出形式】已选角色人物吃的内容
如果选择1，输出为 I want to have lunch at mess hall!
如果选择2，输出为 I want to eat potato in CHUANWEI restaurant!
如果选择3，输出为 I want to eat fish in GAODIJIE restaurant!

【样例输入】
2
zhangsan
【样例输出】
I am a teacher, my name is zhangsan, I want to eat potato in CHUANWEI restaurant!
【样例说明】
【评分标准】
*/
#include<iostream>
using namespace std;
class person {
protected:
	string name;
public:
	person(string sName):name(sName) {}
	virtual ~person() {}
	virtual void eat() = 0;
};
class student :public person {
public:
	student(string sName) :person(sName) {}
	void eat() {
		cout << "I am a student, my name is "<<name<<", ";
		cout << "I want to have lunch at mess hall!";
	}
};
class teacher :public person {
public:
	teacher(string sName) :person(sName) {}
	void eat() {
		cout << "I am a teacher, my name is "<<name<<", ";
		cout << "I want to eat potato in CHUANWEI restaurant!";
	}
};
class boss :public person {
public:
	boss(string sName) :person(sName) {}
	void eat() {
		cout << "I am a boss, my name is "<<name<<", ";
		cout << "I want to eat fish in GAODIJIE restaurant!";
	}
};
int main()
{
	int choice;
	person* p = NULL;
	string nameValue;
	//cout<<"please input a number(1=student, 2=teacher, 3=boss) .";
	cin >> choice;
	// cout<<"please enter the name.";
	cin >> nameValue;
	if (choice == 1)
		p = new student(nameValue);
	else if (choice == 2)
		p = new teacher(nameValue);
	else if (choice == 3)
		p = new boss(nameValue);
	p->eat();
	if (p != NULL) delete p;
	return 0;
}
