/*
Description
定义一个集合类，集合的大小是不确定的，需要使用指针数据成员, 重载运算符“+”，“*”，“-”实现集合的并、交、差运算，对赋值运算符进行重载，定义拷贝构造函数，重载流运算符实现集合的输入、输出。注意，假设A={1，3，5}，B={1，5，9}，两个集合的差运算A-B，是指从集合A中减去集合B的元素，上面集合A-B的结果是｛3｝
类的定义如下：
class settype  
{
public:
 settype();      //构造函数，默认空集，n=0, set=NULL;
 settype( const settype& B);  //拷贝构造函数
 ~settype();                                   //析构函数
    
 void getdata(int *a, int& num) const;     //读值函数
 void setdata(int *a, int num);       //设值函数
 int get_n() const; // 获取集合当前元素数目

 settype operator+(settype B);    //重载运算符+，实现集合并运算
 settype operator*(settype B);    //重载运算符*，实现集合交运算
 settype operator-(settype B);    //重载运算符-，实现集合差运算
 settype operator=(settype B);    //重载运算符= 
 
private:
    int *set;               //数组指针
    int n;                    //元素的个数
 }; 
Input
输入有4行， 第1行输入集合A 的元素个数，第2行输入A 的元素值（数据之间用空格分开），第3行输入集合 B的元素个数，第4行输入B 的元素值，注意集合A，B的元素个数不能超过10
Output
输出有5行，分别输出集合A，集合B，A+B的结果， A*B的结果， A-B的结果，具体输出格式见Sample Output
Sample Input
5
1 3 5 7 9
3
1 4 6
Sample Output
A={1,3,5,7,9}
B={1,4,6}
A+B={1,3,5,7,9,4,6}
A*B={1}
A-B={3,5,7,9}
HINT
main函数如下：
int main(int argc, char* argv[])
{
 settype A, B, C;    
   cin>>A>>B;
   cout<<"A="<<A;
   cout<<"B="<<B;
   C=A+B;
   cout<<"A+B="<<C;
    C=A*B;
   cout<<"A*B="<<C;
   C=A-B;
   cout<<"A-B="<<C;
   return 0;
}
其他测试数据：
Input:
3
1 3 5
3
1 3 5
Output:
A={1,3,5}
B={1,3,5}
A+B={1,3,5}
A*B={1,3,5}
A-B={}
Input:
3
1 3 5
2
2 4
Output:
A={1,3,5}
B={2,4}
A+B={1,3,5,2,4}
A*B={}
A-B={1,3,5}
*/
#include<iostream>
#include<cstring>
using namespace std;
class settype
{
private:
	//元素的个数
	int n;
	//数组指针
	int* set;
public:
	//构造函数，默认空集，n=0, set=NULL;
	settype() {
		n = 0;
		set = NULL;
	};
	//拷贝构造函数
	settype(const settype& B) {
		n = B.get_n();
		set = new int[n];
		B.getdata(set);
	};
	//析构函数
	~settype() {
		delete(set);
	};
	//读值函数
	void getdata(int* a) const {
		memcpy(a, set, sizeof(int) * n);
	};
	//设值函数
	void setdata(int* a, int num) {
		n = num;
		delete(set);
		set = new int[n];
		memcpy(set, a, sizeof(int) * n);
	};
	// 获取集合当前元素数目
	int get_n() const {
		return n;
	};
	int getNumber(int i) {
		return set[i];
	}
	void subNumber(int number) {
		int* temp = new int[n - 1];
		for (int i = 0; i < n; i++) {
			if (set[i] == number) {
				memcpy(temp, set, sizeof(int) * i);
				memcpy(&temp[i], &set[i + 1], sizeof(int) * (n - i - 1));
				delete(set);
				set = temp;
				n--;
				return;
			}
		}
	}
	void addNumber(int number) {
		int* temp = new int[n + 1];
		memcpy(temp, set, sizeof(int) * n);
		temp[n] = number;
		delete(set);
		set = temp;
		n++;
	}
	bool isHaveNumber(int number) {
		for (int i = 0; i < n; i++) {
			if (set[i] == number)
				return true;
		}
		return false;
	}
	//+,*,-,=,<<,>>
	friend settype operator+(settype A, settype& B) {
		for (int i = 0; i < B.get_n(); i++) {
			if (!A.isHaveNumber(B.getNumber(i))) {
				A.addNumber(B.getNumber(i));
			}
		}
		return A;
	};
	friend settype operator*(settype A, settype B) {
		settype C;
		for (int i = 0; i < B.get_n(); i++) {
			if (A.isHaveNumber(B.getNumber(i))) {
				C.addNumber(B.getNumber(i));
			}
		}
		return C;
	};
	friend settype operator-(settype A, settype B) {
		for (int i = 0; i < B.get_n(); i++) {
			A.subNumber(B.getNumber(i));
		}
		return A;
	};
	void operator=(settype B) {
		n = B.get_n();
		if (set != NULL) {
			delete(set);
		}
		set = new int[n];
		B.getdata(set);
	};
	friend ostream& operator<<(ostream& A, settype& B) {
		if (B.get_n() == 0) {
			cout << "{}" << endl;
			return A;
		}
		A << "{";
		for (int i = 0; i < B.get_n() - 1; i++) {
			A << B.getNumber(i) << ",";
		}
		A << B.getNumber(B.get_n() - 1) << "}" << endl;
		return A;
	}
	friend istream& operator>>(istream& A, settype& B) {
		int num;
		A >> num;
		int* temp = new int[num];
		for (int i = 0; i < num; i++) {
			A >> temp[i];
		}
		B.setdata(temp, num);
		return A;
	}
};
int main(int argc, char** argv) {
	settype A, B, C;
	cin >> A >> B;
	cout << "A=" << A;
	cout << "B=" << B;
	C = A + B;
	cout << "A+B=" << C;
	C = A * B;
	cout << "A*B=" << C;
	C = A - B;
	cout << "A-B=" << C;
	return 0;
}
