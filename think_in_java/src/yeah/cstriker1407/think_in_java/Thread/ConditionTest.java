package yeah.cstriker1407.think_in_java.Thread;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionTest
{
	public static void test()
	{
		LinkedList<Integer> list = new LinkedList<Integer>();
		Lock lock = new ReentrantLock();//锁对象  
		Condition inCond = lock.newCondition();
		Condition outCond = lock.newCondition();

		ConditionProducer p1 = new ConditionProducer(0, lock, inCond, outCond, list);
		
		ConditionConsumer c1 = new ConditionConsumer(0, lock, inCond, outCond, list);
		ConditionConsumer c2 = new ConditionConsumer(1, lock, inCond, outCond, list);
		
		p1.start();
		c1.start();
		c2.start();
	}
}
class ConditionProducer extends Thread
{
	private int id;
	private Lock lock;
	private Condition inCond;
	private Condition outCond;
	private LinkedList<Integer> list;
	
	public ConditionProducer(int id, Lock lock, Condition inCond, Condition outCond, LinkedList<Integer> list)
	{
		super();
		this.id = id;
		this.lock = lock;
		this.inCond = inCond;
		this.outCond = outCond;
		this.list = list;
	}

	@Override
	public void run()
	{
		for (int i = 0; i < 100; i++)
		{
			lock.lock();
			while(list.size() == 10)
			{
				System.out.println("list is full,begin to await");
				try
				{
					inCond.await();//与此 Condition 相关的锁以原子方式释放，并且出于线程调度的目的，将禁用当前线程，
				}
				catch (InterruptedException e)
				{
					e.printStackTrace();
				}
			}
			System.out.println("list begin to produce");
			
			list.offer(i);
			System.out.println("线程" + id + " 放入了"+ i);

			outCond.signalAll();
			
			lock.unlock();
			
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class ConditionConsumer extends Thread
{
	private int id;
	private Lock lock;
	private Condition inCond;
	private Condition outCond;
	private LinkedList<Integer> list;
	
	public ConditionConsumer(int id, Lock lock, Condition inCond, Condition outCond, LinkedList<Integer> list)
	{
		super();
		this.id = id;
		this.lock = lock;
		this.inCond = inCond;
		this.outCond = outCond;
		this.list = list;
	}

	@Override
	public void run()
	{
		for (int i = 0; i < 50; i++)
		{
			lock.lock();
			while(list.size() == 0)
			{
				System.out.println("线程" + id + "  list is empty,begin to await");
				try
				{
					outCond.await();
				}
				catch (InterruptedException e)
				{
					e.printStackTrace();
				}
			}
			System.out.println("线程" + id + "  list begin to consume");
			
			int x = list.poll();
			System.out.println("线程" + id + " 获取了"+ x);
			inCond.signalAll();
			
			lock.unlock();
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
