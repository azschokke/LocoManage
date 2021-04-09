package locomanage.alicen.zschokke.service;

/* IMPORTS */
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import locomanage.alicen.zschokke.entities.User;
import locomanage.alicen.zschokke.exceptions.DuplicateUserException;
import locomanage.alicen.zschokke.repositories.UserRepository;

/**
 * Service for handling User entities. 
 * @author Alicen Zschokke
 */
@Service
public class UserService 
{
	//userRepository object for db access
	private UserRepository userRepository; 
	
	/**
	 * Autowired constructor
	 * @param userRepository
	 */
	@Autowired
	public UserService(UserRepository userRepository)
	{
		this.userRepository = userRepository; 
	}//end UserService(userRepository)
	
	/**
	 * Retrieves a user by unique Integer id
	 * @param id the unique Integer id of the User
	 * @return the User with the matching id, or null if none matches
	 */
	public User get(Integer id)
	{
		try
		{
			return this.userRepository.findById(id).get();
		}
		catch(NoSuchElementException e)
		{
			return null; 
		}
	}//end get(id)
	
	/**
	 * Retrieves a user by their unique username
	 * @param username the String username of the User
	 * @return the User with the matching username, or null if none exists
	 */
	public User get(String username)
	{
		try
		{
			return this.userRepository.findByUsername(username);
		}
		catch(NoSuchElementException e)
		{
			return null; 
		}
	}//end get(id)
	
	/**
	 * Adds a user to the database
	 * @param user the user to be added
	 * @throws DuplicateUserException if a user with the given username already exists
	 */
	public void add(User user) throws DuplicateUserException
	{
//		System.out.println(user);
		if(this.userRepository.findByUsername(user.getUsername()) == null)
		{
			this.userRepository.save(user);
		}
		else
		{
			throw new DuplicateUserException(user.getUsername());
		}
	}//end addUser(user)
	
	/**
	 * Updates a user in the database.
	 * @param user the user with the new information to be updated
	 */
	public void update(User user)
	{
		try
		{
			User found = this.userRepository.findById(user.getId()).get();
			found.setUsername(user.getUsername());
			found.setEmail(user.getEmail());
			found.setName(user.getName());
			found.setUsername(user.getUsername());
		}//end try
		catch(NoSuchElementException | NullPointerException e) {}
	}//end updateUser(user)
	
	/**
	 * Removes the user with the given unique id from the database.
	 * @param id the Integer id of the user to be removed
	 */
	public void removeUser(Integer id)
	{
		try
		{
			this.userRepository.delete(this.userRepository.findById(id).get());
		}
		catch(NoSuchElementException e){}
	}//end removeUser
	
	/**
	 * Validates a user's credentials.
	 * @param username the user's username
	 * @param password the user's password
	 * @return true if the login is valid, otherwise false
	 */
	public boolean validateUser(String username, String password)
	{
		User found = this.userRepository.findByUsername(username); 
		if(found.getPassword().equals(password))
		{
			return true; 
		}
		return false; 
	}//validateUser
	
}//end UserService
