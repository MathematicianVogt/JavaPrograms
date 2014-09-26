//try rwd_grd project1-1 *.java mytest.txt
//Ryan Vogt
//class imports
import java.io.*;
import java.util.*;
import java.lang.*;


//Ryan Vogt
//Class Search
public class Search
{
	
	public Search()
	{

	}
	//builds a map from a cubbie list
	//@return a map representation of a word and its related cubbieHole
	public static Map<String,cubbieHole> buildMap(ArrayList<cubbieHole> myList)
	{

		Iterator b = myList.iterator();
		Map<String,cubbieHole> myMap = new HashMap<String,cubbieHole>();
		while(b.hasNext())
		{
				
			cubbieHole currentOne = (cubbieHole) b.next();
			myMap.put(currentOne.getWord(),currentOne);
		}

		return myMap;


	}
	//main method
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
			int fileSize=allFiles.length;
			String[] allWords=args[1].split(",");
			ArrayList<cubbieHole> myList = new ArrayList<cubbieHole>();
			for (int i=0; i<allWords.length;i++)
			{
				
				myList.add(new cubbieHole(allWords[i],new ArrayList<String>(),fileSize));


			}
			

			Iterator a=myList.iterator();
			while(a.hasNext())
			{

				printingThread currentThread = new printingThread((cubbieHole) a.next());
				Thread myThread = new Thread(currentThread);
				myThread.start();

			}
			

			
			

				for(int i =0; i<allFiles.length; i++)
				{
					
					Map<String,cubbieHole> myMap=buildMap(myList);
					readingThread currentThread1 = new readingThread(allFiles[i],myMap);
					Thread thisThread = new Thread(currentThread1);
					thisThread.start();
				}
			
			


		}
	

	}

}