// 2019年04月26日 12:09
// 通过同行,同列,同九宫格互斥获取部分解
// 

#include<iostream>
using namespace std;
class sudo {
private:
	int** map;
	int** couldBe;
	int** notHave;
public:
	sudo() {
		{
			// 初始化map
			map = new int* [9];
			for (int i = 0; i < 9; i++)
				map[i] = new int[9];
			for (int i = 0; i < 9; i++)
				for (int j = 0; j < 9; j++)
					map[i][j] = 0;
		}
		{
			// 初始化couldBe
			couldBe = new int* [9];
			for (int i = 0; i < 9; i++)
				couldBe[i] = new int[9];
			for (int i = 0; i < 9; i++)
				for (int j = 0; j < 9; j++)
					couldBe[i][j] = 987654321;
		}
		{
			// 初始化notHave
			notHave = new int* [27];
			for (int i = 0; i < 27; i++)
				notHave[i] = new int[9];
			for (int i = 0; i < 27; i++)
				for (int j = 0; j < 9; j++)
					notHave[i][j] = 0;
		}
	}
	~sudo() {
		{
			// 删除map
			for (int i = 0; i < 9; i++)
				delete(map[i]);
			delete(map);
		}
		{
			// 删除couldBe
			for (int i = 0; i < 9; i++)
				delete(couldBe[i]);
			delete(couldBe);
		}
		{
			// 删除notHave
			for (int i = 0; i < 27; i++)
				delete(notHave[i]);
			delete(notHave);
		}
	}
	// map
	void inputMap() {
		for (int i = 0; i < 9; i++)
			for (int j = 0; j < 9; j++) {
				cin >> map[i][j];
			}
	}
	void outputMap() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				cout << map[i][j] << " ";
				if (j == 2 || j == 5)
					cout << " ";
			}
			cout << endl;
			if (i == 2 || i == 5)
				cout << endl;
		}
	}

	// couldBe
	void judgeCouldBe() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (map[i][j] != 0) {
					// 删除自己
					deleteCouldBe(&couldBe[i][j]);
					for (int k = 0; k < 9; k++) {
						// 删除同列
						deleteCouldBe(&couldBe[k][j], map[i][j]);
						// 删除同行
						deleteCouldBe(&couldBe[i][k], map[i][j]);
					}
					// 删除同九宫格
					int l, m;
					l = i / 3;
					m = j / 3;
					for (int n = 3 * l; n < 3 * l + 3; n++) {
						for (int o = 3 * m; o < 3 * m + 3; o++) {
							deleteCouldBe(&couldBe[n][o], map[i][j]);
						}
					}
				}
			}
		}
	}
	static void deleteCouldBe(int* place, int iIn) {
		int temp = 1;
		for (int i = 1; i < iIn; i++) {
			temp *= 10;
		}
		if ((*place / temp) % 10 == iIn) {
			*place = *place - iIn * temp;
		}
	}
	static void deleteCouldBe(int* place) {
		*place = 0;
	}
	static int getCouldBe(int place) {
		int i = 0;
		while (place > 0) {
			if (place % 10 > 0)
				i++;
			place /= 10;
		}
		return i;
	}
	void useCouldBe() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (getCouldBe(couldBe[i][j]) == 1) {
					while (couldBe[i][j] % 10 == 0) {
						couldBe[i][j] /= 10;
					}
					map[i][j] = couldBe[i][j];
				}
			}
		}
	}
	static void outputCouldbe(int i) {
		while (i != 0) {
			if (i % 10 != 0)
				cout << i % 10;
			i /= 10;
		}
	}
	void outputCouldbe() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (getCouldBe(couldBe[i][j]) > 0) {
					cout << "第" << i + 1 << "行,第" << j + 1 << "个可能为:";
					outputCouldbe(couldBe[i][j]);
					cout << endl;
				}
			}
		}
	}

	// notHave
	void judgeNotHave() {
		// 处理行
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				int temp = couldBe[i][j];
				while (temp > 0) {
					if (temp % 10 != 0) {
						notHave[i][temp % 10 - 1]++;
					}
					temp /= 10;
				}
			}
		}
		// 处理列
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				int temp = couldBe[j][i];
				while (temp > 0)
				{
					if (temp % 10 != 0) {
						notHave[i + 9][temp % 10 - 1]++;
					}
					temp /= 10;
				}
			}
		}
		// 处理九宫格
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				for (int k = 3 * i; k < 3 * i + 3; k++) {
					for (int l = 3 * j; l < 3 * j + 3; l++) {
						int temp = couldBe[k][l];
						while (temp > 0) {
							if (temp % 10 != 0) {
								notHave[i * 3 + j + 18][temp % 10 - 1]++;
							}
							temp /= 10;
						}
					}
				}
			}
		}
	}
	void outputNotHave() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++)
				if (notHave[i][j] > 0)
					cout << "第" << i + 1 << "行差" << notHave[i][j] << "个" << j + 1 << endl;
		}
		for (int i = 9; i < 18; i++) {
			for (int j = 0; j < 9; j++)
				if (notHave[i][j] > 0)
					cout << "第" << i + 1 - 9 << "列差" << notHave[i][j] << "个" << j + 1 << endl;
		}
		for (int i = 18; i < 27; i++) {
			for (int j = 0; j < 9; j++)
				if (notHave[i][j] > 0)
					cout << "第" << i + 1 - 18 << "个九宫格差" << notHave[i][j] << "个" << j + 1 << endl;
		}
	}
	// TODO:查找赋值
	void useNotHave() {
		//第i+1行
		for (int i = 0; i < 9; i++) {
			//数字j+1
			for (int j = 0; j < 9; j++) {
				if (notHave[i][j] == 1) {
					map[i][searchNotHave(i, j)] = j + 1;
				}
			}
		}
		// 第i-9列
		for (int i = 9; i < 18; i++) {
			// 数字j+1
			for (int j = 0; j < 9; j++) {
				if (notHave[i][j] == 1) {
					map[searchNotHave(i, j)][i - 9] = j + 1;
				}
			}
		}
		// TODO:查找赋值
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				for (int k = 0; k < 9; k++) {
					if (notHave[3 * i + j + 18][k] == 1) {
						// 第i行第j列的九宫格只差一个k
						for (int l = i * 3; l < i * 3 + 3; l++) {
							for (int m = j * 3; m < j * 3 + 3; m++) {
								if (searchNotHave(&couldBe[l][m], k+1)&& notHave[3 * i + j + 18][k] == 1) {
									map[l][m] = k+1;
								}
							}
						}
						
					}
				}
			}
		}
	}
	bool searchNotHave(int* place, int iIn) {
		int temp = *place;
		while (temp > 0) {
			if (temp % 10 == iIn)
				return true;
			temp /= 10;
		}
		return false;
	}
	int searchNotHave(int line, int iIn) {
		if (line < 9) {
			for (int i = 0; i < 9; i++) {
				if (searchNotHave(&couldBe[line][i], iIn + 1)) {
					return i;
				}
			}
		}
		else {
			for (int i = 0; i < 9; i++) {
				if (searchNotHave(&couldBe[i][line - 9], iIn + 1)) {
					return i;
				}
			}
		}
	}
	void cleanTemp() {
		{
			// 初始化couldBe
			for (int i = 0; i < 9; i++)
				for (int j = 0; j < 9; j++)
					couldBe[i][j] = 987654321;
		}
		{
			// 初始化notHave
			for (int i = 0; i < 27; i++)
				for (int j = 0; j < 9; j++)
					notHave[i][j] = 0;
		}
	}
};

int main() {
	sudo* s;
	s = new sudo();
	s->inputMap();
	for (int i = 0; i < 10; i++) {
		s->judgeCouldBe();
		s->useCouldBe();
		s->judgeNotHave();
		s->useNotHave();
		s->cleanTemp();
	}
	//s->outputCouldbe();
	//s->outputNotHave();
	s->outputMap();
	
	delete(s);
	cout << endl;
}
