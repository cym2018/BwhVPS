/*
当前编程题：作业 继承和多态---c++[多态]---工人
3.
【问题描述】有一个工厂有三类人：固定工资工人、计件工人、计时工人；他们有共同的特征：都有名字、住址、工资。但是三类员工的工资计算方法不同：固定工资工人（AWorker），每个月领的工资是不变的；计件工人(BWorker)根据生产的产品数量计算工资；计时工人(CWorker)根据工作的时间长短计算工资。在main函数中创建不同的员工，并依次输出每个员工的名字、住址、工资等信息。具体要求见main函数中的注释
int main()
{
 Worker* w = NULL; //基类指针
 //基类指针指向固定工人
 //zhang为姓名,A address是地址,2000是固定工资
    w = new AWorker("zhang", "A address", 2000); 
 w->printInfo();
 delete w;
    //基类指针指向计件工人
 //wang为姓名,B address是地址,100是数量,也就是件数,15是单件的薪酬,工资为100*15=1500
 w = new BWorker("wang", "B address", 100, 15); 
 w->printInfo();
 delete w;
    //基类指针指向计时工人
 //li为姓名,C address是地址,80是一月工作的小时数,30是一小时的薪酬,工资为80*30=2400
 w = new CWorker("li", "C address", 80, 30); 
 w->printInfo();
 delete w;
 return 0;
}
【输入形式】
【输出形式】每个员工的名字、住址、工资等信息【样例输入】
【样例输出】
name: zhang, address: A address, salary: 2000
name: wang, address: B address, salary: 1500
name: li, address: C address, salary: 2400
【样例说明】
【评分标准】
*/
#include<iostream>
using namespace std;
class Worker {
public:
	string sName, sAddress;
	Worker(string name,string address):sName(name),sAddress(address){}
	virtual ~Worker() {}
	virtual void printInfo() =0;
};
class AWorker :public Worker {
public:
	int iSalary;
	AWorker(string name = "", string address = "", int salary = 0) :Worker(name, address), iSalary(salary) {}
	void printInfo() {
		cout << "name: " << sName << ", address: " << sAddress << ", salary: " << iSalary << endl;
	}
};
class BWorker :public Worker {
public:
	int iCount, iOneSalary;
	BWorker(string name = "", string address = "", int count = 0, int oneSalary = 0) :Worker(name, address), iCount(count), iOneSalary(oneSalary) {}
	void printInfo() {
		cout << "name: " << sName << ", address: " << sAddress << ", salary: " << iCount * iOneSalary << endl;
	}
};
class CWorker :public Worker {
public:
	int iHour, iOneSalary;
	CWorker(string name="",string address="",int hour=0,int oneSalary=0):Worker(name,address),iHour(hour),iOneSalary(oneSalary) {}
	void printInfo() {
		cout << "name: " << sName << ", address: " << sAddress << ", salary: " << iHour*iOneSalary << endl;
	}
};
int main() {
	Worker* w = NULL; //基类指针
//基类指针指向固定工人
//zhang为姓名,A address是地址,2000是固定工资
	w = new AWorker("zhang", "A address", 2000);
	w->printInfo();
	delete w;
	//基类指针指向计件工人
 //wang为姓名,B address是地址,100是数量,也就是件数,15是单件的薪酬,工资为100*15=1500
	w = new BWorker("wang", "B address", 100, 15);
	w->printInfo();
	delete w;
	//基类指针指向计时工人
 //li为姓名,C address是地址,80是一月工作的小时数,30是一小时的薪酬,工资为80*30=2400
	w = new CWorker("li", "C address", 80, 30);
	w->printInfo();
	delete w;
	return 0;
}
