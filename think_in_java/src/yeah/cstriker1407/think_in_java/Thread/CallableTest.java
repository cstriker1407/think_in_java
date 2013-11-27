package yeah.cstriker1407.think_in_java.Thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableTest
{
	public static void main(String[] args) throws ExecutionException, InterruptedException
	{
		// 创建一个线程池
		ExecutorService pool = Executors.newFixedThreadPool(2);
		// 创建两个有返回值的任务
		Callable<String> c1 = new MyCallable("A");
		Callable<String> c2 = new MyCallable("B");
		// 执行任务并获取Future对象
		Future<String> f1 = pool.submit(c1);
		Future<String> f2 = pool.submit(c2);
		// 从Future对象上获取任务的返回值，并输出到控制台
		System.out.println(">>>" + f1.get().toString());
		System.out.println(">>>" + f2.get().toString());
		// 关闭线程池
		pool.shutdown();
	}
}

class MyCallable implements Callable<String>
{
	private String oid;

	MyCallable(String oid)
	{
		this.oid = oid;
	}

	@Override
	public String call() throws Exception
	{
		return oid + "任务返回的内容";
	}
}