package locomanage.alicen.zschokke.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import locomanage.alicen.zschokke.entities.Scale;
import locomanage.alicen.zschokke.json.JSONUtilities;
import locomanage.alicen.zschokke.service.ScaleService;

/**
 * Controller to handle requests concerning Scale entities. 
 * @author Alicen Zschokke
 *
 */
@CrossOrigin
@RestController
@RequestMapping("/scale")
public class ScaleController 
{
	//autowired service to handle db access
	private ScaleService scaleService; 
	
	/**
	 * Autowired constructors
	 * @param scaleService
	 */
	@Autowired
	public ScaleController(ScaleService scaleService)
	{
		this.scaleService = scaleService; 
	}
	
	/**
	 * Finds a specific scale in the database
	 * @param id the integer id of the scale
	 * @return a String representation of a JSON object representing the scale
	 */
	@GetMapping("/{id}")
	public String getScale(@PathVariable Integer id)
	{
		//TODO catch null
		return scaleService.get(id).toJSON(); 
	}
	
	/**
	 * Returns all the scales in the database
	 * @return a String representation of JSON array of scale objects
	 */
	@GetMapping("/all")
	public String getScales()
	{
		return JSONUtilities.listToJson(scaleService.getAll());
	}
	
	/**
	 * Adds a scale to the database.
	 * @param scale the name of the scale to be added (PathVariable)
	 */
	@PostMapping("/add/{scale}")
	public void addScale(@PathVariable String scale)
	{
		scaleService.add(new Scale(scale));
	}
	
}//end ScaleController
