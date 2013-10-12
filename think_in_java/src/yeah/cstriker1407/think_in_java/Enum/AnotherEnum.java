package yeah.cstriker1407.think_in_java.Enum;

/* http://blog.csdn.net/chinakite/article/details/3237204 */
public class AnotherEnum
{
	public static final AnotherEnum enum1 = new AnotherEnum(1);
	public static final AnotherEnum enum2 = new AnotherEnum(2);
	public static final AnotherEnum enum3 = new AnotherEnum(3);
	
	private int i;
	private AnotherEnum(int i)
	{
		this.i = i;
	}
}
