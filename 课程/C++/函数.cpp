#include <iostream>
using namespace std;
int min(int a, int b);
double min(double a, double b);
int main()
{
	int num;
	int iIn, iMax;
	double dIn, dMax;
	cin >> num;
	cin >> iMax;
	num--;
	while (num--) {
		cin >> iIn;
		iMax = min(iIn, iMax);
	}
	cout << iMax << endl;
	cin >> num;
	cin >> dMax;
	num--;
	while (num--) {
		cin >> dIn;
		dMax = min(dIn, dMax);
	}
	cout << dMax << endl;
}
int min(int a, int b) {
	return a < b ? a : b;
}
double min(double a, double b) {
	return a < b ? a : b;
}
