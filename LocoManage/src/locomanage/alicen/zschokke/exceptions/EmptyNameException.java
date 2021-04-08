package locomanage.alicen.zschokke.exceptions;

public class EmptyNameException extends Exception 
{
	private static final long serialVersionUID = 1L;

	public EmptyNameException()
	{
		super("Name cannot be empty.");
	}
}//end EmptyNameException()
