package locomanage.alicen.zschokke.dao;

import java.util.List;

/**
 * Database Access Object Interface
 * @author Alicen Zschokke
 *
 * @param <T> The class type extending this interface
 */
public interface DAOI<T> 
{
	//TODO do i need javadoc comments?
	public void add(T t);
	public T get(int id);
	public void update(T t);
	public void remove(int id);
	public List<T> getAll();	
}//end DAOI
