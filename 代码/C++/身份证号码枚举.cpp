#include<iostream>
using std::string;
using std::cin;
using std::cout;
using std::endl;
class IdNumber {
private:
	int* idNum;
	// 加权值
	int power[17] = { 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2 };
	char lastNum[11] = { '1' ,'0', 'X','9', '8', '7', '6', '5', '4', '3', '2' };
	int sex = 0;
	int sum = 0;
public:
	IdNumber() {
		idNum = new int[18];
		string sIn;
		cout << "输入前14位" << endl;
		cin >> sIn;
		cout << "输入性别，0女1男";
		cin >> sex;
		for (int i = 0; i < sIn.length(); i++)
			idNum[i] = sIn[i] - '0';
	}
	void output() {
		for (idNum[14] = 0; idNum[14] < 10; idNum[14]++)
			for (idNum[15] = 0; idNum[15] < 10; idNum[15]++)
				for (idNum[16] = sex; idNum[16] < 10; idNum[16] += 2)
				{
					sum = 0;
					for (int i = 0; i < 17; i++)
						sum = sum + idNum[i] * power[i];
					for (int i = 0; i < 17; i++)
						cout << idNum[i];
					cout << lastNum[sum % 11] << endl;
				}
	}
};
int main() {
	IdNumber id;
	id.output();
}
