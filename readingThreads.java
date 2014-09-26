

import java.io.*;
import java.util.Scanner;
public class readingThreads implements Runnable
{
	//class variables
	private messageBox myBox;
	private String wordToFind;
	private String fileToRead;
	private Scanner fileReading;
	private File fileToBeRead;
	//class constructor
	public readingThreads(messageBox myBox)
	{
		this.myBox=myBox;
		this.wordToFind=myBox.getWord();
		this.fileToRead=myBox.getFilename();
		this.create();


	}
	//syncronized method create
	//creates a scanner object in order to read a file
	public synchronized void create()
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
	//run method
	//runs continously to search through a file
	//if a word is found notifies the printingThread to print
	public void run()
	{
		while(fileReading.hasNext())
		{

			String line=fileReading.nextLine().toLowerCase();
			String myword=wordToFind.toLowerCase();
			//System.out.println("WORD TO FIND " + wordToFind +" FOUND IN " + line + " IS" +line.contains(myword) );
				
			if(line.contains(myword))
			{
				//System.out.println("READY TO PRINT THE WORD "  + myword  + " Found in the line" + line);
				
				myBox.readyToSend();
				//System.out.println(myBox.canSend());
				//System.out.println("Found");
				break;



			}


		}
		//System.out.println("k");
		myBox.finishedReading();
		//System.out.println("B: " +myBox.getFinishedBox());




	}





}