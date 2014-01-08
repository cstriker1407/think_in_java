package yeah.cstriker1407.beautycode;

import java.util.Random;

public class LiftTest
{
	public static void test()
	{
		Random random = new Random();
		
		int floorNums = random.nextInt(10) + 1;
		System.out.println("电梯总层数：" + (floorNums));
		int[] peopleNums = new int[floorNums];
		for (int i = 0; i < peopleNums.length; i++)
		{
			peopleNums[i] = random.nextInt(20);
			System.out.println("第[" + (i+1) +"]层的乘客数目为：" + peopleNums[i]);
		}
		
		
		liftDispatchA(peopleNums);
		liftDispatchB(peopleNums);
	}
	
	public static void liftDispatchA(int [] peopleNums)
	{
		int floorNum = peopleNums.length;
		
		int minUse = -1;
		int bestFloor = -1;
		
		for (int i = 0; i < floorNum; i++)
		{
			int thisUse = 0;
			/* i 代表当前停留楼层（从0计数） */
			for (int j = 0; j < floorNum; j++)
			{
				thisUse += Math.abs(i - j) * peopleNums[j];
			}
			if (minUse == -1 || minUse > thisUse)
			{
				minUse = thisUse;
				bestFloor = i;
			}
		}
		
		System.out.println("最优停留楼层：" + (bestFloor + 1));
		System.out.println("耗费人力：" + minUse);
	}
	
	public static void liftDispatchB(int [] peopleNums)
	{	
		int floorNum = peopleNums.length;
		
		/* 以电梯停留在第0层开始（从0计数） */
		int N1 = 0;
		int N2 = peopleNums[0];
		int N3 = 0;
		int minUse = 0;
		int bestFloor = 0;
		for (int i = 1; i < floorNum; i++)
		{
			N3 += peopleNums[i];
			minUse += peopleNums[i] * i;
		}
		
		/*
		 * F(i+1) = F(i) + N1 + N2 - N3
		 * 如果N1 + N2 > N3，则可以推出 F(i+1) > F(i)；
		 * 同时由于从电梯0层开始向上计数，因此N1增加，N3减小，一旦在某一层上N1 + N2 > N3，那么剩余的电梯层必然也会N1 + N2 > N3，
		 * 就可以不用计算了
		 */
		for (int i = 1; i < floorNum; i++)
		{
			if (N1 + N2 > N3)
			{
				break;
			}else 
			{
				bestFloor = i;
				minUse = minUse + N1 + N2 - N3;
				N1 += N2;
				N2 = peopleNums[i];
				N3 -= peopleNums[i];
			}
		}
		
		System.out.println("最优停留楼层：" + (bestFloor + 1));
		System.out.println("耗费人力：" + minUse);
	}
}
