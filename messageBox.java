public class messageBox
{
	//class variables
	private String word;
	private String fileName;
	private Boolean readyToSend;
	private Boolean notFinishedBox;
	//class constructor
	public messageBox(String word,String fileName)
	{
		this.word=word;
		this.fileName=fileName;
		readyToSend=false;
		notFinishedBox=true;


	}
	//tells if the file is finished being read
	//@return bool
	public synchronized Boolean getFinishedBox()
	{

		return notFinishedBox;

	}	
	//Reading of the main file is done
	public synchronized void finishedReading()
	{

		notFinishedBox=false;

	}
	//tells the printing thread if a message can be recived or not
	//@return bool
	public synchronized Boolean canSend()
	{
		return readyToSend;

	}
	//tells a printing thread that the message box is ready to print
	public synchronized void readyToSend()
	{

		readyToSend=true;
	}
	//notifies the printing thread it is done printing
	public synchronized void doneSending()
	{

		readyToSend=false;

	}
	//returns word field of object
	//@return word
	public synchronized String getWord()
	{
		return word;

	}
	//returns file name field of object
	//@return filename
	public synchronized String getFilename()
	{

		return fileName;
	}
	//toString of a messageBox
	public synchronized void printMessage()
	{
		System.out.println(word.toLowerCase() + " " + fileName);


	}
}