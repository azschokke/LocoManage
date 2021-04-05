package locomanage.alicen.zschokke.service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import locomanage.alicen.zschokke.entities.User;
import locomanage.alicen.zschokke.repositories.UserRepository;

@Service
public class UserService 
{
	private UserRepository userRepository; 
	
	@Autowired
	public UserService(UserRepository userRepository)
	{
		this.userRepository = userRepository; 
	}//end UserService(userRepository)
	
	
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
	
	//add user
	public void add(User user)
	{
		this.userRepository.save(user);
	}//end addUser(user)
	
	//update user
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
	
	//remove user
	public void removeUser(Integer id)
	{
		try
		{
			this.userRepository.delete(this.userRepository.findById(id).get());
		}
		catch(NoSuchElementException e){}
	}//end removeUser
	
	//validate user
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
