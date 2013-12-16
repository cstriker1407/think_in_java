package yeah.cstriker1407.think_in_java.Thread.lock;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest
{
	public static void test()
	{
		ReentrantLock lock = new ReentrantLock();

		ReetThread t1 = new ReetThread(1,lock);
		ReetThread t2 = new ReetThread(2,lock);
		ReetThread t3 = new ReetThread(3,lock);
		
		t1.start();
		t2.start();
		t3.start();
	}

}
class ReetThread extends Thread
{
	int id;
	ReentrantLock lock;
	public ReetThread(int id, ReentrantLock lock)
	{
		super();
		this.id = id;
		this.lock = lock;
	}

	@Override
	public void run()
	{
		for (int i = 0; i < 5; i++)
		{
			lock.lock();
			
			System.out.println("before sleep :" + id);
			try
			{
				Thread.sleep(1000);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
			System.out.println("after sleep :" + id);
			
			lock.unlock();
		}
	}
}