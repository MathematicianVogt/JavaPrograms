

import java.io.*;
import java.util.Scanner;
public class readingThreads implements Runnable
{
	messageBox myBox;
	String wordToFind;
	String fileToRead;
	Scanner fileReading;
	File fileToBeRead;
	public readingThreads(messageBox myBox)
	{
		this.myBox=myBox;
		this.wordToFind=myBox.getWord();
		this.fileToRead=myBox.getFilename();
		this.create();


	}
	public void create()
	{
			try
			{
				File f = new File(fileToRead);
				fileReading= new Scanner(f);

			}
			catch (Exception e)
			{

				System.out.println("Cant Find File");

			}
	}
	public void run()
	{
		while(fileReading.hasNext())
		{

			String line=fileReading.nextLine();
			if(line.contains(wordToFind))
			{
				System.out.println("Found something");
				myBox.readyToSend();



			}


		}



	}





}