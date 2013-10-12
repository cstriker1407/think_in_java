package yeah.cstriker1407.think_in_java.Enum;

public enum EnumsWith2Interfaces
{
	Phone(InterfaceEnum.Phone.class),
	PC(InterfaceEnum.PC.class);
	
	private InterfaceEnum [] values;
	private EnumsWith2Interfaces(Class<? extends InterfaceEnum> kind)
	{
		this.values = kind.getEnumConstants();
	}

	public InterfaceEnum[] getValues()
	{
		return values;
	}

	public interface InterfaceEnum
	{
		public String getInfo();
		enum Phone implements InterfaceEnum 
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
		enum PC implements InterfaceEnum
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
}
