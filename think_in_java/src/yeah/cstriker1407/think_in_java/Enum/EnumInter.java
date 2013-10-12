package yeah.cstriker1407.think_in_java.Enum;

public interface EnumInter
{
	public String getInfo();
	enum Phone implements EnumInter 
	{
		HW("dalu"),SAMSUNG("waiguo");

		private String info;
		private Phone(String info)
		{
			this.info = info;
		}
		@Override
		public String getInfo()
		{
			return info;
		}
	}
	enum PC implements EnumInter
	{
		IBM("I"),APPLE("A");
		private String info;
		private PC(String info)
		{
			this.info = info;
		}
		@Override
		public String getInfo()
		{
			return info;
		}
	}
}


