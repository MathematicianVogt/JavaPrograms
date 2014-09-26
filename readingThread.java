//Ryan Vogt

import java.io.*;
import java.util.Scanner;
import java.util.*;
public class readingThread implements Runnable
{	//class variables
	private String fileToRead;
	private Scanner fileReading;
	private Map<String,cubbieHole> wordAndfileList;
	//class constructor
	public readingThread(String fileName, Map <String, cubbieHole> wordAndfileList)
	{
		fileToRead=fileName;
		this.wordAndfileList=wordAndfileList;
		this.create();


	}
	//creates a reading the possibility for a file to be read
	public  synchronized  void create()
	{
			try
			{
				File f = new File(fileToRead);
				fileReading= new Scanner(f);

			}
			catch (Exception e)
			{

				System.out.println("Cant Find File Program will now exit");
				System.exit(0);

			}
	

	}

	//run method which reads a file and updates the cubbieHole object while reading to then
	//be printined by the printing thread
	public void run()
	{	cubbieHole currentFileList;
		ArrayList<String> deleteList=new ArrayList<String>();
		
		//System.out.println(wordAndfileList+ " 1");
		while(fileReading.hasNext())
		{

			Set<String> allTheKeys=wordAndfileList.keySet();
			Iterator goThroughKeys=allTheKeys.iterator();
			String line=fileReading.nextLine().toLowerCase();
			

			if(wordAndfileList.isEmpty())
			{

				break;

			}
			//System.out.println(allTheKeys);
			while(goThroughKeys.hasNext())
			{

				//System.out.println("Line " + line);

				//System.out.println(wordAndfileList + " 2");

				String currentKey = (String) goThroughKeys.next();
				//System.out.println(currentKey + "KEY");

				String lowerCurrentKey = currentKey.toLowerCase();
				//System.out.println(lowerCurrentKey + " KEY THEN LINE " +line);
				if(line.contains(lowerCurrentKey))
				{
					//System.out.println(lowerCurrentKey + " Found key");
					try
					{


						//System.out.println(line);
						//System.out.println(lowerCurrentKey + " "  +wordAndfileList);
						//System.out.println(lowerCurrentKey);
						//System.out.println(wordAndfileList.get(currentKey) + "HRE");
						currentFileList = wordAndfileList.get(currentKey);
						(currentFileList.getFileList()).add(fileToRead);
						deleteList.add(currentKey);

					}
					catch(NullPointerException e)
					{

						System.out.println("Problem");

					}


				}


			}
			Iterator myIt = deleteList.iterator();

			while(myIt.hasNext())
			{

				String currentString =  (String) myIt.next();
				wordAndfileList.get(currentString).fileDecrement();
				wordAndfileList.remove(currentString);


			}
			deleteList.clear();
			
				
			


		}
		Set<String> myKeys=wordAndfileList.keySet();
		Iterator myItr =myKeys.iterator();
		while(myItr.hasNext())
		{

			String currentString = (String) myItr.next();
			wordAndfileList.get(currentString).fileDecrement();


		}

		




	}
}