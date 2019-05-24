// 只适用三阶矩阵
#include<iostream>
#include<Windows.h>
#include<string>
using namespace std;
int main()
{
	int M1[5][5],M2[5][5],N[5][5],n1, n2, n3, n4;
	for (int i = 0; i < 5; i++)
		for (int j = 0; j < 5; j++)
			M1[i][j] = M2[i][j] = N[i][j]=0;
	cin >> n1>>n2>>n3>>n4;
	if (n2 != n3)	return -1;
	
	for (int i = 0; i < n1; i++)
		for (int j = 0; j < n2; j++)
			cin >> M1[i][j];

	for (int i = 0; i < n3; i++)
		for (int j = 0; j < n4; j++)
			cin >> M2[i][j];

	for (int i = 0; i < n1; i++)//第i行
		for (int j = 0; j < n4; j++)//第j列
			for (int k = 0; k < n2; k++)//第k个和
				N[i][j] += M1[i][k] * M2[k][j];
	for (int i = 0; i < n1; i++)//第i行
	{
		for (int j = 0; j < n4; j++)//第j列
			cout << N[i][j] << " ";
		cout << endl;
	}
	return 0;
}
