package yeah.cstriker1407.think_in_java.Thread;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class MyTimer1
{
	public static void test()
	{
		Timer t = new Timer();
		t.schedule(new MyTimeTask(), 500,1000);
		
		try
		{
			Thread.sleep(3000);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		
		t.cancel();
	}
}
class MyTimeTask extends TimerTask
{
	@Override
	public void run()
	{
		System.out.println("run:"+ new Date().toString());
	}
}
	
