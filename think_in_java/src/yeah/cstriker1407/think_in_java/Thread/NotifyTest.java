package yeah.cstriker1407.think_in_java.Thread;

import java.util.Random;

public class NotifyTest
{
	public static void test()
	{
		Object lock = new Object();
		new WaitThread(lock, "X").start();
		new WaitThread(lock, "Y").start();
		new WaitThread(lock, "Z").start();

		try
		{
			Thread.sleep(20);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		
		System.out.println("main thread begin to nofity");
		
		synchronized (lock)
		{
			lock.notifyAll();
		}
		System.out.println("main thread after notify");
	}
}
class WaitThread extends Thread
{
	private Object lock;
	private String name;
	
	public WaitThread(Object lock, String name)
	{
		super();
		this.lock = lock;
		this.name = name;
	}

	@Override
	public void run()
	{
		try
		{
			Thread.sleep(new Random().nextInt(4));
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		
		System.out.println("Thread:" + name +" begin to wait");
		synchronized (lock)
		{
			try
			{
				lock.wait();
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
		System.out.println("Thread:" + name +" finish");
	}
	
}