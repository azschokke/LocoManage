package locomanage.alicen.zschokke.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import locomanage.alicen.zschokke.exceptions.InvalidPasswordException;

/**
 * This class models a user in the database. 
 * @author Alicen Zschokke
 *
 */
@Entity
public class User implements JSONable
{
	//unique id for the user 
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	//User's name
	@Column
	private String name; 
	//User's username
	@Column
	private String username; 
	//user's password
	@Column
	private String password; 
	//user's email
	@Column
	private String email; 
	
	/**
	 * Requisite no-arg constructor. 
	 */
	public User() {}
	
	/**
	 * Creates a new user. 
	 * @param name the user's name
	 * @param email the user's email
	 * @param username the user's username
	 * @param password the user's password
	 * @param confirmPassword the user's password entered a second time to ensure they match
	 */
	public User(String name, String email, String username, String password, String confirmPassword) throws Exception
	{
		this.setName(name);
		this.setEmail(email);
		this.setUsername(username);
		this.setPassword(password, confirmPassword);
	}//end User(name, email, username, password)

	/**
	 * @return the name
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 * @throws InvalidPasswordException 
	 */
	public void setPassword(String password, String confirmPassword) throws InvalidPasswordException
	{
		if(password == null || confirmPassword == null)
		{
			throw new InvalidPasswordException(); 
		}
		else if(password.length() == 0 || password.length() != confirmPassword.length())
		{
			throw new InvalidPasswordException(); 
		}
		else
		{
			this.password = password;
		}
	}//end setPassword()

	/**
	 * @return the email
	 */
	public String getEmail()
	{
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email)
	{
		//TODO regex email shit
		this.email = email;
	}

	/**
	 * @return the id
	 */
	public Integer getId()
	{
		return id;
	}
	
	public String toJSON()
	{
		return "{\"username\": " + this.getUsername() + "}";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	
	
	
}//end User
