// 学习行列式,手算太麻烦,准备写一个通用的行列式计算程序
// 写完发现只适用于三阶行列式
#include<iostream>
using namespace std;
int main()
{
	int M[3][3], sum = 0, temp;
	for (int i = 0; i < 3; i++)
		for (int j = 0; j < 3; j++)
			cin >> M[i][j];
	for (int i = 0; i < 3; i++)
	{//求和
		temp = 1;
		for (int k = 0; k < 3; k++)
		{
			temp = temp * M[(i + k) % 3][k];
		}	
		cout << temp << endl;
		sum = sum + temp;
	}
	for (int i = 0; i < 3; i++)
	{//求差
		temp = 1;
		for (int k = 0; k < 3; k++)
		{
			temp = temp * M[(i + k) % 3][(-k+3)%3];
		}
		cout << temp << endl;
		sum = sum - temp;
	}
	cout << sum;
}
