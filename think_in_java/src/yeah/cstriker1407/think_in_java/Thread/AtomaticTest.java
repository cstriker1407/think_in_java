package yeah.cstriker1407.think_in_java.Thread;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;


public class AtomaticTest
{
	public static void test()
	{
		AtomicInteger money = new AtomicInteger(100);
		
		MoneyAdd t1 = new MoneyAdd(0, money);
		MoneyAdd t2 = new MoneyAdd(1, money);
		MoneyAdd t3 = new MoneyAdd(2, money);
		MoneyAdd t4 = new MoneyAdd(3, money);
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}

class MoneyAdd extends Thread
{
	int id;
	AtomicInteger money = null;
	public MoneyAdd(int id, AtomicInteger money)
	{
		super();
		this.id = id;
		this.money = money;
	}

	@Override
	public void run()
	{
		for (int i = 0; i < 5; i++)
		{
			int add = new Random().nextInt(100);
			int total = money.addAndGet(add);
			System.out.println("线程"+ id + " 增加了"+ add +"  当前有" + total + "原始：" + (total - add));
			
			try {
				Thread.sleep(1);
			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}
			
		}
	}
}