package locomanage.alicen.zschokke.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import locomanage.alicen.zschokke.service.UserService;

@Controller
@CrossOrigin
@RequestMapping("/user")
public class UserController 
{
	private UserService userService; 
	
	@Autowired
	public UserController(UserService userService)
	{
		this.userService = userService; 
	}
	
	@PostMapping("/add")
	public void addUser(@RequestBody String body)
	{
		System.out.println(body);
	}
	
	@GetMapping("/{id}")
	public String getUser(@PathVariable Integer id)
	{
		return this.userService.get(id).toJSON();
	}
}//end UserController
