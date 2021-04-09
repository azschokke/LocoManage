package locomanage.alicen.zschokke.exceptions;

/**
 * This exception is thrown if an empty name field is submitted. 
 * @author Alicen Zschokke
 *
 */
public class EmptyNameException extends Exception 
{
	private static final long serialVersionUID = 1L;

	/**
	 * Creates an EmptyNameException
	 */
	public EmptyNameException()
	{
		super("Name cannot be empty.");
	}
}//end EmptyNameException()
