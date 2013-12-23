package yeah.cstriker1407.beautycode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class DiscountTest
{
	public static void test()
	{
		float min = internalCalc(2, 2, 2, 1, 1);
		System.out.println("最小花费：" + min);
	}
	
	public static float internalCalc(int n1, int n2, int n3, int n4, int n5)
	{
		List<Integer> list = new LinkedList<Integer>();
		list.add(n1);
		list.add(n2);
		list.add(n3);
		list.add(n4);
		list.add(n5);
		Collections.sort(list);
		n1 = list.get(4);
		n2 = list.get(3);
		n3 = list.get(2);
		n4 = list.get(1);
		n5 = list.get(0);
		
		float minCost = 8*(n1 + n2 + n3 + n4 + n5);
		if (n5 >= 1)
		{
			float tmp = 5*8*(1-0.25f) + internalCalc(n1-1, n2-1, n3-1, n4-1, n5-1);
			minCost = minCost < tmp ? minCost : tmp;
		}
	
		if (n4 >= 1)
		{
			float tmp = 4*8*(1-0.2f) + internalCalc(n1-1, n2-1, n3-1, n4-1, n5);
			minCost = minCost < tmp ? minCost : tmp;
		}

		if (n3 >= 1)
		{
			float tmp = 3*8*(1-0.10f) + internalCalc(n1-1, n2-1, n3-1, n4, n5);
			minCost = minCost < tmp ? minCost : tmp;
		}
		
		if (n2 >= 1)
		{
			float tmp = 2*8*(1-0.05f) + internalCalc(n1-1, n2-1, n3, n4, n5);
			minCost = minCost < tmp ? minCost : tmp;
		}
		
		if (n1 >= 1)
		{
			float tmp = 1*8 + internalCalc(n1-1, n2, n3, n4, n5);
			minCost = minCost < tmp ? minCost : tmp;
		}
		
		if (n1 < 1)
		{
			float tmp = 0;
			minCost = minCost < tmp ? minCost : tmp;
		}
		
		return minCost;
	}
}