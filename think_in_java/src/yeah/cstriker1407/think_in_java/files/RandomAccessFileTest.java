package yeah.cstriker1407.think_in_java.files;

import java.io.RandomAccessFile;

public class RandomAccessFileTest
{
	private static final String fileName = "randomaccessfile.dat";
	
	public static void test()
	{
		writeFile();
		readFile();
	}
	
	public static void writeFile()
	{
		try
		{
			RandomAccessFile raf;
			raf = new RandomAccessFile(fileName, "rw");
			
			raf.writeInt(1);
			raf.writeFloat(10.0f);
			raf.writeDouble(20.0d);
			raf.writeChars("Hello World");
			raf.writeBoolean(true);
			raf.write(new byte[]{'A','B','C',10,20,0x30});
			
			raf.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public static void readFile()
	{
		try
		{
			RandomAccessFile raf;
			raf = new RandomAccessFile(fileName, "rw");
			
			int b = raf.readInt();
			float f = raf.readFloat();
			double d = raf.readDouble();
			byte[] readByte = new byte["Hello World".length() * 2];
			raf.read(readByte);
			String string = new String(readByte);
			boolean bl = raf.readBoolean();
			readByte = new byte[6];
			raf.read(readByte);

			raf.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
