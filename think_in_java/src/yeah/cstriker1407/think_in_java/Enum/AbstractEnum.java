package yeah.cstriker1407.think_in_java.Enum;


public enum AbstractEnum
{
	test
	{
		@Override
		public void Func()
		{
			System.out.println("func in enum");
		}
		
	};
	
	public abstract void Func();

}
