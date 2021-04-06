package locomanage.alicen.zschokke.exceptions;

public class InvalidEmailException extends Exception
{
	private static final long serialVersionUID = 1L;

	public InvalidEmailException()
	{
		super("Email is invalid.");
	}
	
	public InvalidEmailException(String email)
	{
		super(String.format("Email '%s' is invalid.", email));
	}
}//end InvalidEmailException
