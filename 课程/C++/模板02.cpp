/*
当前编程题：作业 模板---【C++模板】队列（类模版）
2.
【问题描述】
仿照栈类模版的定义，写一个队列的类模版，队列中数据的特点是“先进先出”，可以用一个一维数组来模拟一个队列，注意：栈中元素的进栈和出栈都是在栈顶进行的，而队列有所不同，元素入队列在队尾进行，元素出队列在队头进行，定义一个队列类如下所示，要求按类模版的定义格式完成成员函数的定义
template <class T>
class queue
{
public:
	   queue(int num);
	   ~queue();
	   bool insert(T item);      // 元素入队列函数
	   T remove();                   //元素出队列函数
private:
	   T *data;
	   int maxCount;    //队列的最大容量
	   int  front,rear;      //队头和队尾为数组下标
};
主函数如下
int main()
{
queue<char> q( 3 ) ;
q.insert( 'A' ) ;
q.insert( 'B' ) ;
q.insert( 'C' ) ;
cout << q.remove() ;
cout << q.remove() ;
cout << q.remove() << endl;
return 0;
}
【样例输入】无
【样例输出】ABC
【说明】注意，队头队尾指针的初值应该是多少，什么情况下队列是空的，什么情况下队列是满的，元素入队列和出队列如何修改队头和队尾指针【评分标准】
提交源文件:
注意: 只能用 C++ 语言编写程序。 如果有多个源文件，压缩成 rar 或者 zip 包提交。
*/
#include<iostream>
using namespace std;
template <class T>
class queue
{
private:
	T* data;
	int maxCount;    //队列的最大容量
	int  front, rear;      //队头和队尾为数组下标
public:
	queue(int num) :maxCount(num), front(0), rear(0) {
		data = new T[num];
	}
	~queue() {
		delete data;
	}
	// 元素入队列函数
	bool insert(T item) {
		if ((rear + 1) % maxCount == (front-1)%maxCount)
			return false;
		data[rear] = item;
		rear = (rear + 1) % maxCount;
		return true;
	}
	//元素出队列函数
	T remove() {
		T ret = data[front];
		front = (front+1) % maxCount;
		return ret;
	}
};
int main()
{
	queue<char> q(3);
	q.insert('A');
	q.insert('B');
	q.insert('C');
	cout << q.remove();
	cout << q.remove();
	cout << q.remove() << endl;
	return 0;
}
