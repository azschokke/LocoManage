package locomanage.alicen.zschokke.exceptions;

public class DuplicateUserException extends Exception 
{
	private static final long serialVersionUID = 1L;

	public DuplicateUserException()
	{
		super("User with that username already exists in database.");
	}
	
	public DuplicateUserException(String username)
	{
		super(String.format("User with username \"%s\" already exists in database.", username));
	}
}//end DuplicateUserException
