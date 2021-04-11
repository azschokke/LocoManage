package locomanage.alicen.zschokke.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import locomanage.alicen.zschokke.entities.User;
import locomanage.alicen.zschokke.json.JSONUtilities;
import locomanage.alicen.zschokke.service.UserService;

/**
 * Controller to handle requests concerning User entities.
 * @author Alicen Zschokke
 */
@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController 
{
	//userService object for db access
	private UserService userService; 
	
	/**
	 * Autowired controller
	 * @param userService
	 */
	@Autowired
	public UserController(UserService userService)
	{
		this.userService = userService; 
	}
	
	/**
	 * Adds a user to the database
	 * @param body the result of JSON.stringify() of the data in the form on the front end.
	 * @throws Exception 
	 */
	@PostMapping("/add")
	public String addUser(@RequestBody String body) throws Exception
	{
		try
		{
			HashMap<String, Object> userInfo = JSONUtilities.fromJson(body); 

			User newUser = new User(userInfo.get("name").toString(), userInfo.get("email").toString(), userInfo.get("username").toString(), userInfo.get("password").toString(), userInfo.get("confirmPassword").toString());
			userService.add(newUser);
			return "true";
		}
		catch(Exception e)
		{
			return "false"; 
		}
		
	}//end addUser
	
	/**
	 * Finds a specific user by id
	 * @param id the integer id of the user
	 * @return the user found
	 */
	@GetMapping("/{id}")
	public String getUser(@PathVariable Integer id)
	{
		try
		{
			return this.userService.get(id).toJSON();
		}
		catch(NullPointerException e)
		{
			return null; 
		}
	}//end getUser
	
	/**
	 * Handles user login
	 * @param body the result of JSON.stringify() of the data in the form on the front end.
	 * @param session The HTTP session
	 * @return A JSON object containing a single property "value" that contains true if the login was valid, otherwise false
	 */
	@PostMapping("/login")
	public String userLogIn(@RequestBody String body, HttpSession session)
	{
		try
		{
			HashMap<String, Object> userInfo = JSONUtilities.fromJson(body); 
			if(userService.validateUser(userInfo.get("username").toString(), userInfo.get("password").toString()))
			{
				return userService.get(userInfo.get("username").toString()).getId().toString();
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return new Boolean(false).toString(); 
	}//end userLogIn
	
}//end UserController
