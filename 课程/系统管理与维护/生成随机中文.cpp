// 用于系统管理与维护实验:随机文件名分类
// 生成随机文件名的步骤
#include<fstream>
#include<string>
#include<iostream>
using namespace std;
class RandomName {
public:
	int iRange1 = 0xf7 - 0xb0;
	int iRange2 = 0xfe - 0xa1;
	RandomName() {
		srand(5);
	}
	string GetName() {
		string ret;
		for (int i = 0; i < 3; ++i)
		{
			char iCode1 = rand() % iRange1 + 0xb0;
			char iCode2 = rand() % iRange2 + 0xa1;
			char ch[3] = { iCode1,iCode2,0 };
			ret += ch;
		}
		return ret;
	}
};
string GetStudents(string sName, int iNumber) {
	string student;
	student = (char)(iNumber / 100 + '0');
	student += (char)(iNumber / 10%10 + (int)'0');
	student += (char)(iNumber % 10 + (int)'0');
	//while (student.length() < 3)student = "0" + student;
	return sName + "-20161222" + student + "-";
}
string GetType(int iType, int iTimes) {
	string ret;
	ret = (char)(iTimes / 10 + '0');
	ret += (char)(iTimes % 10 + '0');
	string sType[3] = { "实验","作业","测试" };
	ret = sType[iType] + "-" + ret + ".pdf";
	return ret;
}
int main(int iIn, char* cIn) {
	ofstream file;
	file.open("1.txt");
	RandomName getName;//获取随机姓名
	string sStudent,//学生信息
		sType;//类型
	sStudent = GetStudents(getName.GetName(), 0);
	for (int iStudents = 1; iStudents < 202; sStudent = GetStudents(getName.GetName(), iStudents++)) {//获取学生信息
		for (int iType = 0; iType < 3; iType++) {//类型
			for (int iTimes = 1; iTimes < 21; iTimes++) {//次数
				sType = GetType(iType, iTimes);
				file <<"echo  >>"<< sStudent+ sType << endl;
			}
		}
	}

	//	cout << N.GetName() << "-" << sFirstNum + sLastNum << "-实验01.pdf" << endl;
		//return 0;
}
