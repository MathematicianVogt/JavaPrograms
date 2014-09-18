//Ryan Vogt
//class imports
import java.io.*;
import java.util.Scanner;


//Class Search, this class implements Runnable, meaning objects can be ran concurrently
public class Search implements Runnable
{
	//class variables
	private File[] listOfFilesToSearch;
	private String[] wordsToLookForInEachFile;
	private File myFile;
	//Constructor
	//@param fileToSearch : the file to be searched for specific words.
	//@param listOfSearchWords : words pasted in each divided by comma, to be search for in files
	public Search(File fileToSearch,String listofSearchWords)
	{
		myFile=fileToSearch;
		wordsToLookForInEachFile=convertSearchWordsStringtoStringList(listofSearchWords);


	}

	//Class Method
	//Takes a list of words to search in string format divided by commas, returns each word in a slot
	//of an array
	//@param listofSearcWords : the words that are to be searched in each file
	//@return an array representation of the string, each word being in an element.
	private static String[] convertSearchWordsStringtoStringList(String listofSearchWords)
	{

		String[] resultList = listofSearchWords.split(",");
		for(int i=0; i<resultList.length;i++)
		{

			if(resultList[i].matches(".*[0-9].*"))
			{

				System.out.println("The word " + resultList[i] + " contains a number - program cannot continue");
				System.exit(0);
			}

		}
		return resultList;


	}
	//Class Method
	//Takes a list of files and converts them into an array of file objects to be read on the fly.
	//@param listOffiles : The files to be created into objects , divided by commas.
	//@return an array of file objects that represent each file, to be read later easily in this format
	//EXCEPTION CONDITION : If a file isnt found, continues on, just overlooking a file it cannot find 
	private static File[] convertFileStringtoFileList(String listOfFiles)
	{
		int nonNullCount=0;
		String[] fileNames = listOfFiles.split(",");
		File[] allFiles=new File[fileNames.length];
		for (int i = 0 ; i<fileNames.length; i++)
		{
			
			try
			{
				File f = new File(fileNames[i]);
				allFiles[i]=f;

			}
			catch (Exception e)
			{

				i=i-1;

			}
			


		}
		for (int i=0; i <fileNames.length; i++)
		{

			if(allFiles[i]!=null)
			{

				nonNullCount++;

			}


		}
		File[] allFiles1=new File[nonNullCount];

		for(int i=0; i<nonNullCount; i++)
		{

			allFiles1[i]=allFiles[i];


		}

		return allFiles1;

	}
	
	public void run()
	{	
		String[] myWordList=this.wordsToLookForInEachFile;
		Scanner in=null;
		
		try
		{
			in=new Scanner(myFile);
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Usage: File given " + myFile.getName() + " Not found, not included in search");
			System.exit(0);

		}
		while(in.hasNext())
		{

			String line=in.nextLine();
			for(int i=0;i<myWordList.length;i++)
			{

				if(myWordList[i]!=null && line.contains(myWordList[i]) )
				{

					System.out.println(myWordList[i].toLowerCase() + " " + myFile.getName());
					myWordList[i]=null;

				}


			}

		}



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

			File[] allFiles=convertFileStringtoFileList(args[0]);
			Search[] mySearches = new Search[allFiles.length];
			for (int i=0; i<allFiles.length;i++)
			{

				mySearches[i]= new Search(allFiles[i],args[1]);
				mySearches[i].run();

			}
			



		}
	

	}

}