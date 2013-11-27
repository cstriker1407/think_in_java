package yeah.cstriker1407.think_in_java.Thread;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;


//http://www.java3z.com/cwbwebhome/article/article8/81261.html
class Producer implements Runnable
{
	private BlockingQueue<String> drop;
	List<String> messages = Arrays.asList("Mares eat oats", "Does eat oats", "Little lambs eat ivy", "Wouldn't you eat ivy too?");

	public Producer(BlockingQueue<String> d)
	{
		this.drop = d;
	}

	public void run()
	{
		try
		{
			for (String s : messages)
				drop.put(s);
			drop.put("DONE");
		}
		catch (InterruptedException intEx)
		{
			System.out.println("Interrupted! " + "Last one out, turn out the lights!");
		}
	}
}

class Consumer implements Runnable
{
	private BlockingQueue<String> drop;

	public Consumer(BlockingQueue<String> d)
	{
		this.drop = d;
	}

	public void run()
	{
		try
		{
			String msg = null;
			while (!((msg = drop.take()).equals("DONE")))
				System.out.println(msg);
		}
		catch (InterruptedException intEx)
		{
			System.out.println("Interrupted! " + "Last one out, turn out the lights!");
		}
	}
}

public class SynchronousQueueTest
{
	public static void test()
	{
		BlockingQueue<String> drop = new SynchronousQueue<String>();
		(new Thread(new Producer(drop))).start();
		(new Thread(new Consumer(drop))).start();
	}
}
