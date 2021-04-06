package locomanage.alicen.zschokke.controller;

import java.util.StringJoiner;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import locomanage.alicen.zschokke.entities.Manufacturer;
import locomanage.alicen.zschokke.json.JSONUtilities;
import locomanage.alicen.zschokke.service.ManufacturerService;

/**
 * Controller for handling requests regarding manufacturer entities. 
 * @author Alicen Zschokke
 *
 */
@CrossOrigin
@RestController
@RequestMapping("/manufacturer")
public class ManufacturerController 
{
	private ManufacturerService manufacturerService;
	
	/**
	 * Constructor
	 * @param manufacturerService
	 */
	public ManufacturerController(ManufacturerService manufacturerService)
	{
		this.manufacturerService = manufacturerService; 
	}
	
	/**
	 * Adds a manufacturer with the given name to the database. 
	 * @param name the name of the manufacturer to be added to the database
	 */
	@PostMapping("/add/{name}")
	public void addManufacturer(@PathVariable String name)
	{
		System.out.println(name);
		manufacturerService.add(new Manufacturer(name));
	}//end addManufacturer
	
	/**
	 * Retrieves the manufacturer with the given id from the database
	 * @param id the Integer id of the manufacturer to be retrieved
	 * @return a JSON object of the manufacturer with the matching id, or null if none exists
	 */
	@GetMapping("/{id}")
	public String getManufacturer(@PathVariable Integer id)
	{
		try
		{
			return manufacturerService.get(id).toJSON(); 
		}
		catch(NullPointerException n){}
		return "{}"; 
	}//end getManufacturer()
	
	/**
	 * Retrieves all manufacturers from the database
	 * @return a JSON object array of the manufacturers in the database
	 */
	@GetMapping("/all")
	public String getManufacturers()
	{
		return JSONUtilities.listToJSON(manufacturerService.getAll());
	}
	
}//end manufacturerService
