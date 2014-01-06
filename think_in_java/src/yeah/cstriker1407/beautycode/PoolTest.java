package yeah.cstriker1407.beautycode;

import java.util.LinkedList;
import java.util.List;

public class PoolTest
{
	private static final int [] bucketSzie = new int[]{28,23,16,12,8,7,6,3,1};
	
	public static void test()
	{
		fillPool(31,0, new LinkedList<Integer>());
	}
	private static void fillPool(int empty, int currBucketIdx,  List<Integer> fillList)
	{
		//如果最小的桶>当前剩余容量，则返回
		if (currBucketIdx >= bucketSzie.length || empty < bucketSzie[bucketSzie.length - 1])
		{
			System.out.print("A:");
			System.out.println(fillList.toString());
			return;
		}
		
		//如果当前剩余容量恰好是水桶的整数倍，那么返回
		if (empty % bucketSzie[currBucketIdx] == 0)
		{
			for (int i = empty / bucketSzie[currBucketIdx]; i > 0; i--)
			{
				fillList.add(bucketSzie[currBucketIdx]);
			}
			System.out.print("B:");
			System.out.println(fillList.toString());
			return;
		}
		
		if(empty < bucketSzie[currBucketIdx])
		{
			fillPool(empty, currBucketIdx + 1, fillList);
		}
		else
		{
			/* 遍历各种方法 */
			for (int i = currBucketIdx; i < bucketSzie.length; i++)
			{
				List<Integer> newList = new LinkedList<Integer>();
				newList.addAll(fillList);
				newList.add(bucketSzie[i]);
				fillPool(empty - bucketSzie[i], i, newList);
			}
		}
	}
}
