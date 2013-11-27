package yeah.cstriker1407.think_in_java.Thread;

import java.util.LinkedList;

public class WaitTest
{
	public static void test()
	{
		LinkedList<Integer> list = new LinkedList<Integer>();
		ProduceWait p = new ProduceWait(1, list);
		ConsumerWait c1 = new ConsumerWait(1, list);
		ConsumerWait c2 = new ConsumerWait(2, list);
		
		p.start();
		c1.start();
		c2.start();
	}
}

class ProduceWait extends Thread
{
	private int id;
	private LinkedList<Integer> list;

	public ProduceWait(int id, LinkedList<Integer> list)
	{
		super();
		this.id = id;
		this.list = list;
	}

	@Override
	public void run()
	{
		for (int i = 0; i < 100; i++)
		{
			synchronized (list)
			{
				if (list.size() != 10)
				{
					list.offer(i);
					System.out.println("线程" + id + " 放入了"+ i);
					list.notifyAll();
				}
				else
				{
					try
					{
						list.wait();
					}
					catch (InterruptedException e)
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}
}


class ConsumerWait extends Thread
{
	private int id;
	private LinkedList<Integer> list;

	public ConsumerWait(int id, LinkedList<Integer> list)
	{
		super();
		this.id = id;
		this.list = list;
	}

	@Override
	public void run()
	{
		for (int i = 0; i < 50; i++)
		{
			synchronized (list)
			{
				if (list.size() == 0)
				{
					try
					{
						list.wait();
					}
					catch (InterruptedException e)
					{
						e.printStackTrace();
					}
				}else
				{
					int x = list.poll();
					System.out.println("线程" + id + " 获取了"+ x);
					list.notifyAll();
				}
			}
		}
	}
}