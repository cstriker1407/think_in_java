package yeah.cstriker1407.think_in_java.Generics;


abstract class BaseClass
{
	public abstract int getInt();
	
}
interface BaseInterFace
{
	public String getStr();
}
class TestClass extends BaseClass implements BaseInterFace
{

	@Override
	public String getStr()
	{
		return "TestClass";
	}

	@Override
	public int getInt()
	{
		return 1000;
	}

	@Override
	public String toString()
	{
		return "TestClass";
	}
	
}


public class GenericExtends
{
	public static <T extends BaseClass> int fun1(T item)
	{
		return item.getInt();
	}

	public static <T extends BaseInterFace> String fun2(T item)
	{
		return item.getStr();
	}

	/*
	 * 这里只表示到时的具体类型 T 是 Comparable 的一种类型，extends 后是接口，还是类都是用 extends 关键字，不在此区分接口还是类，只表示 Is-A 的关系。 
	 * 如果在泛型实现中会调用到多个方法，要求泛型参数同属不同的类型，就 extends 多个接口或类，中间用 & 符号隔开。
	 */
	public static <T extends BaseClass & BaseInterFace> void fun3(T item)
	{
		System.out.println(item.toString());
	}
	
	
	public static void callFun()
	{
		GenericExtends.fun1(new TestClass());
		GenericExtends.fun2(new TestClass());
		GenericExtends.fun3(new TestClass());
		
		GenericExtends.<TestClass>fun1(new TestClass());
		GenericExtends.<TestClass>fun2(new TestClass());
		GenericExtends.<TestClass>fun3(new TestClass());
	}
	
	
}
