package yeah.cstriker1407.think_in_java.Array;

import java.util.Arrays;

public class Base
{
	public static <T> T[] funTest(T[] in)
	{
		return in;
	}
	
	public static void newArray()
	{
		String[] aArray = new String[5];
		String[] bArray = {"a","b","c", "d", "e",};
		String[] cArray = new String[]{"a","b","c","d","e"};
		
		String[][] dArray = 
			{
				{"1","2","3"},
				{"4","5","6"},				
			};
		
		String[][] eArray = new String[2][];
		eArray[0] = new String[]{"x","y","z"};
		eArray[1] = new String[]{"a","b","c","d","e"};
		String[][] fArray = 
			{
				{"1","2","3"},
				{"4","5","6","7","8"},				
			};
		
		System.out.println(dArray.length);//2
		System.out.println(Arrays.deepToString(fArray));

		System.out.println(Arrays.deepToString(funTest(new Integer[]{1,2,3})));
		System.out.println(Arrays.deepToString(funTest( new String[]{"a","b","c", "d", "e"} )));
	}

}
