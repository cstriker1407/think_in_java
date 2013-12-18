package yeah.cstriker1407.effectivejava;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* 不要返回NULL */
public class Rule43
{
	public static void test()
	{
		NullClass class1 = new NullClass();
		if (class1.getArrs() != null)
		{
			System.out.println("return arrs not null");
		}
		System.out.println(class1.getList().toString());
	}
}
class Rule43Bean
{
	//sth
}
class NullClass
{
	private static final Rule43Bean[] emptyArray = new Rule43Bean[0];
	private List<Rule43Bean> list = new ArrayList<Rule43Bean>();
	
	/*some methods*/
	
	//返回数组
	public Rule43Bean[] getArrs()
	{
		return list.toArray(emptyArray);
	}
	
	//返回list
	public List<Rule43Bean> getList()
	{
		if (list.isEmpty())
		{//返回空的list
			return Collections.emptyList();
		}else
		{//保护性拷贝
			return new ArrayList<Rule43Bean>(list);
		}
	}
}