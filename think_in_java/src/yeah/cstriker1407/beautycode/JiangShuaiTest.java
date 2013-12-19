package yeah.cstriker1407.beautycode;


public class JiangShuaiTest
{
	
	public static void test()
	{
		int m = 5;
		int n = 3;
		for (int i = 0; i < m; i++)
		{
			for (int j = 0; j < n; j++)
			{
				System.out.println("m:" + i + "   n:" + j);
			}
		}
		for (int idx = 0; idx < m*n; idx++)
		{
			System.out.println("m:" + idx/n + "   n:" + idx%n);
		}
		
		
		for (int lieA = 1; lieA <= 3; lieA++)
		{
			for (int hangA = 1; hangA <= 3; hangA++)
			{
				for (int lieB = 1; lieB <= 3; lieB++)
				{
					if (lieB == lieA)
					{
						continue;
					}
					
					for (int hangB = 1; hangB <= 3; hangB++)
					{
						int A = lieA * 100 + hangA; 
						int B = lieB * 100 + hangB; 
						System.out.println("A:" + A +"   B:" + B);
					}
				}
			}
		}
		
		System.out.println("=====");
		for (int posA = 1; posA <= 9; posA++)
		{
			for (int posB = 1; posB <= 9; posB++)
			{
				if (posA %3 == posB % 3)
				{
					continue;
				}
				
//				int A = ((posA -1)%3+1) * 100 + ((posA - 1)/3 + 1); 
//				int B = ((posB -1)%3+1) * 100 + ((posB - 1)/3 + 1); 
//				System.out.println("A:" + A +"   B:" + B);
				System.out.println("posA:" + posA +"   posB:" + posB);
			}
		}
		
		System.out.println("=====");
		
		/*
为什么是9*9,考虑到A,B的最大值均为9，那么可以确定，A*B的所有值都不会超过9*9，因此
当totalNum从81开始递减的时候，可以保证totalNum/9的值从9开始递减，
由余法运算规则可知，任何数%9都不会比9大，因此totalNum从81开始递减时，totalNum/9的值从9开始递减。	 
		 */
		int totalNum = 9*9;
		while (totalNum-- != 0)
		{
//			totalNum / 9 =>A
//			totalNum % 9 =>B
			if ( totalNum/9 % 3 == totalNum % 9 %3 )
			{
				continue;
			}
			System.out.println("posA:" + (totalNum/9+1) +"   posB:" + (totalNum%9+1));
		}
	}
}
