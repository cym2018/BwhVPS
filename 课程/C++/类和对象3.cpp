#include<iostream>
#include<string>
using namespace std;
class teacher {
public:
	teacher(string s1, string s2, double d1 = 0, double d2 = 0, double d3 = 0) {
		jobNo = s1; Name = s2; base_pay = d1; allowance = d2; insurance = d3;
	}
	void salary() {
		all = base_pay + allowance;
		actual = all - insurance;
	}
	void display() {
		cout << jobNo << " " << Name << " "
			<< base_pay << " " << allowance << " " << insurance << " "
			<< all << " " << actual << endl;
	}
	void input() {
		cin >> base_pay >> allowance >> insurance;
	}
private:
	string jobNo, Name;
	double base_pay,//基本工资
		allowance,//补贴
		insurance,//保险金
		all,//总工资
		actual;//实际工资
};
int main()
{
	teacher t1("111", "Mary"), t2("222", "Alex", 4256.78, 1234.56, 895.17);
	t1.input();
	t1.salary();
	t2.salary();
	t1.display();
	t2.display();
	return 0;
}
