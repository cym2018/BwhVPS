#include<iostream>
using namespace std;
class matrix {
private:
	int** m;
	int* data;
	int maxRow;//行
	int maxCol;//列
	int isum;
public:
	matrix(int row = 0, int col = 0) :maxRow(row), maxCol(col) {
		isum = 0;
		data = new int[400];
		m = new int* [20];
		for (int i = 0; i < maxRow; i++) {
			m[i] = &data[maxCol * i];
			for (int j = 0; j < maxCol; j++) {
				m[i][j] = i * maxCol + j + 1;
				isum = isum + i * maxCol + j + 1;
			}
		}
	}
	void output() {
		cout << maxRow << " " << maxCol << " " << endl;
		for (int i = 0; i < maxRow; i++) {
			for (int j = 0; j < maxCol; j++) {
				cout << m[i][j] << " ";
			}
			cout << endl;
		}
	}
	int at(int num) {
		return m[num / maxCol - 1][num % maxCol - 1 + maxCol];
	}
	int at(int x, int y) {
		return m[x - 1][y - 1];
	}
	int sum() {
		return isum;
	}
};
int main() {
	int row, col, num, x, y;
	cin >> row >> col;
	matrix mat(row, col);
	cin >> num;
	cout << mat.at(num) << endl;
	cin >> x >> y;
	cout << mat.at(x, y) << endl;
	cout << mat.sum() << endl;
}
