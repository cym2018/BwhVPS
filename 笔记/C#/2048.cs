/*
2019年7月6日 22点06分
学习C#
*/
using System;
namespace ConsoleApp1
{
    class Program
    {
        static void Main(string[] args)
        {
            My2048 my2048 = new My2048();
            my2048.Loop();
        }
    }
    public class MyTime
    {
        public static double dMilliseconds
        {
            get
            {
                TimeSpan ts = DateTime.UtcNow - new DateTime(1970, 1, 1, 0, 0, 0, 0);
                return ts.TotalMilliseconds;
            }
        }
        public static int iMilliseconds
        {
            get
            {
                int ret = (int)(Convert.ToInt64(dMilliseconds) % int.MaxValue);
                return ret;
            }
        }
    }
    public class My2048
    {
        private readonly Random random;
        private readonly int[,] date;
        private int iNumberOfZero;

        public My2048()
        {
            date = new int[4, 4];
            iNumberOfZero = 16;
            random = new Random(MyTime.iMilliseconds);
        }
        // 在已有的空格内添加一个2
        public bool Add()
        {
            int iX = 0, iY = 0;
            if (iNumberOfZero == 0)
                return false;
            while (GetDate(iX, iY) != 0)
            {
                iY = iX < 3 ? iY : iY + 1;
                iX = iX < 3 ? iX + 1 : 0;
            }
            int iNext = random.Next(1, iNumberOfZero);
            while (iNext != 0)
            {
                iY = iX < 3 ? iY : iY + 1;
                iX = iX < 3 ? iX + 1 : 0;
                while (GetDate(iX, iY) != 0)
                {
                    iY = iX < 3 ? iY : iY + 1;
                    iX = iX < 3 ? iX + 1 : 0;
                }
                iNext--;
            }
            SetDate(iX, iY, 2);
            iNumberOfZero--;
            ShowMap();
            return true;
        }

        public int GetDate(int line, int col) => date[col, line];

        public void SetDate(int line, int col, int value) => date[col, line] = value;

        // 显示地图
        public void ShowMap()
        {
            iNumberOfZero = 0;
            Console.Clear();
            for (int y = 0; y < 4; y++)
            {
                for (int x = 0; x < 4; x++)
                {
                    Console.Write(GetDate(x, y) + "\t");
                    if (GetDate(x, y) == 0)
                        iNumberOfZero++;
                }
                Console.WriteLine("");
            }
            Console.WriteLine("");
        }

        public int[] LineL(int col)
        {
            int[] a = new int[4];
            for (int i = 0; i < 4; i++)
                a[i] = GetDate(i, col);
            for (int j = 0; j < 3; j++)
                for (int i = 0; i < 3; i++)
                    if (a[i] == 0)
                    {
                        a[i] = a[i + 1];
                        a[i + 1] = 0;
                    }
            return a;
        }
        public int[] LineR(int col)
        {
            int[] a = new int[4];
            for (int i = 0; i < 4; i++)
                a[i] = GetDate(i, col);
            for (int j = 0; j < 3; j++)
                for (int i = 3; i > 0; i--)
                    if (a[i] == 0)
                    {
                        a[i] = a[i - 1];
                        a[i - 1] = 0;
                    }
            return a;
        }
        public int[] ColU(int line)
        {
            int[] a = new int[4];
            for (int i = 0; i < 4; i++)
                a[i] = GetDate(line, i);
            for (int j = 0; j < 3; j++)
                for (int i = 0; i < 3; i++)
                    if (a[i] == 0)
                    {
                        a[i] = a[i + 1];
                        a[i + 1] = 0;
                    }
            return a;
        }
        public int[] ColD(int line)
        {
            int[] a = new int[4];
            for (int i = 0; i < 4; i++)
                a[i] = GetDate(line, i);
            for (int j = 0; j < 3; j++)
                for (int i = 3; i > 0; i--)
                    if (a[i] == 0)
                    {
                        a[i] = a[i - 1];
                        a[i - 1] = 0;
                    }
            return a;
        }

        public void SaveCol(int[] a, int line)
        {
            for (int i = 0; i < 4; i++)
                SetDate(line, i, a[i]);
        }
        private void SaveLine(int[] a, int col)
        {
            for (int i = 0; i < 4; i++)
                SetDate(i, col, a[i]);
        }
        private int[] MixL(int[] a)
        {
            int i = 0;// 合成前id
            int j = 0;// 合成后id
            int iFirst, iEnd;
            int[] ret = new int[4];
            while (i < 3)
            {
                iFirst = a[i];
                iEnd = a[i + 1];
                if (iFirst == iEnd)
                {
                    ret[j++] = iFirst * 2;
                    i += 2;
                    continue;
                }
                ret[j++] = iFirst;
                i++;
            }
            if (i == 3)
                ret[j++] = a[i];
            return ret;
        }
        public int[] MixR(int[] a)
        {
            int i = 3;// 合成前id
            int j = 3;// 合成后id
            int iFirst, iEnd;
            int[] ret = new int[4];
            while (i > 0)
            {
                iFirst = a[i];
                iEnd = a[i - 1];
                if (iFirst == iEnd)
                {
                    ret[j--] = iFirst * 2;
                    i -= 2;
                    continue;
                }
                ret[j--] = iFirst;
                i--;
            }
            if (i == 0)
                ret[j--] = a[i];
            return ret;
        }
        public void DoUp()
        {
            for (int i = 0; i < 4; i++)
            {
                int[] a = ColU(i);
                a = MixL(a);
                SaveCol(a, i);
            }
        }
        public void DoDown()
        {
            for (int i = 0; i < 4; i++)
            {
                int[] a = ColD(i);
                a = MixR(a);
                SaveCol(a, i);
            }
        }
        public void DoLeft()
        {
            for (int i = 0; i < 4; i++)
            {
                int[] a = LineL(i);
                a = MixL(a);
                SaveLine(a, i);
            }
        }
        public void DoRight()
        {
            for (int i = 0; i < 4; i++)
            {
                int[] a = LineR(i);
                a = MixR(a);
                SaveLine(a, i);
            }
        }
        public void Loop()
        {
            Add();
            while (true)
            {
                switch (Console.ReadKey().Key.ToString())
                {
                    case "W":
                        DoUp();
                        break;
                    case "A":
                        DoLeft();
                        break;
                    case "S":
                        DoDown();
                        break;
                    case "D":
                        DoRight();
                        break;
                    default:
                        break;
                }
                Add();
            }
        }
    }
}
