package yeah.cstriker1407.think_in_java.ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ThreadPoolTest1
{
	public static void  test1()
	{
		ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
		for (int i = 0; i < 10; i++) {
			final int index = i;
			try {
				Thread.sleep(index * 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			cachedThreadPool.execute(new Runnable() {

				@Override
				public void run() {
					System.out.println(index);
				}
			});
		}
	}
	
	public static void  test2()
	{
		ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
		for (int i = 0; i < 10; i++) {
		    final int index = i;
		    fixedThreadPool.execute(new Runnable() {
		 
		        @Override
		        public void run() {
		            try {
		                System.out.println(index);
		                Thread.sleep(2000);
		            } catch (InterruptedException e) {
		                // TODO Auto-generated catch block
		                e.printStackTrace();
		            }
		        }
		    });
		}
	}
	
	public static void  test3()
	{
		ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
		scheduledThreadPool.schedule(new Runnable() {
		 
		    @Override
		    public void run() {
		        System.out.println("delay 3 seconds");
		    }
		}, 3, TimeUnit.SECONDS);
		
	}
	
	public static void  test4()
	{
		ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
		scheduledThreadPool.scheduleAtFixedRate(new Runnable() {
		    @Override
		    public void run() {
		        System.out.println("delay 1 seconds, and excute every 3 seconds");
		    }
		}, 1, 3, TimeUnit.SECONDS);
	}
	
	public static void  test5()
	{
		ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
		for (int i = 0; i < 10; i++) {
		    final int index = i;
		    singleThreadExecutor.execute(new Runnable() {
		 
		        @Override
		        public void run() {
		            try {
		                System.out.println(index);
		                Thread.sleep(2000);
		            } catch (InterruptedException e) {
		                // TODO Auto-generated catch block
		                e.printStackTrace();
		            }
		        }
		    });
		}
		
		
	}
	
	
	
}