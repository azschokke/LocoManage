package locomanage.alicen.zschokke.controller;

import java.util.HashMap;
import java.util.StringJoiner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import locomanage.alicen.zschokke.entities.Location;
import locomanage.alicen.zschokke.service.LocationService;
import locomanage.alicen.zschokke.json.JSONUtilities;

/**
 * Controller for requests concerning Location entities. 
 * @author Alicen Zschokke
 *
 */
@RestController
@CrossOrigin
@RequestMapping("/location")
public class LocationController 
{
	//LocationService object used to access database
	private LocationService locationService; 
	
	/**
	 * Constructor
	 * @param locationService autowired
	 */
	@Autowired
	public LocationController(LocationService locationService)
	{
		this.locationService = locationService; 
	}
	
	/**
	 * Adds a Location with the parameter information to the database. 
	 * @param body the post request body - a JSON object
	 */
	@PostMapping("/add")
	public void addLocation(@RequestBody String body)
	{
		System.out.println(body);
		HashMap requestBody = JSONUtilities.fromJSON(body);
		String name = requestBody.get("name").toString();
		Integer parent = (int) Double.parseDouble(requestBody.get("parent").toString());
		boolean isTrack = new Boolean(requestBody.get("isTrack").toString());
		locationService.add(new Location(name, parent, isTrack));
	}//end addLocation
	
	/**
	 * Returns all the locations in the database.
	 * @return a JSON array of all the locations in the database as JSON objects
	 */
	@GetMapping("/listNames")
	public String listNames()
	{
		return listToJSONNames(locationService.getAll());
	}
	
	/**
	 * Returns all the root locations (locations without a parent) in the database. 
	 * @return A JSON array of all the root locations in the database as JSON objects
	 */
	@GetMapping("/getRoots")
	public String getRoots()
	{
		return JSONUtilities.listToJSON(locationService.getRoots()); 
	}
	
	/*
	 * Converts an Iterable<Location> to a JSON array of location objects containing only names and ids
	 */
	private static String listToJSONNames(Iterable<Location> list)
	{
		StringJoiner result = new StringJoiner(", ", "[", "]");
		
		for(Location l : list)
		{
			result = result.add("{\"id\": " + l.getId() + ",\"name\":\"" + l.getName() + "\"}");
		}
		return result.toString(); 
	}//end listToJSON
	
}//end LocationController
