package locomanage.alicen.zschokke.repositories;

/* IMPORTS */
import org.springframework.data.repository.CrudRepository;

import locomanage.alicen.zschokke.entities.User;

/**
 * UserRepository extends CrudRepository to handle database access for User objects with Integer primary key. 
 * @author Alicen Zschokke
 */
public interface UserRepository extends CrudRepository<User, Integer> 
{
	/**
	 * Finds a user by parameter id. 
	 * @param id the Integer id of the user to retrieve
	 * @return the User with the parameter id
	 */
	public User findUserById(Integer id);
	
	/**
	 * Finds a user by username.
	 * @param username the String username of the user to retrieve
	 * @return the User with the parameter username
	 */
	public User findByUsername(String username);
}//end UserRepository