//Ryan Vogt
public class printingThread implements Runnable
{
	//class variables
	private cubbieHole myHole;
	public printingThread(cubbieHole myHole)
	{


		this.myHole=myHole;

	}
	//run method which runs until both their is nothing futher to print and all files have been exausted in terms of reading.
	public void run()
	{	
			while(!myHole.listEmpty() || myHole.getFileCount()!=0)
			{
			
				if(myHole.canPrint())
				{


					myHole.beginPrinting();

				}

			}




	}




}