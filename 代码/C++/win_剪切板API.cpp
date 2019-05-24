int ClipboardWrite(string command)
{
	HWND hwnd = NULL;
	OpenClipboard(hwnd);
	EmptyClipboard();
	HANDLE hHandle = GlobalAlloc(GMEM_FIXED, 1000);//分配内存
	char* pData = (char*)GlobalLock(hHandle);//锁定内存，返回申请内存的首地址
	strcpy_s(pData, 100, char_command);
	SetClipboardData(CF_TEXT, hHandle);//设置剪切板数据格式
	GlobalUnlock(hHandle);//解除锁定
	CloseClipboard();//关闭剪切板
	return 0;
}//command 内容写入剪切板


EmptyClipboard();//清空剪切板


string ClipboardRead()
{
	HWND hwnd = NULL;
	HANDLE hClip;
	char* pBuf;
	if (!OpenClipboard(hwnd))return 0;
	hClip = GetClipboardData(CF_TEXT);
	pBuf = (char*)GlobalLock(hClip);
	GlobalUnlock(hClip);
	CloseClipboard();
	return pBuf;
}//返回剪切板内容
