package yeah.cstriker1407.think_in_java.Thread;

public class SyncTest2
{
	private static SyncTest2 instance = new SyncTest2();
	
	
	public static void test()
	{
		new Thread(new Runnable()
		{
			@Override
			public void run()
			{
				for (int i = 0; i < 5; i++)
				{
					instance.funA();
				}
			}
		}).start();
		
		new Thread(new Runnable()
		{
			@Override
			public void run()
			{
				for (int i = 0; i < 5; i++)
				{
					instance.funB();
				}
			}
		}).start();	
		
		
		
	}
	
	
	
	
	
	
	public synchronized void funA()
	{
		System.out.println("A pos");
		System.out.println("B pos");
	}
	
	public void funB()
	{
		synchronized (this)
		{
			System.out.println("C pos");
			System.out.println("D pos");
		}
	}
}
