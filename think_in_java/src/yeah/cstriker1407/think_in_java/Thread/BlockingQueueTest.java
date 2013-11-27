package yeah.cstriker1407.think_in_java.Thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class BlockingQueueTest
{
	public static void test()
	{
		BlockingQueue<Integer> queue = new LinkedBlockingDeque<Integer>(10);
		BlockingQueueProducer p1 = new BlockingQueueProducer(queue, 1);

		BlockingQueueConsumer c1 = new BlockingQueueConsumer(queue, 1);
		BlockingQueueConsumer c2 = new BlockingQueueConsumer(queue, 2);
		
		p1.start();
		c1.start();
		c2.start();
	}
}

class BlockingQueueProducer extends Thread
{
	BlockingQueue<Integer> queue;
	int id;
	public BlockingQueueProducer(BlockingQueue<Integer> queue, int id)
	{
		super();
		this.queue = queue;
		this.id = id;
	}

	@Override
	public void run()
	{
		for (int i = 0; i < 100; i++)
		{
			try
			{
				System.out.println("线程ID:" + id + " 生产num:" + i);
				queue.put(i);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
			
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class BlockingQueueConsumer extends Thread
{
	BlockingQueue<Integer> queue;
	int id;

	public BlockingQueueConsumer(BlockingQueue<Integer> queue, int id)
	{
		super();
		this.queue = queue;
		this.id = id;
	}


	@Override
	public void run()
	{
		for (int i = 0; i <50; i++)
		{
			try
			{
				int num = queue.take();
				System.out.println("线程ID:" + id + " 得到的num:" + num);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}