package yeah.cstriker1407.think_in_java.Thread;

public class ThreadSample2
{
	public static void test()
	{
		Sample2Thread thread = new Sample2Thread();
		thread.start();
		try
		{
			Thread.sleep(1500);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		System.out.println("the Main is begin to interrupt");
		thread.interrupt();
		System.out.println("the Main is finish");
	}
	public static void test2()
	{
		Sample2Thread thread = new Sample2Thread();
		thread.start();
		try
		{
			Thread.sleep(1500);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		System.out.println("the Main is begin to join");
		try
		{
			thread.join();
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		System.out.println("the Main is finih");
	}
}
class Sample2Thread extends Thread
{
	@Override
	public void run()
	{
		System.out.println("the Sample2Thread is begin to start");

		try
		{
			Thread.sleep(5000);
		}
		catch (InterruptedException e)
		{
			System.out.println("the Sample2Thread is interrupted");
		}finally
		{
			System.out.println("the Sample2Thread is finish");
		}
	}
}