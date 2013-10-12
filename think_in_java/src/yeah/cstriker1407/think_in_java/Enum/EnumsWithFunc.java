package yeah.cstriker1407.think_in_java.Enum;

public enum EnumsWithFunc
{
	XiaoMing(10,"yinianji"),/* 实例必须是第一个 */
	ZhangSan(12,"ernianji");/* 最后一个实例后面的是‘；’ */
	
	private int age;
	private String des;
	private EnumsWithFunc(int age, String des)/* 构造方法的标识符为private */
	{
		this.age = age;
		this.des = des;
	}
	public String showInfo()
	{
		return "Age:" + age + "  " + des;
	}
}
