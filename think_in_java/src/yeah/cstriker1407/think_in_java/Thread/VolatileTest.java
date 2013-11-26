package yeah.cstriker1407.think_in_java.Thread;


public class VolatileTest
{
	public static final Object lock = new Object();
	
	public static volatile int idx = 1;
	
	public static void test()
	{
		new VolatileThread().start();
		new VolatileThread().start();
		new VolatileThread().start();
		new VolatileThread().start();
		new VolatileThread().start();
		
		new SyncThread1().start();
		new SyncThread2().start();
	}
}
class VolatileThread extends Thread
{
	@Override
	public void run()
	{
		for (int i = 0; i < 5; i++)
		{
			System.out.println("idx:" + VolatileTest.idx++);
		}
	}
}

class SyncThread1 extends Thread
{
	@Override
	public void run()
	{
		for (int i = 0; i < 10; i++)
		{
			synchronized (VolatileTest.lock)
			{
				System.out.println("A pos");
				System.out.println("B pos");
			}
		}
	}
}

class SyncThread2 extends Thread
{
	@Override
	public void run()
	{
		for (int i = 0; i < 10; i++)
		{
			synchronized (VolatileTest.lock)
			{
				System.out.println("C pos");
				System.out.println("D pos");
			}
		}
	}
}



