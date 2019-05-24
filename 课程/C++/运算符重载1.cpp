/*
【问题描述】定义一个分数类 fraction, 该类的数据成员包括: 分子, 分母，均用int型。成员函数包括:
 (1) 两个构造函数：  ①  默认的构造函数(分子为0，分母为1);    ② 带2个参数的构造函数, 用这2个参数分别给分子和分母赋值;
 (2) 实现两个分数的加、减、乘、除运算，分别用运算符重载函数实现
 (3) 实现两个分数的通分、约分，分别用2个成员函数实现 ,  加法，减法应该先通分再加减，所有的计算结果需要进行约分 。
 (4) 输入和输出分数的函数input，output
main函数定义如下：
int main()
{
    fraction x1,x2(2,7),x3,y1,y2,z1,z2,z3,z4,z5;
   x3.input();
   y1.input();
   y2.input();
   z1=x3+y1;      z1.output();
   z2=x3-y1;       z2.output();
   z3=x3*y2;       z3.output();
   z4=x3/y2;       z4.output();
   z5=x1+x2;      z5.output();
  return 0;
}
【输入形式】输入有3行，每行输入一个分数，分子，分母的顺序输入，中间用空格分开
【输出形式】一个分数占一行，分母=1 或 分子=0 时只输出分子即可
【样例输入】
1 5
2 3
3 8
【样例输出】
13/15
-7/15
3/40
8/15
2/7
【样例说明】
【评分标准】
*/
#include <iostream>
using namespace std;
class fraction {
public:
	int up, down;
	//构造函数
	fraction(int up = 0, int down = 1) :up(up), down(down) {}
	//输入输出
	void output() {
		cout << up << "/" << down << endl;
	}
	void input() {
		cin >> up >> down;
	}
	// 化简
	void sim() {
		int a, b, c = 1;
		a = up > down ? up : down;
		b = up < down ? up : down;
		while (c != 0) {
			c = a % b;
			a = b;
			b = c;
		}
		up /= a;
		down /= a;
	}
	// =
	void operator=(fraction in) {
		up = in.up;
		down = in.down;
	}
	//+ - * /
	friend fraction operator+(fraction first,fraction second) {
		fraction ret((first.up)*(second.down)+(second.up)*(first.down),(first.down)*(second.down));
		ret.sim();
		return ret;
	}
	friend fraction operator-(fraction first, fraction second) {
		fraction ret((first.up) * (second.down) - (second.up) * (first.down), (first.down) * (second.down));
		ret.sim();
		return ret;
	}
	friend fraction operator*(fraction first, fraction second) {
		fraction ret((first.up) * (second.up) , (first.down) * (second.down));
		ret.sim();
		return ret;
	}
	friend fraction operator/(fraction first, fraction second) {
		fraction ret((first.up) * (second.down), (first.down) * (second.up));
		ret.sim();
		return ret;
	}
};
int main() {
	fraction x1, x2(2, 7), x3, y1, y2, z1, z2, z3, z4, z5;
	x3.input();
	y1.input();
	y2.input();
	z1 = x3 + y1;      z1.output();
	z2 = x3 - y1;       z2.output();
	z3 = x3 * y2;       z3.output();
	z4 = x3 / y2;       z4.output();
	z5 = x1 + x2;      z5.output();
	return 0;
}
