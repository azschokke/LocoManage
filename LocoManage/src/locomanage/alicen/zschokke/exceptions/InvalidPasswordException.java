package locomanage.alicen.zschokke.exceptions;

public class InvalidPasswordException extends Exception 
{
	private static final long serialVersionUID = 1L;

	public InvalidPasswordException()
	{
		super("Password is invalid.");
	}
	 
	public InvalidPasswordException(String message)
	{
		super("Password is invalid: " + message);
	}
}//end InvalidPasswordException
