package locomanage.alicen.zschokke.exceptions;

/**
 * This exception is thrown if a user submits an invalid password. 
 * @author Alicen Zschokke
 */
public class InvalidPasswordException extends Exception 
{
	private static final long serialVersionUID = 1L;

	/**
	 * Creates a generic InvalidPasswordException
	 */
	public InvalidPasswordException()
	{
		super("Password is invalid.");
	}
	 
	/**
	 * Creates an InvalidPasswordException with an optional message specifying the constraint violated. 
	 * @param message the message. 
	 */
	public InvalidPasswordException(String message)
	{
		super("Password is invalid. " + message);
	}
}//end InvalidPasswordException
