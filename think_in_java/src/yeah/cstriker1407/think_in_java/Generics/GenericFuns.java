package yeah.cstriker1407.think_in_java.Generics;

public class GenericFuns
{
	
	public static <T> T fun(T [] a)//泛型类的类型参数(<T>) 是紧贴着类名的后面，而泛型方法的类型参数(<T>) 是紧贴着方法声明的返回类型的前面。
	{
		return a[0];
	}
	
	public static <T,U> String fun2(T [] a,U [] u)
	{
		T itemT = a[0];
		U itemU = u[0];
		return itemT.toString() + "    " + itemU.toString();
	}
	
	
	
	public static void callFun()
	{
		String [] arrs = new String[]{"a","b"};
		System.out.println( GenericFuns.fun(arrs) );
		System.out.println( GenericFuns.<String>fun(arrs) );
		
		System.out.println( GenericFuns.fun2(new Float[]{1.0f}, new Integer[]{1}) );
		System.out.println( GenericFuns.<Float,Integer>fun2(new Float[]{1.0f}, new Integer[]{1}) );
		
	}
}
