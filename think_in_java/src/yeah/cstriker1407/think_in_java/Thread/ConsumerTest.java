package yeah.cstriker1407.think_in_java.Thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class ConsumerTest
{
	public static void test()
	{
		BlockingQueue<Integer> queue = new LinkedBlockingDeque<Integer>(10);
		ProducerX p1 = new ProducerX(queue, 1);
		ProducerX p2 = new ProducerX(queue, 2);
		ProducerX p3 = new ProducerX(queue, 3);

		ConsumerX c1 = new ConsumerX(queue, 1);
		ConsumerX c2 = new ConsumerX(queue, 2);
		ConsumerX c3 = new ConsumerX(queue, 3);
		
		p1.start();
		p2.start();
		p3.start();
		c1.start();
		c2.start();
		c3.start();
	}
}

class ProducerX extends Thread
{
	BlockingQueue<Integer> queue;
	int id;
	public ProducerX(BlockingQueue<Integer> queue, int id)
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
		}
	}
}




class ConsumerX extends Thread
{
	BlockingQueue<Integer> queue;
	int id;

	public ConsumerX(BlockingQueue<Integer> queue, int id)
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
				int num = queue.take();
				
				System.out.println("线程ID:" + id + " 得到的num:" + num);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}
}