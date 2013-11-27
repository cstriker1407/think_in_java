package yeah.cstriker1407.think_in_java.Thread;

//http://developer.51cto.com/art/201003/189465.htm
public class YieldTest
{
	public static void test()
	{
		TestThreadMethod t1 = new TestThreadMethod("t1");
		TestThreadMethod t2 = new TestThreadMethod("t2");
		t1.setPriority(Thread.MAX_PRIORITY);
		t2.setPriority(Thread.MIN_PRIORITY);
		t1.start();
		t2.start();
	}
}
class TestThreadMethod extends Thread
{
	public static int shareVar = 0;

	public TestThreadMethod(String name)
	{
		super(name);
	}

	public void run()
	{
		for (int i = 0; i < 4; i++)
		{
			System.out.print(Thread.currentThread().getName());
			System.out.println(" : " + i);
			// Thread.yield();　（1）
			/* （2） */
			try
			{
				Thread.sleep(3000);
			}
			catch (InterruptedException e)
			{
				System.out.println("Interrupted");
			}
		}
	}
}