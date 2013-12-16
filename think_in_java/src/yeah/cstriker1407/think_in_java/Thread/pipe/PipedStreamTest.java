package yeah.cstriker1407.think_in_java.Thread.pipe;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.Random;

//http://ifeve.com/pipe/ pipe

//http://www.cnblogs.com/king1302217/p/3158842.html
public class PipedStreamTest
{
	public static void test()
	{
        PipedOutputStream pos = new PipedOutputStream();
        PipedInputStream pis = new PipedInputStream();
        try 
        {
            pos.connect(pis);
        } catch (IOException e) 
        {
            e.printStackTrace();
        }
        PipedOutThread out = new PipedOutThread(pos);
        PipedInThread in = new PipedInThread(pis);
        out.start();
        in.start();
        
	}
}

class PipedOutThread extends Thread
{
	PipedOutputStream pos;

	public PipedOutThread(PipedOutputStream pos)
	{
		this.pos = pos;
	}

	@Override
	public void run()
	{
		for (int i = 0; i < 10; i++)
		{
			try
			{
				System.out.println("写入:" + i);
				pos.write(i);
			}
			catch (IOException e1)
			{
				e1.printStackTrace();
			}
			
			try
			{
				Thread.sleep(new Random().nextInt(100));
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}
}


class PipedInThread extends Thread
{
	PipedInputStream pin;

	public PipedInThread(PipedInputStream pin)
	{
		this.pin = pin;
	}

	@Override
	public void run()
	{
		for (int i = 0; i < 10; i++)
		{
			try
			{
				Thread.sleep(new Random().nextInt(100));
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
			
			try
			{
				int x = pin.read();
				System.out.println("读取:" + x);
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}
}
