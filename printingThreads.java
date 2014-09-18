import java.io.*;
import java.util.Scanner;
public class printingThreads implements Runnable
{

	messageBox myBox;
	String wordToFind;
	String fileToSearch;
	public printingThreads(messageBox myBox)
	{

			this.myBox=myBox;

	}

	public void run()
	{	System.out.println("RUNING NOW");
		if(myBox.canSend())
		{	
			System.out.println("TRYING TO PRINT");

			myBox.printMessage();
			myBox.doneSending();


		}



	}




}