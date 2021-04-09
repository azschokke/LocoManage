package locomanage.alicen.zschokke.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	@Autowired
	public ManufacturerController(ManufacturerService manufacturerService)
	{
		this.manufacturerService = manufacturerService; 
	}
	
	/**
	 * Adds a manufacturer with the given name to the database. 
	 * @param name the name of the manufacturer to be added to the database
	 */
	@PostMapping("/add")
	public void addManufacturer(@RequestBody String body)
	{
		System.out.println(body);
		manufacturerService.add(new Manufacturer(body));
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
		return JSONUtilities.listToJson(manufacturerService.getAll());
	}
	
	/**
	 * Updates a manufacturer's name in the database
	 */
	@PostMapping("/update")
	public void updateManufacturer(@RequestBody String body)
	{
		this.manufacturerService.update(new Manufacturer(JSONUtilities.fromJson(body)));
	}
	
	/**
	 * Removes a manufacturer from the database. 
	 */
	@PostMapping("/delete")
	public void removeManufacturer(@RequestBody String body)
	{
		this.manufacturerService.remove(Integer.parseInt(body));
	}
}//end manufacturerService
