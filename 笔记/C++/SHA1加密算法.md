# SHA1加密算法
函数功能;将char转为bool*.

其实没有必要.
```cpp
#include<iostream>
#define strlen (int)strlen
using namespace std;
class SHA1 {
private:
	int bLen;
	bool* bData;
	int A = 0x67452301,
		B = 0xEFCDAB89,
		C = 0x98BADCFE,
		D = 0x10325476,
		E = 0xC3D2E1F0;
public:
	SHA1(const char* in) {
		int cInLen = strlen(in);
		bLen = cInLen * 8;
		bData = new bool[bLen];
		for (int i = 0; i < cInLen; i++)
			CharToBool(in[i], &bData[i * 8]);
	}
	~SHA1() {
		delete bData;
	}
	SHA1& CharToBool(char in, bool* ret) {
		for (int i = 8; i > 0; i--) {
			ret[i - 1] = in & 1;
			in = in >> 1;
		}
		return *this;
	}
	SHA1& Add(const char* in) {
		SHA1 sha1In(in);
		int bNewLen = bLen + sha1In.GetLength();
		bool* temp = new bool[bNewLen];
		memcpy_s(temp, bLen, bData, bLen);
		memcpy_s(&temp[bLen], sha1In.GetLength(), sha1In.GetData(), sha1In.GetLength());
		bLen = bNewLen;
		delete bData;
		bData = temp;
		return *this;
	}
	SHA1& Add(const char in) {
		int bNewLen = bLen + 8;
		bool* temp = new bool[bNewLen];
		memcpy_s(temp, bLen, bData, bLen);
		delete bData;
		CharToBool(in, &temp[bLen]);
		bLen = bNewLen;
		bData = temp;
		return *this;
	}
	SHA1& Output() {
		for (int i = 0; i < bLen; i++) {
			cout << bData[i];
			if (i % 8 == 7 && i > 0)
				cout << " ";
			if (i % 32 == 31 && i > 0)
				cout << endl;
		}
		return *this;
	}
	int GetLength() {
		return bLen;
	}
	bool* GetData() {
		return bData;
	}
	SHA1& Finish() {
		// 原长度
		int startLenA = bLen;
		// 全长
		int should = (bLen % 512 < 448) ? (bLen / 512 + 1) * 512 : (bLen / 512 + 2) * 512;
		// 后64位
		bool* Len = new bool[64];
		// 新构造的二进制串
		bool* temp = new bool[should];
		memset(Len, false, 64);
		memset(temp, false, should);

		// 计算后64位
		for (int i = 0; startLenA != 0; i++, startLenA /= 2)
			Len[63 - i] = startLenA % 2;
		// 复制原字符串
		memcpy_s(temp, bLen, bData, bLen);
		// 结束位
		temp[bLen] = true;
		// 后64位
		memcpy_s(&temp[should - 64], 64, Len, 64);

		// 释放内存,返回结果
		delete[] bData;
		delete[] Len;
		bLen = should;
		bData = temp;
		return *this;
	}
};

int main(int arvc, char** arvg) {
	// 读取输入的字符
	//string input;
	//for (int i = 1; i < arvc; i++) {
	//	input += arvg[i];
	//}
	//cout << input << endl;

	SHA1* a = new SHA1("");
	a->Add((char)97).Add((char)98).Add((char)99);

	a->Finish();
	a->Output();

	// & 位与 ^ 位异或 | 位或

	// 内存泄漏测试
	//SHA1* a;
	//while(true){
	//	a = new SHA1("a");
	//	a->Add("8").Add("c");
	//	a->Add((char)255);	
	//	delete a;
	//}
}
```
```C++
// 1.没有排除内存泄漏
// 2.带中文计算错误,疑似编码问题
#include<iostream>
#define strlen (int)strlen
using namespace std;
class SHA1 {
private:
	uint32_t* Data, DataLength;
	uint32_t  H0, H1, H2, H3, H4,
		A, B, C, D, E, TEMP;
public:
	// 传入值转化,补足末位
	SHA1(const char* in) {
		int inLength = strlen(in);
		DataLength = (inLength % 64 < 56 ? inLength / 64 + 1 : inLength / 64 + 2)*16;
		Data = new uint32_t[DataLength];
		memset(Data, 0, sizeof(uint32_t) * DataLength);
		// char转uint32_t
		for (int i = 0; i < inLength / 4 + 1; i++) {
			for (int j = 0; j < 4; j++) {
				Data[i] <<= 8;
				if (i * 4 + j < inLength)
					Data[i] = Data[i] | in[i * 4 + j] & 255;
			}
		}
		// 末位补1
		Data[inLength / 4] |= 1 << (31 - inLength % 4 * 8);
		// 补足后64位
		Data[DataLength - 1] = inLength * 8;
	}

	void Output(bool in) {
		for (uint32_t i = 0; i < DataLength; i++) {
			for (int j = 0; j < 32; j++) {
				cout << ((Data[i] >> (31 - j)) & 1);
				if (j % 8 == 7)
					cout << " ";
			}
			cout << endl;
		}
	}

	void loop() {
		uint32_t* Data80 = new uint32_t[80];
		uint32_t K, F;
		// H0-4 init
		{
			H0 = 0x67452301;
			H1 = 0xEFCDAB89;
			H2 = 0x98BADCFE;
			H3 = 0x10325476;
			H4 = 0xC3D2E1F0;
		}
		// A-E every loop
		{
			A = H0;
			B = H1;
			C = H2;
			D = H3;
			E = H4;
		}
		// 缓冲区 every loop
		{
			for (int i = 0; i < 16; i++)
				Data80[i] = Data[i];
			for (int i = 16; i < 80; i++)
				Data80[i] = leftrotate(1, Data80[i - 3] ^ Data80[i - 8] ^ Data80[i - 14] ^ Data80[i - 16]);
		}
		// 执行主体
		{
			for (int i = 0; i < 20; i++) {
				F = (B & C) | (~B & D);
				K = 0x5A827999;
				TEMP = (leftrotate(5, A)) + F + E + K + Data80[i];
				E = D; D = C; C = leftrotate(30, B); B = A; A = TEMP;
			}
			for (int i = 20; i < 40; i++) {
				F = B ^ C ^ D;
				K = 0x6ED9EBA1;
				TEMP = (leftrotate(5, A)) + F + E + K + Data80[i];
				E = D; D = C; C = leftrotate(30, B); B = A; A = TEMP;
			}
			for (int i = 40; i < 60; i++) {
				F = (B & C) | (B & D) | (C & D);
				K = 0x8F1BBCDC;
				TEMP = (leftrotate(5, A)) + F + E + K + Data80[i];
				E = D; D = C; C = leftrotate(30, B); B = A; A = TEMP;
			}
			for (int i = 60; i < 80; i++) {
				F = B ^ C ^ D;
				K = 0xCA62C1D6;
				TEMP = (leftrotate(5, A)) + F + E + K + Data80[i];
				E = D; D = C; C = leftrotate(30, B); B = A; A = TEMP;
			}
		}
		// H1-4 end
		{
			H0 += A;
			H1 += B;
			H2 += C;
			H3 += D;
			H4 += E;
		}
		Output16(H0).Output16(H2).Output16(H3).Output16(H4);
	}
	uint32_t leftrotate(int bits, uint32_t num) {
		return (((num << bits) & 0xFFFFFFFF) | ((num) >> (32 - bits)));
	}
	SHA1& Output(uint32_t in) {
		for (int j = 0; j < 32; j++) {
			cout << ((in >> (31 - j)) & 1);
			if (j % 8 == 7)
				cout << " ";
		}
		return *this;
	}
	SHA1& Output16(uint32_t in) {
		for (int i = 0; i < 8; i++) {
			int num = (in >> ((7 - i) * 4)) % 16;
			num = num < 0 ? num + 16 : num;
			switch (num) {
			case 10:cout << 'a'; break;
			case 11:cout << 'b'; break;
			case 12:cout << 'c'; break;
			case 13:cout << 'd'; break;
			case 14:cout << 'e'; break;
			case 15:cout << 'f'; break;
			default:cout << num;
			}
		}
		cout << endl;
		return *this;
	}
};

int main(int arvc, char** arvg) {
	string m = "Cuiyuming123";
	SHA1 b(m.c_str());
	//b.Output(true);
	b.loop();
}

```