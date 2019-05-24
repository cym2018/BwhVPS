// 整理济南市公交站牌名称时用来删除重复项的程序
// 仅适用于特定格式的文本
#include<iostream>
#include<fstream>
#include<string>
using namespace std;
int main()
{
	char *p = new char[100];
	ifstream fin;
	ofstream fout;
	fin.open("in.txt");
	fout.open("out.txt");
	int line = 1;
	string station[3000];//站牌查重
	int station_number = 0;
	int number = 0;
	while (line++, fin.getline(p, 100))
	{
		if (p[0] == '#')//判断＃  2个#跳过1行
		{
			number++;
			if (number == 2)
			{
				fin.getline(p, 100);
				line++;
				number = 0;
			}
			continue;
		}
		number = 0;
		int flag = 0;//重复标识
		for (int i = -1; i < station_number; i++)//检查是否重复
		{
			station[2999] = p;
			//cout <<"sta" <<station[i].c_str()<<"p" << station[9999] << endl;
			if (station[i].c_str() == station[2999])
			{
				//cout << "相等" << endl;
				flag = 1;
				break;
			}
		}
		if (flag == 0) //未重复
		{
			station[station_number] = station[2999];
			station_number++;
			//cout << station[station_number - 1] << endl;
		}
	}
	for (int i = 0; i < station_number; i++) 
	{
		fout << i + 1 << "\t" << station[i] << endl;
	}
}
