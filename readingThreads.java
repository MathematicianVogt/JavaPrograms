

import java.io.*;
import java.util.Scanner;
public class readingThreads implements Runnable
{
	private messageBox myBox;
	private String wordToFind;
	private String fileToRead;
	private Scanner fileReading;
	private File fileToBeRead;
	public readingThreads(messageBox myBox)
	{
		this.myBox=myBox;
		this.wordToFind=myBox.getWord();
		this.fileToRead=myBox.getFilename();
		this.create();


	}
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