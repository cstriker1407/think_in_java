package yeah.cstriker1407.beautycode;

import java.util.Arrays;


//http://hawstein.com/posts/dp-knapsack.html
//http://www.cnblogs.com/sdjl/articles/1274312.html
public class DiamondTest
{
	private static int max(int a, int b)
	{
		return a>b ? a:b;
	}
	
	public static void test()
	{
		/*
		diamonds[X][0]：第X个钻石的体积
		diamonds[X][1]：第X个钻石的价值
		*/
		int [][] diamonds = 
			{
				{2 ,6},
				{2 ,3},
				{6 ,5},
				{5 ,4},
				{4 ,6},
			};
		int maxDiamondValue1 = diamondTest1(diamonds, 10);
		System.out.println("maxDiamondValue1:" + maxDiamondValue1);
		
		int maxDiamondValue2 = diamondTest2(diamonds, 10);
		System.out.println("maxDiamondValue2:" + maxDiamondValue2);
		
		int maxDiamondValue2A = diamondTest2A(diamonds, 10);
		System.out.println("maxDiamondValue2A:" + maxDiamondValue2A);
		
		int maxDiamondValue2B = diamondTest2B(diamonds, 10);
		System.out.println("maxDiamondValue2B:" + maxDiamondValue2B);
		int maxDiamondValue2C = diamondTest2C(diamonds, 10);
		System.out.println("maxDiamondValue2A:" + maxDiamondValue2C);
		
	}


	
	
	private static int diamondTest1(int[][] diamonds, int currCapacity)
	{
		/*
		 maxValue[i][j]:表示当钻石总数为i个，当前剩余容积为j的时候，总数的最大价值。
		 */
		int [][]maxValue = new int [diamonds.length + 1][currCapacity + 1];
		for (int[] is : maxValue)
		{
			Arrays.fill(is, -1);
		}

		internelDiamondTest1(maxValue, diamonds, diamonds.length, currCapacity);
		
		return maxValue[diamonds.length][currCapacity];
	}
	
	private static int internelDiamondTest1(int[][] maxValue, int[][] diamonds,int currDiaNum, int currCapacity)
	{
		if (maxValue[currDiaNum][currCapacity] != -1)
		{
			return maxValue[currDiaNum][currCapacity];
		}

		if (currDiaNum == 0)
		{
			maxValue[currDiaNum][currCapacity] = 0;
			return maxValue[currDiaNum][currCapacity];
		}
		
		if (currDiaNum == 1)
		{
			maxValue[currDiaNum][currCapacity] = currCapacity >= diamonds[currDiaNum -1][0] ? diamonds[currDiaNum -1][1]:0;
			return maxValue[currDiaNum][currCapacity];
		}

		if (currCapacity >= diamonds[currDiaNum-1][0])
		{
			maxValue[currDiaNum][currCapacity] = 
					max(
					internelDiamondTest1(maxValue, diamonds, currDiaNum-1, currCapacity-diamonds[currDiaNum-1][0]) + diamonds[currDiaNum-1][1], 
					internelDiamondTest1(maxValue, diamonds, currDiaNum-1, currCapacity)
					);
		}else
		{
			maxValue[currDiaNum][currCapacity] = internelDiamondTest1(maxValue, diamonds, currDiaNum-2, currCapacity);
		}
		return maxValue[currDiaNum][currCapacity];
	}
	
	
	private static int diamondTest2(int[][] diamonds, int currCapacity)
	{
		/*
		 maxValue[i][j]:表示当钻石总数为i个，当前剩余容积为j的时候，总数的最大价值。
		 */
		int [][]maxValue = new int[diamonds.length + 1][currCapacity + 1];

		/*
		 当钻石的总数为0时，不管当前剩余容积多大，总价值都为0 
		 */
		for (int i = 0; i <= currCapacity; i++)
		{
			maxValue[0][i] = 0;
		}
		
		for (int i = 1; i <= diamonds.length; i++)
		{
			/* 由于i值是递增的， 因此每次内层i循环后，diamonds[i-1][...]的值已经是定值了 */
			for (int j = 0; j <= currCapacity; j++)
			{
				/*
				 当讨论前i个宝石装入背包的时候， 其实是在考查第i-1个宝石装不装入背包（因为宝石是从0开始编号的）。第i个宝石在数组中的位置是diamond[i-1][]
				 */
				if (j > diamonds[i-1][0])
				{
					maxValue[i][j] =max(maxValue[i-1][j - diamonds[i-1][0]] + diamonds[i-1][1], maxValue[i - 1][j]) ;
				}else
				{
					maxValue[i][j] = maxValue[i-1][j];
				}
			}
		}
		return maxValue[diamonds.length][currCapacity];
	}
	
	/* diamondTest2A 函数是diamondTest2的第二种版本  */
	private static int diamondTest2A(int[][] diamonds, int currCapacity)
	{
		int [][]maxValue = new int[diamonds.length + 1][currCapacity + 1];
		
		for (int i = 0; i <= diamonds.length; i++)
		{
			for (int j = 0; j <= currCapacity; j++)
			{
				maxValue[i][j] = i == 0 ? 0:maxValue[i-1][j];
				if (i > 0 && j > diamonds[i-1][0])
				{
					maxValue[i][j] = max(maxValue[i-1][j-diamonds[i-1][0]] + diamonds[i-1][1], maxValue[i - 1][j]) ;
				}
			}
		}
		return maxValue[diamonds.length][currCapacity];
	}
	/* diamondTest2B 函数是diamondTest2的第三种版本  */
	private static int diamondTest2B(int[][] diamonds, int currCapacity)
	{
		int [][]maxValue = new int[diamonds.length + 1][currCapacity + 1];
		
		for (int i = 0; i <= diamonds.length; i++)
		{
			/* 在本循环内，diamonds[i-1][...]的值已经是计算过的定值了，
			 * 而maxValue[i][j]的计算全部是由maxValue[...][j-..]计算的，与maxValue[...][j]无关，
			 * 所以j可以用递减序来计算 */
			for (int j = currCapacity; j >= 0; j--)
			{
				maxValue[i][j] = i == 0 ? 0:maxValue[i-1][j];
				
				if (i > 0 && j > diamonds[i-1][0])
				{
					maxValue[i][j] =max(maxValue[i-1][j-diamonds[i-1][0]] + diamonds[i-1][1], maxValue[i - 1][j]) ;
				}
			}
		}
		return maxValue[diamonds.length][currCapacity];
	}
	
	
	/* diamondTest2C 函数是diamondTest2的第四种版本  */
	private static int diamondTest2C(int[][] diamonds, int currCapacity)
	{
		int []maxValue = new int[currCapacity + 1];
		
		for (int i = 0; i <= diamonds.length; i++)
		{
			/* 在逆序的基础上，可以通过减少本循环内的maxValue的维度来达到最小的空间复杂度  */
			for (int j = currCapacity; j >= 0; j--)
			{
				if (i > 0 && j > diamonds[i-1][0])
				{
					maxValue[j] =max(maxValue[j-diamonds[i-1][0]] + diamonds[i-1][1], maxValue[j]) ;
				}
			}
		}
		return maxValue[currCapacity];
	}
	
}
