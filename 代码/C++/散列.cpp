/* 崔雨鸣 2019年4月16日15点03分
// 印象中这种方式叫散列
// 另一个翻译名为哈希。
// 不懂哈希值计算方法。
// 只好用取余做
// 成功将leetcode问题一 
// 运行时间从224ms降低到最低48ms
// 题目链接 https://leetcode-cn.com/problems/two-sum/solution/
*/
//最大字典个数
constexpr auto maxDate = 300000;
using namespace std;
class HASH {
public:
	// 标记数据为空的值
	int nodefine;
	// 存放数据的位置
	int *data;
	// 记录0的个数
	int zero;

	HASH() {
		nodefine=-888888;
		data = new int[maxDate];
		for (int i = 0; i < maxDate; i++)
			data[i] = nodefine;
		zero = 0;
	}
	// 存储
	void rec(int iIn) {
		int i = (iIn % maxDate + maxDate) % maxDate;
		if (iIn == 0) {
			zero++;
			return;
		}
		while (data[i % maxDate] != nodefine)
			i++;
		data[i % maxDate] = iIn;
	}
	// 获取个数
	int rea(int iIn) {
		if (iIn == 0)
			return zero;
		int i = (iIn % maxDate + maxDate) % maxDate, num = 0;
		while (data[i % maxDate] != nodefine)
			if (data[i++ % maxDate] == iIn)
				num++;
		return num;
	}
};
