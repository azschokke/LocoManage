package locomanage.alicen.zschokke.controller;

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

@RestController
@CrossOrigin
@RequestMapping("/location")
public class LocationController 
{
	private LocationService locationService; 
	
	@Autowired
	public LocationController(LocationService locationService)
	{
		this.locationService = locationService; 
	}
	
	@PostMapping("/add")
	public void addLocation(@RequestBody String body)
	{
		String[] input = body.split(","); 
		String name = input[0].trim(); 
		System.out.println("Name: " + name);
		Boolean isTrack = new Boolean(input[2].trim());
		System.out.println("isTrack: " + isTrack);
		Integer parentId = Integer.parseInt(input[1].trim()); 
		Location parentLoc = ((parentId == -1) ? null : locationService.get(parentId));
		System.out.println(parentLoc);
		locationService.add(new Location(name, parentLoc, isTrack));
		
	}//end addLocation
	
	@GetMapping("/listNames")
	public String listNames()
	{
		return listToJSONNames(locationService.getAll());
	}
	
	@GetMapping("/getRoots")
	public String getRoots()
	{
		return listToJSON(locationService.getRoots()); 
	}
	
	
	/*
	 * Converts an Iterable<Location> to a JSON array of the names
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
	
	/*
	 * Converts an Iterable<Location> to a JSON array the locations
	 */
	private static String listToJSON(Iterable<Location> list)
	{
		StringJoiner result = new StringJoiner(", ", "[", "]");
		
		for(Location l : list)
		{
			result.add(l.toJSON());
		}
		return result.toString(); 
	}//end listToJSON
}//end LocationController
