package yeah.cstriker1407.think_in_java;

import yeah.cstriker1407.think_in_java.Enum.DistinctEnum;
import yeah.cstriker1407.think_in_java.Enum.EnumsWith2Interfaces;
import yeah.cstriker1407.think_in_java.Enum.EnumsWithFunc;
import yeah.cstriker1407.think_in_java.Enum.EnumInter;
import yeah.cstriker1407.think_in_java.Enum.SimpleEnums;

public class Main
{
	public static void main(String[] args)
	{
		System.out.println("Enum Learn");
		for (SimpleEnums simpleItem : SimpleEnums.values())
		{
			System.out.println(simpleItem.name());
		}
		for (EnumsWithFunc item : EnumsWithFunc.values())
		{
			System.out.println(item.name());
			System.out.println(item.showInfo());
		}
		testfun_EnumWithInterfaces(EnumInter.PC.IBM);
		testfun_EnumWithInterfaces(EnumInter.Phone.HW);
		testfun_EnumWith2Interfaces(EnumsWith2Interfaces.PC.getValues()[0]);
		
		DistinctEnum testDistinctEnum = DistinctEnum.Fifth;
		System.out.println(testDistinctEnum.getInt());
		DistinctEnum lookupEnum = DistinctEnum.map.get(1);
		System.out.println(lookupEnum.getInt());
		
		
	}
	
	
	private static void testfun_EnumWithInterfaces(EnumInter interfaces)
	{
		System.out.println(interfaces.getInfo());
	}
	
	private static void testfun_EnumWith2Interfaces(EnumsWith2Interfaces.InterfaceEnum interfaces)
	{
		System.out.println(interfaces.getInfo());
	}
}
