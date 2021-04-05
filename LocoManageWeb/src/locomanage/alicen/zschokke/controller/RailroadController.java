package locomanage.alicen.zschokke.controller;

import java.util.StringJoiner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import locomanage.alicen.zschokke.entities.Classification;
import locomanage.alicen.zschokke.entities.Railroad;
import locomanage.alicen.zschokke.service.RailroadService;

/**
 * Handles requests concerning railroad entities
 * @author Alicen Zschokke
 *
 */
@RestController
@CrossOrigin
@RequestMapping("/railroad")
public class RailroadController 
{
	private RailroadService railroadService; 
	
	/**
	 * Constructor
	 * @param railroadService
	 */
	@Autowired
	public RailroadController(RailroadService railroadService)
	{
		this.railroadService = railroadService; 
	}//end RailroadController()
	
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
	
	@PostMapping("/add/{name}")
	public void add(@PathVariable String name)
	{
		railroadService.add(new Railroad(name));
	}
	
	@GetMapping("/all")
	public String getAll()
	{
		return listToJSON(railroadService.getAll()); 
	}
	
	/*
	 * Converts an Iterable to a JSON array
	 */
	private static String listToJSON(Iterable<Railroad> list)
	{
		StringJoiner result = new StringJoiner(", ", "[", "]");
		
		for(Railroad r : list)
		{
			result = result.add(r.toJSON());
		}
		return result.toString(); 
	}//end listToJSON
}//end Railroad Controller
