package yeah.cstriker1407.effectivejava;

/* 保护性拷贝 */
public class Rule39
{
	public static void test()
	{
		{
			Rule39Bean small = new Rule39Bean(10);
			Rule39Bean big = new Rule39Bean(20);
			PeriodA periodA = new PeriodA(small, big);
			periodA.check();
			big.value = 5;//修改成功
			periodA.check();
		}
		
		{
			Rule39Bean small = new Rule39Bean(10);
			Rule39Bean big = new Rule39Bean(20);
			PeriodB periodB = new PeriodB(small, big);
			periodB.check();
			big.value = 5;//修改失败
			periodB.check();
			periodB.getBig().value = 5;//修改成功
			periodB.check();
		}
	
		{
			Rule39Bean small = new Rule39Bean(10);
			Rule39Bean big = new Rule39Bean(20);
			PeriodC periodC = new PeriodC(small, big);
			periodC.check();
			big.value = 5;//修改失败
			periodC.check();
			periodC.getBig().value = 5;//修改失败
			periodC.check();
		}
	}
}

class Rule39Bean
{
	public int value;
	public Rule39Bean(int value)
	{
		this.value = value;
	}
	public Rule39Bean(Rule39Bean bean)
	{
		this.value = bean.value;
	}
}

abstract class Period
{
	public Period(Rule39Bean small, Rule39Bean big)
	{
	}
	protected Rule39Bean small;
	protected Rule39Bean big;
	public void check()
	{
		if (small.value < big.value)
		{
			System.out.println("Right!! small < big");
		}else
		{
			System.out.println("Wrong!! small >= big");
		}
	}
	public Rule39Bean getBig()
	{
		return big;
	}
}

class PeriodA extends Period
{
	public PeriodA(Rule39Bean small, Rule39Bean big)
	{
		super(small, big);
		this.small = small;
		this.big = big;
		if (small.value >= big.value)
		{
			throw new IllegalArgumentException("small >= big");
		}
	}
}
class PeriodB extends Period
{
	public PeriodB(Rule39Bean small, Rule39Bean big)
	{
		super(small, big);
		this.small = new Rule39Bean(small);
		this.big = new Rule39Bean(big);
		if (small.value >= big.value)
		{
			throw new IllegalArgumentException("small >= big");
		}
	}
}
class PeriodC extends PeriodB
{
	public PeriodC(Rule39Bean small, Rule39Bean big)
	{
		super(small, big);
	}

	@Override
	public Rule39Bean getBig()
	{
		return new Rule39Bean(big);
	}
}