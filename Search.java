//Ryan Vogt
//class imports
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

//Ryan Vogt
//Class Search
public class Search
{
	

	
	public static void main(String[] args)
	{	

		System.out.println("Hi");
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
					 System.out.println(allWords[k]);
					 System.out.println(allFiles[i]);



				}



			}




		}
	

	}

}