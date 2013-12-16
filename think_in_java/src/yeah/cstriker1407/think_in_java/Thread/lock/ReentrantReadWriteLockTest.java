package yeah.cstriker1407.think_in_java.Thread.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;


public class ReentrantReadWriteLockTest
{
	public static void test()
	{
		Bean bean = new Bean();
		bean.x = 0;
		ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
		WriteThread w1 = new WriteThread(0, bean, lock.writeLock());
		ReadThread r1 = new ReadThread(1, bean, lock.readLock());
		ReadThread r2 = new ReadThread(2, bean, lock.readLock());
		ReadThread r3 = new ReadThread(3, bean, lock.readLock());
		
		w1.start();
		r1.start();
		r2.start();
		r3.start();
	}
}



class Bean
{
	public int x;
	
}
class WriteThread extends Thread
{
	int id;
	Bean bean;
	Lock lock;

	public WriteThread(int id, Bean bean, Lock lock)
	{
		super();
		this.id = id;
		this.bean = bean;
		this.lock = lock;
	}


	@Override
	public void run()
	{
		for (int i = 0; i < 10; i++)
		{
			lock.lock();
			
			System.out.println("write before sleep :" + id);
			try
			{
				Thread.sleep(1000);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
			bean.x = i;
			System.out.println("Read value :" + bean.x);
			
			System.out.println("write after sleep :" + id);
			
			lock.unlock();
		}
	}
}


class ReadThread extends Thread
{
	int id;
	Bean bean;
	Lock lock;
	
	public ReadThread(int id, Bean bean, Lock lock)
	{
		super();
		this.id = id;
		this.bean = bean;
		this.lock = lock;
	}

	@Override
	public void run()
	{
		for (int i = 0; i < 10; i++)
		{
			lock.lock();
			
			System.out.println("Read before sleep :" + id);
			try
			{
				Thread.sleep(1000);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
			System.out.println("Read value :" + bean.x);
			
			System.out.println("Read after sleep :" + id);
			
			lock.unlock();
		}
	}
}
