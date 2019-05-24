#include<iostream>
using namespace std;
class BagProblem {
private:
	// 最大质量,物品种类
	int maxM;
	int maxK;
	// 物品重量，价值
	int* m;
	int* v;
	// 表格
	int* data;
	int** map;
public:
	BagProblem() {
		cout << "最大容量,物品数:" << endl;
		cin >> maxM >> maxK;
		maxM++;
		m = new int[maxK];
		v = new int[maxK];
		map = new int* [maxK];
		data = new int[maxM * maxK];
		for (int i = 0; i < maxM * maxK; i++)
			data[i] = 0;
		for (int i = 0; i < maxK; i++) {
			cin >> m[i] >> v[i], map[i] = &data[maxM * i];
		}
		for (int i = 0; i < maxK; i++)
			for (int j = 0; j < maxM; j++) {
				int up = i < 1 ? 0 : map[i - 1][j]
					, left = j < 1 ? 0 : map[i][j - 1]
					, last = j < m[i] ? 0 : map[i][j - m[i]];
				map[i][j] = up > left ? up : left;
				if (j >= m[i]) {
					map[i][j] = map[i][j] > last + v[i] ? map[i][j] : last + v[i];
				}
			}
		for (int i = 0; i < maxK; i++) {
			for (int j = 0; j < maxM; j++) {
				cout << map[i][j] << " ";
			}
			cout << endl;
		}
	}
	~BagProblem()
	{
		delete m, v, map, data;
	}
};
int main() {
	BagProblem bag;
}
