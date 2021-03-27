package locomanage.alicen.zschokke.dao;

import java.util.List;

/**
 * Database Access Object Interface
 * @author Alicen Zschokke
 *
 * @param <T> The class type extending this interface
 */
public interface DAO<T> 
{
	/**
	 * This method should add an object to the database.  
	 * @param t the object of type <T> to be added
	 */
	public void add(T t);
	
	/**
	 * This method retrieves an object with the matching unique id from the database. 
	 * @param id the unique id of the object
	 * @return an object of type <T> or null if no object matches
	 */
	public T get(int id);
	
	/**
	 * This method updates an object in the database. 
	 * @param t the object of type <T> with the matching id and new information to be updated
	 */
	public void update(T t);
	
	/**
	 * This method removes an object from the database.
	 * @param id the unique id of the object to be removed
	 */
	public void remove(int id);
	
	/**
	 * This method retrieves all the objects of type <T> from the database. 
	 * @return a List of objects of type <T>
	 */
	public List<T> getAll();	
}//end DAOI
