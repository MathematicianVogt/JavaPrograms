import java.io.*;
import java.util.Scanner;
public class printingThreads
{

	messageBox myBox;
	String wordToFind;
	String fileToSearch;
	public printingThreads(messageBox myBox)
	{

			this.myBox=myBox;

	}

	public void run()
	{
		if(myBox.canSend())
		{

			myBox.printMessage();
			myBox.doneSending();


		}



	}




}