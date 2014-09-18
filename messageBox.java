public class messageBox
{

	String word;
	String fileName;
	Boolean readyToSend;
	public messageBox(String word,String fileName)
	{
		this.word=word;
		this.fileName=fileName;
		readyToSend=false;


	}
	public Boolean canSend()
	{
		return readyToSend;

	}

	public void readyToSend()
	{

		readyToSend=true;
	}
	public void doneSending()
	{

		readyToSend=false;

	}

	public String getWord()
	{
		return word;

	}
	public String getFilename()
	{

		return fileName;
	}
	public void printMessage()
	{
		System.out.println(word + " " + fileName);


	}
}