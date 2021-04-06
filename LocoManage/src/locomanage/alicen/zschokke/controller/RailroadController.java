package locomanage.alicen.zschokke.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import locomanage.alicen.zschokke.entities.Railroad;
import locomanage.alicen.zschokke.json.JSONUtilities;
import locomanage.alicen.zschokke.service.RailroadService;

/**
 * Handles requests concerning railroad entities
 * @author Alicen Zschokke
 */
@RestController
@CrossOrigin
@RequestMapping("/railroad")
public class RailroadController 
{
	private RailroadService railroadService; 
	
	/**
	 * Autowired onstructor
	 * @param railroadService 
	 */
	@Autowired
	public RailroadController(RailroadService railroadService)
	{
		this.railroadService = railroadService; 
	}//end RailroadController()
	
	/**
	 * Finds a specific Railroad by id number
	 * @param id the integer id of the railroad
	 * @return a JSON representation of the railroad, or an empty JSON object if no match exists
	 */
	@GetMapping("/{id}")
	public String get(@PathVariable Integer id)
	{
		try
		{
			return railroadService.get(id).toJSON(); 
		}
		catch(NullPointerException e)
		{}
		return "{}";
	}
	
	/**
	 * Adds a new Railroad to the database
	 * @param name the String name of the new Railroad (Path Variable)
	 */
	@PostMapping("/add/{name}")
	public void add(@PathVariable String name)
	{
		railroadService.add(new Railroad(name));
	}
	
	/**
	 * Updates a Railroad with a new name.
	 * @param body the JSON payload from the front end
	 */
	@PostMapping("/update")
	public void update(@RequestBody String body)
	{
		HashMap<String, Object> requestBody = JSONUtilities.fromJSON(body);
		
	}
	
	/**
	 * Deletes a Railroad.
	 */
	@PostMapping("/delete")
	public void delete(@RequestBody String body)
	{
		
	}
	
	/**
	 * Returns all the railroads in the database
	 * @return a JSON array of all the railroads in the database 
	 */
	@GetMapping("/all")
	public String getAll()
	{
		return JSONUtilities.listToJSON(railroadService.getAll()); 
	}
	
}//end Railroad Controller
