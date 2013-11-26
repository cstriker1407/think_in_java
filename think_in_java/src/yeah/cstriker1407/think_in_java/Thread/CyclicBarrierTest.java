package yeah.cstriker1407.think_in_java.Thread;

import java.util.Random;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest
{
	public static void test()
	{
		final CyclicBarrier barrer = new CyclicBarrier(3, new Runnable()
		{
			@Override
			public void run()
			{
				System.out.println("The players have arrived pos");
			}
		});
		new Player(barrer, "player1").start();
		new Player(barrer, "player2").start();
		new Player(barrer, "player3").start();
	}

}
class Player extends Thread
{
	public Player(CyclicBarrier barrer, String name)
	{
		super();
		this.barrer = barrer;
		this.name = name;
	}
	private CyclicBarrier barrer;
	private String name;
	@Override
	public void run()
	{
		try
		{
			Thread.sleep(new Random().nextInt(5));
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		
		try
		{
			System.out.println("player:"+ name + " is Arriving Pos1");
			barrer.await();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		System.out.println("player:"+ name + " is go on");
		
		try
		{
			Thread.sleep(new Random().nextInt(5));
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		
		try
		{
			System.out.println("player:"+ name + " is Arriving Pos2");
			barrer.await();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		System.out.println("player:"+ name + " is finish");
	}
}