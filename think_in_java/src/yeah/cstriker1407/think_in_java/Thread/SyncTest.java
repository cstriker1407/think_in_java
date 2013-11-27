package yeah.cstriker1407.think_in_java.Thread;

public class SyncTest
{
	private static SyncTest instance = new SyncTest();
	
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
					
					try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
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
					
					try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();	
	}
	
	public synchronized void funA()
	{
		System.out.println("A start");
		
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("A end");
	}
	
	public void funB()
	{
		synchronized (this)
		{
			System.out.println("B start");
			
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println("B end");
		}
	}
}
