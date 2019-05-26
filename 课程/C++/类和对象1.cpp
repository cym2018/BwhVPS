#include<iostream>
#include<string>
using namespace std;
class student {
public:
	student(string s1, string s2, int i1 = 0, int i2 = 0, int i3 = 0) {
		stuNum = s1; stuName = s2;
		a = i1; b = i2; c = i3;
	}
	void sumfun() {
		all = a + b + c;
	}
	void display() {
		cout << stuNum << " " << stuName << " " << a << " " << b << " " << c << " " << all << endl;
	}
	void inputscore() {
		cin >> a >> b >> c;
	}
private:
	string stuNum, stuName;
	int a, b, c, all;
};
int main(){
	student st1("111", "John"), st2("222", "Mike", 67, 89, 92);
	st1.inputscore(); st1.sumfun(); st2.sumfun();
	st1.display();
	st2.display();
	return 0;
}
