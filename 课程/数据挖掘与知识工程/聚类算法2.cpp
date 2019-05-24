#include<iostream>
#include<math.h>
using namespace std;
void output(double * box, int length);
//计算距离矩阵
void Get_All_Distance(double *, double *, int, int);
//获取x,y的距离
double Get_Distance(double *Distance, int i, int j, int Box_L);
//选择最短的距离
int Select_Min_Distance(double *Distance, int Distance_L);
//将第x,y个中心合并
int Merge(double * Box, int x, int y, int Box_L, int *, int max);
int Get_P_Distance(double * Box, double * Box_, int Box_M, int P_i);
int main() {
	double *Box = new double[200];//样本
	double *Box_ = new double[200];//样本副本
	double *Distance = new double[200];//样本间距离
	int Box_L;//样本数量
	int Box_L_;//样本数量
	int Box_M;//样本维度
	int Min_Distance;
	int Min_x, Min_y;
	int *place = new int[200];
	//样本归属
	int *Belong = new int[200];
	cout << __LINE__ << "H " << "样本数量:";
	cin >> Box_L;
	Box_L_ = Box_L;
	for (int i = 0; i < Box_L_; i++) { Belong[i]= place[i]= i; }
	cout << __LINE__ << "H " << "样本维度:";
	cin >> Box_M;
	for (int i = 0; i < Box_L*Box_M; i++) {
		cin >> Box[i];
		Box_[i] = Box[i];
	}
	Get_All_Distance(Box, Distance, Box_L, Box_M);
	Min_Distance = Select_Min_Distance(Distance, Box_L*Box_M);
	//cout << __LINE__ << "H " << Distance[Min_Distance] << endl;
	Min_x = Min_Distance / Box_L;
	Min_y = Min_Distance % Box_L;
	//cout << __LINE__ << "H " << Min_x << " " << Min_y << endl;
	Box_L = Merge(Box, Min_x, Min_y, Box_L, Belong, Box_L_);
	while (Box_L > 2) {
		Get_All_Distance(Box, Distance, Box_L, Box_M);
		Min_Distance = Select_Min_Distance(Distance, Box_L*Box_M);
		//cout << __LINE__ << "H " << Distance[Min_Distance] << endl;
		Min_x = Min_Distance / Box_L;
		Min_y = Min_Distance % Box_L;
		//cout << __LINE__ << "H " << Min_x << " " << Min_y << endl;
		Box_L = Merge(Box, Min_x, Min_y, Box_L, Belong, Box_L_);
	}
	// 输出聚类点
	for (int i = 0; i < 2; i++) {
		cout << "第" << i << "个聚类点为(";
		for (int j = 0; j < Box_M - 1; j++) {
			cout << Box[i*Box_M + j] << ",";
		}
		cout << Box[i*Box_M + Box_M - 1]<<")" << endl;
	}
	for (int i = 0; i < Box_L_; i++) {
		//if ((Box[0] - Box_[i * 2])*(Box[0] - Box_[i * 2]) + (Box[1] - Box_[i * 2 + 1])*(Box[1] - Box_[i * 2 + 1]) > (Box[2] - Box_[i * 2])*(Box[2] - Box_[i * 2]) + (Box[3] - Box_[i * 2 + 1])*(Box[3] - Box_[i * 2 + 1]))
		cout << "第" << i << "个点属于第" << Get_P_Distance(Box, Box_, Box_M, i) << "个聚类点,坐标为(";
			for (int j = 0; j < Box_M-1; j++) {
				cout << Box_[i*Box_M + j] << ",";
			}
			cout << Box_[i*Box_M + Box_M - 1] << ")"<<endl;
		//else
			//cout << "第" << i << "个点属于第1个聚类点,坐标为x:" << Box_[i * 2] << "y:" << Box_[i * 2 + 1]<<endl;
	}
	return 0;
}
void output(double* box, int length) {
	for (int i = 0; i < length * 2; i++) {
		cout << __LINE__ << "H i:" << i << " " << box[i] << endl;
	}
}
void Get_All_Distance(double *Box, double *Distance, int Box_L, int Box_M)
{
	double sum;
	for (int i = 0; i < Box_L; i++) {
		for (int j = 0; j < Box_L; j++) {
			sum = 0;
			for (int k = 0; k < Box_M; k++) {
				sum = sum + (Box[i*Box_M + k] - Box[j*Box_M + k])*(Box[i*Box_M + k] - Box[j*Box_M + k]);
			}
			Distance[Box_L*i + j] = sqrt(sum);
		}
	}
	/*for (int k = 0; k < Box_L; k++) {
		for (int l = 0; l < Box_L; l++) {
			cout << Distance[Box_L*k + l] << " ";
		}
		cout << endl;
	}
	*/
}
double Get_Distance(double *Distance, int i, int j, int Box_L) {
	return Distance[Box_L*i + j];
}
int Select_Min_Distance(double *Distance, int Distance_L) {
	double min = 999;
	int min_i;
	for (int i = 0; i < Distance_L; i++) {
		if (Distance[i] < min&&Distance[i] != 0) {
			min = Distance[i];
			min_i = i;
		}
	}
	return min_i;
}
//将两个点合并
int Merge(double * Box, int x, int y, int Box_L, int *Belong, int Max) {
	//cout << __LINE__ << "H x" << x << "y" << y << endl;
	Box_L -= 1;
	if (x > y) { int temp; temp = x; x = y; y = temp; }
	Box[2 * x] = (Box[2 * x] + Box[2 * y]) / 2;
	Box[2 * x + 1] = (Box[2 * x + 1] + Box[2 * y + 1]) / 2;
	Box[2 * y] = Box[2 * Box_L];
	Box[2 * y + 1] = Box[2 * Box_L + 1];
	for (int i = 0; i < Max; i++) {
		if (Belong[i] == Belong[y])
			Belong[i] = Belong[x];
		//for (int j = 0; j < 4; j++)cout << __LINE__ << "H " << Belong[j] << endl;
	}
	return Box_L;
}
int Get_P_Distance(double *Box, double *Box_, int Box_M,int P_i) {
	double sum1=0,sum2=0;
	for (int i = 0; i < Box_M; i++) {
		sum1 = sum1 + (Box[i] - Box_[P_i*Box_M+i])*(Box[i] - Box_[P_i*Box_M + i]);
		sum2 = sum2 + (Box[i+Box_M] - Box_[P_i*Box_M+i])*(Box[i + Box_M] - Box_[P_i*Box_M + i]);
	}
	if (sum1 > sum2)
		return 1;
	else
		return 0;
}
