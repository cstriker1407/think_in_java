package yeah.cstriker1407.beautycode;

import java.util.Random;

import org.hyperic.sigar.CpuPerc;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;

public class CPUTest
{
	static class RunThread extends Thread
	{
		int sleepHaomiao = 0;
		int sleepNamiao = 0;
		public void setSleepTime(int sleepHaomiao, int sleepNamiao)
		{
			this.sleepHaomiao = sleepHaomiao;
			this.sleepNamiao = sleepNamiao;
		}
		@Override
		public void run()
		{
			super.run();

			while (true)
			{
				for (int i = 0; i < 1000*1000*1000*1000; i++)
				{
					double random = new Random().nextInt(10000);
					random = Math.sqrt(random);
					random = Math.log10(random);
				}
				
				if (sleepNamiao >= 0)
				{
					try
					{
						Thread.sleep(sleepHaomiao, sleepNamiao);
					}
					catch (InterruptedException e)
					{
						e.printStackTrace();
					}
				}
			}
		}
	}
	
	
	public static void test()
	{
		double target = 0.4f;
		
		int cpuNums = getCpuNums();
		
		float maxSpeedPer = 1.0f/cpuNums;//线程满负荷时占用CPU比率。
		int numThread = (int) (target / maxSpeedPer);
		double chazhi = target - maxSpeedPer * (numThread - 1);
		numThread = numThread + 1;
		RunThread[] threadArr = new RunThread[numThread];
		
		for (int i = 0; i < numThread-1; i++)
		{
			threadArr[i] = new RunThread();
			threadArr[i].start();
		}
		
		
		
		threadArr[numThread-1] = new RunThread();
		threadArr[numThread-1].setPriority(Thread.MAX_PRIORITY);
		threadArr[numThread-1].setSleepTime(0,1);
		threadArr[numThread-1].start();
		
		while (true)
		{
			double percent = getCUPPercent();
			System.out.println("the CPU Usage:" + percent + "   target:" + target);
			try
			{
				Thread.sleep(500);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}

	
	private static double getCUPPercent()
	{
		double averageCPUPercent = 0f;
		Sigar sigar = new Sigar();
		CpuPerc cpuList[] = null;
		try
		{
			cpuList = sigar.getCpuPercList();
		}
		catch (SigarException e)
		{
			e.printStackTrace();
			return 1;
		}
		finally
		{
			sigar.close();
		}
		
		for (int i = 0; i < cpuList.length; i++)
		{
			averageCPUPercent += cpuList[i].getCombined();
		}
		int num = getCpuNums();
		if (0 == num)
		{
			return 1;
		}
		return averageCPUPercent / getCpuNums();
	}

	private static int getCpuNums()
	{
		Sigar sigar = new Sigar();
		try
		{
			return sigar.getCpuInfoList().length;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return 0;
		}
		finally
		{
			sigar.close();
		}
	}
}
