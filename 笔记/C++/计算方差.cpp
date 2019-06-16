#include<iostream>
using namespace std;
int main()
{
	while (1)
	{
		double num[10], sum = 0, mean = 0, var = 0;
		int n;
		cin >> n;
		for (int i = 0; i < n; i++)
		{
			cin >> num[i];
		}
		for (int i = 0; i < n; i++)
		{
			sum += num[i];
		}
		mean = sum / n;
		for (int i = 0; i < n; i++)
		{
			var = var + (num[i] - mean)*(num[i] - mean);
		}
		cout << var / n << endl << var / (n - 1);
	}
}
