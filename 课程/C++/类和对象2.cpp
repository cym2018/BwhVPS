#include<iostream>
using namespace std;

class cube {
public:
	cube(int i = 1, int j = 1, int k = 1) {
		a = i; b = j; c = k;
	}
	void input() {
		cin >> a >> b >> c;
	}
	void display() {
		cout << a << "," << b << "," << c << ",";
	}
	int volume() {
		return a * b*c;
	}
	int area() {
		return 2 * (a*b + a * c + b * c);
	}
private:
	int a, b, c;
};
int main()
{
	cube c1, c2, c3(2), c4(2, 3), c5(2, 3, 4);
	c1.input();
	c1.display();
	cout << c1.volume() << "," << c1.area() << endl;
	c2.display();
	cout << c2.volume() << "," << c2.area() << endl;
	c3.display();
	cout << c3.volume() << "," << c3.area() << endl;
	c4.display();
	cout << c4.volume() << "," << c4.area() << endl;
	c5.display();
	cout << c5.volume() << "," << c5.area() << endl;
	return 0;
}
