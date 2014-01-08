package yeah.cstriker1407.beautycode;

import java.util.Arrays;

public class BackTraceTest
{
	public static void test()
	{
		/*
		 * 在8*8皇后问题中，由于8个皇后不能同行同列同对角线（45度），而棋盘也是8行8列的，因此
		 * 每行必须有且只有一个皇后，所以这里使用一维数组来保存每个皇后所在列的ID，而数组的下标
		 * 作为皇后所在行的ID，同时表示该皇后的ID，即targetQueens[3] = 4,表示ID为3的皇后在第3行，第4列（0为起始值）
		 */
		int[] targetQueens = new int [8];
		Arrays.fill(targetQueens, -2);
		
		//递归方式
		internelPlaceQueen(targetQueens,0);
		
		System.out.println("====");
		
		//非递归方式：
		palceQueen2(targetQueens);
		
	}

	private static void palceQueen2(int [] queens)
	{
		int currIdx = 0;
		queens[currIdx] = -1;
		while(currIdx >= 0)
		{
			/* 首先获取第一个可以存放的列 */
			do
			{
				queens[currIdx] = queens[currIdx] + 1;
			} while ((!canQueenPlace(queens, currIdx)) && (queens[currIdx] < 8));

			
			/* 判断循环退出条件，如果是当前queen无法获取有效列数，那么就回溯 */
			if (queens[currIdx] == 8)
			{
				queens[currIdx] = -1;
				currIdx = currIdx -1;
			}else 
			{
				/* 如果当前的queen是最后一个，就打印出来 */
				if (currIdx >= 7)
				{
					System.out.println(Arrays.toString(queens));
				}else
				{/* 如果当前的queen不是最后一个，就向下继续循环 */
					currIdx++;
					queens[currIdx] = -1;
				}
			}
		}
	}

	private static void internelPlaceQueen(int [] queens,int targetIdx)
	{
		if (targetIdx >= 8)
		{
			System.out.println(Arrays.toString(queens));
			return;
		}

		for (int i = 0; i < 8; i++)
		{
			queens[targetIdx] = i;
			if (canQueenPlace(queens, targetIdx))
			{
				internelPlaceQueen(queens,targetIdx + 1);
			}
		}
		
	}
	
	/* 求绝对值 */
	private static int abs(int x)
	{
		return x > 0 ? x:(-x);
	}
	/* 当前皇后targetIdx 能否放在queens数组里 */
	private static boolean canQueenPlace(int [] queens, int targetIdx)
	{
		for (int i = 0; i < targetIdx; i++)
		{
			if (queens[i] == queens[targetIdx])
				return false;
			
			if (abs(targetIdx - i) == abs(queens[targetIdx] - queens[i]))
				return false;
		}
		return true;
	}
}
