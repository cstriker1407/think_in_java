package yeah.cstriker1407.think_in_java.Enum;

import java.util.HashMap;

public enum DistinctEnum
{
	First(1),
	Second(2),
	Fifth(5);
	public static final HashMap<Integer, DistinctEnum> map = new HashMap<Integer, DistinctEnum>();
	static
	{
		for (DistinctEnum item : DistinctEnum.values())
		{
			map.put(item.i, item);
		}
	}
	
	private int i;
	private DistinctEnum(int i)
	{
		this.i = i;
	};
	public int getInt()
	{
		return i;
	}
	
}
