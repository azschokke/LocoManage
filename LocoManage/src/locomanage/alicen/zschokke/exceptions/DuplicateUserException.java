package locomanage.alicen.zschokke.exceptions;

/**
 * This exception is for if a user attempts to create an account with a name that already exists.
 * @author Alicen Zschokke
 *
 */
public class DuplicateUserException extends Exception 
{
	private static final long serialVersionUID = 1L;

	/**
	 * Creates a generic DuplicateUserException
	 */
	public DuplicateUserException()
	{
		super("User with that username already exists in database.");
	}
	
	/**
	 * Creates a DuplicateUserException specifying the username that caused the exception.
	 * @param username the username that caused the exception
	 */
	public DuplicateUserException(String username)
	{
		super(String.format("User with username \"%s\" already exists in database.", username));
	}
}//end DuplicateUserException
