package yeah.cstriker1407.think_in_java.Thread;

//http://blog.csdn.net/sd0902/article/details/8395677线程池
//http://www.cnblogs.com/charley_yang/archive/2010/10/22/1857926.html若饮用
import java.util.concurrent.Semaphore;

public class SemaphoreTest
{
	public static void test()
	{
		Semaphore sp = new Semaphore(3);
		
		new SemaphoreThread(sp, 1).start();
		new SemaphoreThread(sp, 2).start();
		new SemaphoreThread(sp, 3).start();
		new SemaphoreThread(sp, 4).start();
		new SemaphoreThread(sp, 5).start();
	}
}

class SemaphoreThread extends Thread
{
	private Semaphore sp;
	private int id;
	public SemaphoreThread(Semaphore sp, int id)
	{
		super();
		this.sp = sp;
		this.id = id;
	}
	@Override
	public void run()
	{
		try
		{
			Thread.sleep(id * 100);
			
			System.out.println("线程"+ id +"申请一个信号量");
			sp.acquire();
			
			Thread.sleep(1000);
			
			System.out.println("线程"+ id +"获取了一个信号量");
		}
		catch (InterruptedException e)
		{
		}finally
		{
			sp.release();
			System.out.println("线程"+ id +"释放了一个信号量");
		}
	}
}

