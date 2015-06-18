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
	//gets the word field of the cubbie hole
	//@return word the word that this cubbie hole is looking for
	public  synchronized String getWord()
	{

		return word;
	}
	//gets the fileList of the cubbiehole which is watched by the printing thread
	//@return fileList, the list of files where the word of this object is found
	public  synchronized ArrayList<String> getFileList()
	{

		return fileList;
	}

	//state of the cubbie hole to tell a print thread it is ready to print
	//@return if the cubbie is ready to print or not
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
	//if the cubie is reading to print, then print one by one
	public  synchronized void beginPrinting()
	{
		printMessage(word,fileList.get(0));
		fileList.remove(0);



	}
	//tells if the cubbie is empty
	public  synchronized Boolean listEmpty()
	{

		return fileList.isEmpty();

	}
	//the message of what a cubbie will share via a print thread.
	public static  synchronized void printMessage(String word,String specificFile)
	{
		System.out.println(word.toLowerCase() + " " + specificFile);


	}



}