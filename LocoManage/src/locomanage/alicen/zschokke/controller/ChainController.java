package locomanage.alicen.zschokke.controller;

/*IMPORTS */
import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import locomanage.alicen.zschokke.entities.Chain;
import locomanage.alicen.zschokke.entities.Location;
import locomanage.alicen.zschokke.entities.RollingStock;
import locomanage.alicen.zschokke.json.JSONUtilities;
import locomanage.alicen.zschokke.service.ChainService;
import locomanage.alicen.zschokke.service.LocationService;
import locomanage.alicen.zschokke.service.RollingStockService;

/**
 * Controller for handling requests concerning Chain entities. 
 * @author Alicen Zschokke
 */
@CrossOrigin
@RestController
@RequestMapping("/chain")
public class ChainController 
{
	//chain service
	private ChainService chainService;
	//rollingStock service
	private RollingStockService rollingStockService; 
	private LocationService locationService; 
	
	/**
	 * Autowired constructor
	 * @param chainService
	 * @param rollingStockService
	 */
	@Autowired
	public ChainController(ChainService chainService, RollingStockService rollingStockService, LocationService locationService)
	{
		this.chainService = chainService; 
		this.rollingStockService = rollingStockService; 
		this.locationService = locationService; 
	}//end ChainController(chainService, rollingStockService)
	
	/**
	 * Handles adding a Chain to the database
	 * @param body the body of the request
	 * @param id the id of the user adding the chain
	 */
	@PostMapping("/add/{id}")
	public void add(@RequestBody String body, @PathVariable Integer id)
	{
		System.out.println("addChain");
		System.out.println(body);
		HashMap<String, Object> requestBody = JSONUtilities.fromJson(body);
		System.out.println(requestBody);
		Chain chain = new Chain(requestBody.get("name").toString());
		chain.setUserId(id);
		Location location = locationService.get( (int) Double.parseDouble(requestBody.get("location").toString()));
		chain.setLocation(location);
		ArrayList<String> numbers = (ArrayList<String>) requestBody.get("cars");
		for(String n : numbers)
		{
			RollingStock rs = this.rollingStockService.get(Integer.parseInt(n));
//			System.out.println(rs);
			chain.addRollingStock(rs);
		}//end for
		chain = this.chainService.add(chain);
		for(String n : numbers)
		{
			RollingStock rs = this.rollingStockService.get(Integer.parseInt(n));
			rs.setInChain(chain.getId());
			System.out.println(rs.getInChain());
			this.rollingStockService.update(rs);
		}//end for 
		
	}//end add()
	
	/**
	 * Handles retrieving all chains for a user from the database
	 * @param id the user to retrieve chains for
	 * @return a Json array as a String containing all the chains for the user
	 */
	@GetMapping("/all/{id}")
	public String getAll(@PathVariable Integer id)
	{
		return JSONUtilities.listToJson(this.chainService.getAll(id));
	}
	
	/**
	 * Retrieves the chains located on a specific track
	 * @param tId the track id 
	 * @return A Json array as a String 
	 */
	@GetMapping("/byTrack/{tId}")
	public String getByTrack( @PathVariable Integer tId)
	{
		return JSONUtilities.listToJson(this.chainService.getByTrack(tId));
	}
}//end ChainController
