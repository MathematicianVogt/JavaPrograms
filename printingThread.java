public class printingThread implements Runnable
{

	private cubbieHole myHole;
	public printingThread(cubbieHole myHole)
	{


		this.myHole=myHole;

	}
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