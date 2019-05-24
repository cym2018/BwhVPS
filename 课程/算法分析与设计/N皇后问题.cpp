#include<iostream>
class EightQueen {
private:
	// 地图大小
	int mapLarge;
	// 棋盘,记录,非重复记录,左上-右下标记,右上-左下标记,列标记
	int *chessMap,*recode,*uniqueRecode,*LU,*RU,*C;
	// 添加棋子到棋盘(记录所在的行，列，斜行)
	void AddChess(int line) {
		LU[line + chessMap[line]] ++;
		RU[mapLarge + line - chessMap[line] - 1] ++;
		C[chessMap[line]]++;
	}
	// 从棋盘删除棋子
	void DelChess(int line) {
		LU[line + chessMap[line]]--;
		RU[mapLarge + line - chessMap[line] - 1] --;
		C[chessMap[line]] --;
	}
	// 保存排列方案到数组
	void Save() {
		int sum = 0;
		for (int i = 0; i < mapLarge; i++)
			sum = sum * mapLarge + chessMap[i];
		recode[recode[0]++] = sum;
	}
	// 从数组读取排列方案
	void Read(int iNumber) {
		int sum = recode[iNumber];
		for (int i = mapLarge - 1; i > -1; i--) {
			chessMap[i] = sum % mapLarge;
			sum = sum / mapLarge;
		}
	}
public:
	// 初始化设定棋盘大小
	EightQueen(int imapLarge):mapLarge(imapLarge) {
		chessMap = new int[11];
		recode = new int[1000];
		uniqueRecode = new int[1000];
		LU = new int[22];
		RU = new int[22];
		C = new int[11];
		recode[0] = 1;
		uniqueRecode[0] = 1;
		for (int i = 0; i < mapLarge; i++) {
			chessMap[i] = -1;
			LU[i] = 0;
			RU[i] = 0;
			LU[i + mapLarge] = 0;
			RU[i + mapLarge] = 0;
			C[i] = 0;
		}
	}
	// 执行运算
	void Do(int line = 0) {
		if (line < mapLarge - 1) {
			for (chessMap[line] = 0; chessMap[line] < mapLarge; chessMap[line]++) {
				AddChess(line);
				if (LU[line + chessMap[line]] > 1 || RU[mapLarge + line - chessMap[line] - 1] > 1 || C[chessMap[line]] > 1) {
					DelChess(line);
					continue;
				}
				Do(line + 1);
				DelChess(line);
			}
		}
		else {
			for (chessMap[line] = 0; chessMap[line] < mapLarge; chessMap[line]++) {
				AddChess(line);
				if (LU[line + chessMap[line]] > 1 || RU[mapLarge + line - chessMap[line] - 1] > 1 || C[chessMap[line]] > 1) {
					DelChess(line);
					continue;
				}
				Save();
				DelChess(line);
			}
		}
		chessMap[line] = -1;
 	}
	// 以数字的方式输出所有方案
	void OutputNum() {
		for (int i = 1; i < recode[0]; i++) {
			Read(i);
			for (int j = 0; j < mapLarge; j++)
				std::cout << chessMap[j];
			std::cout << std::endl;
		}
	}
	// 以图象的方式输出所有方案
	void OutputPic() {
		for (int i = 1; i < recode[0]; i++) {
			Read(i);
			for (int j = 0; j < mapLarge; j++)
			{
				for (int a = 0; a < chessMap[j]; a++) {
					std::cout << "□";
				}
				std::cout << "■";
				for (int a = 0; a < mapLarge-chessMap[j]-1; a++) {
					std::cout << "□";
				}
				std::cout << std::endl;
			}
			std::cout << std::endl;
		}
	}
};
int main() {
	EightQueen E(8);
	E.Do();
	E.OutputPic();
}
