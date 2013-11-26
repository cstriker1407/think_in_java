package yeah.cstriker1407.think_in_java.Thread;

public class ThreadSample1
{
	public static void test()
	{
		new Sample1Thread().start();
		new Thread(new Sample1Runnable()).start();
		
		new Thread(new Runnable()
		{
			@Override
			public void run()
			{
				System.out.println(Thread.currentThread().getName());
				for (int i = 0; i < 10; i++)
				{
					try
					{
						Thread.sleep(1000);
					}
					catch (InterruptedException e)
					{
						e.printStackTrace();
					}
					System.out.println("this is from Runnable: " + i);
				}
			}
		},"this is thread name").start();
	}
}
class Sample1Thread extends Thread
{
	@Override
	public void run()
	{
		/*
		 * http://www.ibm.com/developerworks/cn/education/java/j-threads/section7.html
		 *线程优先级
Thread API 让您可以将执行优先级与每个线程关联起来。但是，这些优先级如何映射到底层操作系统调度程序取决于实现。在某些实现中，多个 ― 甚至全部 ― 优先级可能被映射成相同的底层操作系统优先级。
在遇到诸如死锁、资源匮乏或其它意外的调度特征问题时，许多人都想要调整线程优先级。但是，通常这样只会把问题移到别的地方。大多数程序应该完全避免更改线程优先级。 
		 */
		
		
		setPriority(Thread.MAX_PRIORITY - 1);
		
		System.out.println(this.getName());
		for (int i = 0; i < 10; i++)
		{
			try
			{
				Thread.sleep(1000);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
			System.out.println("this is from sample1thread: " + i);
		}
	}
}


class Sample1Runnable implements Runnable
{
	public void run()
	{
		for (int i = 0; i < 10; i++)
		{
			try
			{
				Thread.sleep(1000);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
			
			System.out.println("this is from Sample1Runnable: " + i);
		}
	}
}
