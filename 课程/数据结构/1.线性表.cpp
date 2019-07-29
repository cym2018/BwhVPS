//2019年7月30日 02点11分
//数据结构第二章 线性表 链表
//崔雨鸣
#include<iostream>
using namespace std;
template <class T>
struct Node
{
	T Date = NULL;
	Node* Next = NULL;
};
template <class T>
class LinearList {
private:
	Node<T>* FirstNode;
	Node<T>* ThisNode;
	int length;
public:
	LinearList() {
		FirstNode = new Node<T>;
		ThisNode = NULL;
		length = 0;
	}
	LinearList(LinearList& source) {
		FirstNode = new Node<T>;
		ThisNode = NULL;
		length = 0;
		int SourceLength = source.length;
		for (int i = 0; i < SourceLength; i++) {
			this->Add(source.Read(i));
		}
		return;
	}
	~LinearList() {
		ThisNode = FirstNode;
		while (ThisNode != NULL) {
			FirstNode = ThisNode;
			ThisNode = ThisNode->Next;
			delete FirstNode;
		}
	}
	bool Add(T date, int i) {
		// 检查下标是否正确
		if (i > length) { return false; }
		ThisNode = FirstNode;
		while (i--) { ThisNode = ThisNode->Next; }
		Node<T>* AddNode = new Node<T>;
		AddNode->Date = date;
		AddNode->Next = ThisNode->Next;
		ThisNode->Next = AddNode;
		length++;
		return true;
	}
	bool Add(T date) {
		ThisNode = FirstNode;
		while (ThisNode->Next) { ThisNode = ThisNode->Next; }
		Node<T>* AddNode = new Node<T>;
		AddNode->Date = date;
		AddNode->Next = ThisNode->Next;
		ThisNode->Next = AddNode;
		length++;
		return true;
	}
	T Read(int i) {
		ThisNode = FirstNode->Next;
		while (i--) { ThisNode = ThisNode->Next; }
		return ThisNode->Date;
	}
	bool Remove(int i) {
		if (i > length) { return false; }
		ThisNode = FirstNode;
		while (i--) { ThisNode = ThisNode->Next; }
		void* temp = ThisNode->Next;
		ThisNode->Next = ThisNode->Next->Next;
		delete temp;
		length--;
		return true;
	}
	int Length() { return length; }
	int Locate(T date) {
		int i = -1;
		ThisNode = FirstNode;
		for (int i = 0; i < length; i++) {
			ThisNode = ThisNode->Next;
			if (ThisNode->Date == date)
				return i;
		}
		return -1;
	}
	void MakeEmpty() {
		length = 0;
		ThisNode = FirstNode->Next;
		FirstNode->Next = NULL;
		void* temp = NULL;
		while (ThisNode != NULL) {
			temp = ThisNode;
			ThisNode = ThisNode->Next;
			delete temp;
		}
	}
};
int main(int arvc, char** arvg) {
	LinearList<char> test1;
	test1.Add('c');
	test1.Add('y');
	test1.Add('m');
	LinearList<int> test2;
	test2.Add(2);
	test2.Add(0);
	test2.Add(1);
	test2.Add(8);
	for (int i = 0; i < test1.Length(); i++)
		cout << test1.Read(i);
	for (int i = 0; i < test2.Length(); i++)
		cout << test2.Read(i);
	return 0;
}
