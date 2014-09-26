import java.io.*;
import java.util.Scanner;
public class printingThreads implements Runnable
{
	//class methods
	private messageBox myBox;
	private String wordToFind;
	private String fileToSearch;
	public printingThreads(messageBox myBox)
	{

			this.myBox=myBox;

	}
	//run method to print out occurences of a found work in readThreads
	public void run()
	{	//System.out.println("RUNING NOW");
		
		while(myBox.getFinishedBox())
		{	
			
			

			//System.out.println("GOT HERE");
			//System.out.println("TRUTH VALUE " + myBox.canSend());
			if(myBox.canSend())
			{	
				//System.out.println("TRYING TO PRINT");

				myBox.printMessage();
				myBox.doneSending();
				break;


			}
		}


	}




}