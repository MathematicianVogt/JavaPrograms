//Ryan Vogt
//class imports
import java.io.*;
import java.util.*;


//Ryan Vogt
//Class Search
public class Search
{
	
	public Search()
	{

	}
	
	public static void main(String[] args)
	{	

		if(args.length<2)
		{

			System.out.println("Usage: Files to be searched or Words to be found in files have to be present at all times");


		}
		else if(args.length>2)
		{

			System.out.println("To many arugments providied, only list of files and list of words to be provided");

		}
		else
		{

			String[] allFiles=args[0].split(",");
			String[] allWords=args[1].split(",");
			ArrayList<messageBox> allBoxs = new ArrayList<messageBox>();
			for (int i=0; i<allFiles.length;i++)
			{
				for(int k=0; k<allWords.length; k++)
				{

					 allBoxs.add(new messageBox(allWords[k],allFiles[i]));



				}
			}
			Iterator a=allBoxs.iterator();
			while(a.hasNext())
			{

				messageBox currentBox=(messageBox) a.next();
				printingThreads currentThread = new printingThreads(currentBox);
				currentThread.run();

			}
			Iterator b = allBoxs.iterator();
			while(b.hasNext())
			{

				messageBox currentBox= (messageBox) b.next();
				readingThreads currentThread1 = new readingThreads(currentBox);
				currentThread1.run();

			}




		}
	

	}

}