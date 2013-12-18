package yeah.cstriker1407.think_in_java.Thread;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest
{
	public static void test()
	{
		CountDownLatch startSignal = new CountDownLatch(1);
		CountDownLatch doneSignal = new CountDownLatch(3);

		for (int i = 0; i < 3; ++i)
		{
			new Thread(new Worker(startSignal, doneSignal)).start();
		}

		try
		{
			Thread.sleep(1000);
		}
		catch (InterruptedException e1)
		{
			e1.printStackTrace();
		}
		System.out.println("the runnables are inited");
		System.out.println("the runnables are free to start");
		startSignal.countDown();
		
		try
		{
			doneSignal.await();
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		} 
	}
}

class Worker implements Runnable
{
	private static int count = 0;
	private int idx = 0;
	private final CountDownLatch startSignal;
	private final CountDownLatch doneSignal;

	Worker(CountDownLatch startSignal, CountDownLatch doneSignal)
	{
		this.startSignal = startSignal;
		this.doneSignal = doneSignal;
		idx = count++;
	}

	public void run()
	{
		try
		{
			System.out.println("the runnable is begin to init:" + idx);
			startSignal.await();
			System.out.println("the runnable is begin to start:" + idx);
			Thread.sleep(2000);

			doneSignal.countDown();
			System.out.println("the runnable is finish:" + idx);
		}
		catch (InterruptedException ex)
		{
		} // return;
	}
}
