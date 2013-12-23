package yeah.cstriker1407.beautycode;

import java.util.LinkedList;
import java.util.List;

public class NumSearchTest
{
	/*
	 * 通过异或的方式来快速找到落单的那个数字。
	 * 
数学运算方式异或有如下的几个运算特性，
1. a ⊕ a = 0 和  a⊕ 0 = a
2. a ⊕ b = b ⊕ a
3. a ⊕b ⊕ c = a ⊕ (b ⊕ c) = (a ⊕ b) ⊕ c
4. d = a ⊕ b ⊕ c 可以推出 a = d ⊕ b ⊕ c
5. a ⊕ b ⊕ a = b
通过这些特性，可以发现异或遵循交换律，当数组中的有一个落单的数时，其他的所有数均可两两异或为0，剩下的落单数与0异或得到原值
	 */
	public static void test()
	{
		List<Integer> numList = new LinkedList<Integer>();
		for (int i = 0; i < 1000; i++)
		{
			numList.add(i);
			numList.add(i);
		}
		int key = 666;
		numList.remove(new Integer(key));
	
		int searchResult = 0;
		for (Integer item : numList)
		{
			searchResult = searchResult ^ item;
		}
		System.out.println("result:" + searchResult);
	}
}
