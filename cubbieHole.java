//Ryan Vogt
import java.util.*;
public class cubbieHole
{	//Class variables
	private String word;
	private ArrayList<String> fileList;
	private int fileCount;
	public cubbieHole(String word,ArrayList<String> fileList,int fileCount)
	{
		this.word=word;
		this.fileList=fileList;
		this.fileCount=fileCount;


	}
	//Gets the file count of the current cubbieHole
	//@return fileCount, the current number of files the cubbiehole is working on
	public synchronized int getFileCount()
	{
		
		return fileCount;

	}
	//decrements the state of this classes object field fileCount
	public synchronized void fileDecrement()
	{

		fileCount--;

	}


	//gets the size of the fileList of the object
	//@return the size of the fileList for this object
	public static  synchronized int numberOfNonNullEnteries(ArrayList<String> myFileList)
	{


		return myFileList.size();


	}
	public  synchronized String getWord()
	{

		return word;
	}
	public  synchronized ArrayList<String> getFileList()
	{

		return fileList;
	}
	public  synchronized Boolean canPrint()
	{
		if(numberOfNonNullEnteries(fileList)>0)
		{

			return true;

		}
		else
		{
			return false;

		}



	}
	public  synchronized void beginPrinting()
	{
		printMessage(word,fileList.get(0));
		fileList.remove(0);



	}
	public  synchronized Boolean listEmpty()
	{

		return fileList.isEmpty();

	}

	public static  synchronized void printMessage(String word,String specificFile)
	{
		System.out.println(word.toLowerCase() + " " + specificFile);


	}



}