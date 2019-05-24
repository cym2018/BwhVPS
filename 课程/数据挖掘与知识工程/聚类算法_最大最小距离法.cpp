// 数据挖掘与知识工程课程设计(实验)
#include<iostream>
#include<math.h>
using namespace std;
void Add_Center(double*, double, double, int);
int Select_Max(double*, int);
void Get_All_Distance(double *, double *, double *, int, int);
double Get_A_Distance(double x1, double y1, double x2, double y2);
int main() {
	double T;							//阈值
	double *Box = new double[40];		//样本点
	double *Center = new double[40];	//聚类中心
	double *Distance = new double[100];	//聚类中心与样本点距离
	double D_c1c2;						//聚类中心1,2的距离
	int Belong[40];
	int Center_Length = 0;
	int Box_Length = 0;
	int MaxDistance_i = 0;
	cout << __LINE__ << "H 设置比例:" << endl;
	cin >> T;
	cout << __LINE__ << "H 样本点个数:" << endl;
	cin >> Box_Length;
	for (int i = 0; i < Box_Length; i++) {
		Distance[i] = 999;
	}
	for (int i = 0; i < Box_Length * 2; i++) {
		cin >> Box[i];
	}
	Add_Center(Center, Box[0], Box[1], Center_Length++);
	Get_All_Distance(Box, Distance, Center, Center_Length, Box_Length);
	MaxDistance_i = Select_Max(Distance, Box_Length);
	Add_Center(Center, Box[(int)MaxDistance_i%Box_Length * 2], Box[(int)MaxDistance_i%Box_Length * 2 + 1], Center_Length++);
	D_c1c2 = sqrt((Center[0] - Center[2])*(Center[0] - Center[2]) + (Center[1] - Center[3])*(Center[1] - Center[3]));
	while (true) {
		Get_All_Distance(Box, Distance, Center, Center_Length, Box_Length);
		MaxDistance_i = Select_Max(Distance, Box_Length);
		if (Distance[MaxDistance_i] > T*D_c1c2) //假如大于门限值
		{
			Add_Center(Center, Box[(int)MaxDistance_i%Box_Length * 2], Box[(int)MaxDistance_i%Box_Length * 2 + 1], Center_Length++);
		}
		else
			break;
	}
	for (int i = 0; i < Center_Length; i++) {
		cout << __LINE__ << "H 第" << i << "个聚类中心点坐标为: x: " << Center[i * 2] << " y: " << Center[i * 2 + 1] << endl;
	}
	for (int i = 0; i < Box_Length; i++) {
		double Max_D = 999;
		for (int j = 0; j < Center_Length; j++) {
			if (Max_D > Get_A_Distance(Box[2 * i], Box[2 * i + 1], Center[j * 2], Center[j * 2 + 1])) {
				Max_D = Get_A_Distance(Box[2 * i], Box[2 * i + 1], Center[j * 2], Center[j * 2 + 1]);
				Belong[i] = j;
			}
		}
	}
	for (int i = 0; i <= Box_Length; i++) {
		for (int j = 0; j <= Center_Length; j++) {
			if (Belong[i] == j) {
				cout << "第" << i << "个点坐标为:x:" << Box[i * 2] << "y:" << Box[i * 2 + 1] << "属于第" << j << "个聚类中心" << endl;
			}
		}
	}
	return 0;
}
void Add_Center(double* Center, double x, double y, int Center_Length) {
	Center[Center_Length * 2] = x;
	Center[Center_Length * 2 + 1] = y;
}
int Select_Max(double* Distance, int Length) {
	double Max = 0;
	int Max_i = 0;
	for (int i = 0; i < Length; i++) {
		if (Distance[i] > Max) {
			Max = Distance[i];
			Max_i = i;
		}
	}
	return Max_i;
}
void Get_All_Distance(double *Box, double *Distance, double *Center, int Center_Length, int Box_Length) {
	for (int d = 0; d < Center_Length; d++) {
		for (int i = 0; i < Box_Length; i++) {
			if (Distance[i] > Get_A_Distance(Box[i * 2], Box[i * 2 + 1], Center[d * 2], Center[d * 2 + 1])) {
				Distance[i] = Get_A_Distance(Box[i * 2], Box[i * 2 + 1], Center[d * 2], Center[d * 2 + 1]);;
			};
		}
	}
}
double Get_A_Distance(double x1, double y1, double x2, double y2) {
	return sqrt((x2 - x1)*(x2 - x1) + (y2 - y1) * (y2 - y1));
}
