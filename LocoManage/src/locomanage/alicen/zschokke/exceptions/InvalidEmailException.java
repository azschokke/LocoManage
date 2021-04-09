package locomanage.alicen.zschokke.exceptions;

/**
 * This exception is thrown if a user submits an invalid email address. 
 * @author Alicen Zschokke
 */
public class InvalidEmailException extends Exception
{
	private static final long serialVersionUID = 1L;

	/**
	 * Creates a generic InvalidEmailException.
	 */
	public InvalidEmailException()
	{
		super("Email is invalid.");
	}
	
	/**
	 * Creats an InvalidEmailException, specifying the email that caused the exception. 
	 * @param email the email that caused the exception. 
	 */
	public InvalidEmailException(String email)
	{
		super(String.format("Email '%s' is invalid.", email));
	}
}//end InvalidEmailException
