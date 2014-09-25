public class messageBox
{

	private String word;
	private String fileName;
	private Boolean readyToSend;
	private Boolean notFinishedBox;
	public messageBox(String word,String fileName)
	{
		this.word=word;
		this.fileName=fileName;
		readyToSend=false;
		notFinishedBox=true;


	}
	public synchronized Boolean getFinishedBox()
	{

		return notFinishedBox;

	}	
	public synchronized void finishedReading()
	{

		notFinishedBox=false;

	}
	public synchronized Boolean canSend()
	{
		return readyToSend;

	}

	public synchronized void readyToSend()
	{

		readyToSend=true;
	}
	public synchronized void doneSending()
	{

		readyToSend=false;

	}

	public synchronized String getWord()
	{
		return word;

	}
	public synchronized String getFilename()
	{

		return fileName;
	}
	public synchronized void printMessage()
	{
		System.out.println(word.toLowerCase() + " " + fileName);


	}
}