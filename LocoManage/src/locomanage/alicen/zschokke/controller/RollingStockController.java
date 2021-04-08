package locomanage.alicen.zschokke.controller;

import java.util.HashMap;
import java.util.StringJoiner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import locomanage.alicen.zschokke.entities.Location;
import locomanage.alicen.zschokke.entities.Model;
import locomanage.alicen.zschokke.entities.Product;
import locomanage.alicen.zschokke.entities.Railroad;
import locomanage.alicen.zschokke.entities.RollingStock;
import locomanage.alicen.zschokke.json.JSONUtilities;
import locomanage.alicen.zschokke.service.ClassificationService;
import locomanage.alicen.zschokke.service.ManufacturerService;
import locomanage.alicen.zschokke.service.RailroadService;
import locomanage.alicen.zschokke.service.RollingStockService;
import locomanage.alicen.zschokke.service.ScaleService;

/**
 * Controller to handle requests concerning RollingStock entities.
 * @author Alicen Zschokke
 */
@RestController
@CrossOrigin
@RequestMapping("/rollingStock")
public class RollingStockController
{
	private RollingStockService rollingStockService; 
	private RailroadService railroadService;
	private ClassificationService classificationService; 
	private ManufacturerService manufacturerService; 
	private ScaleService scaleService; 
	
	/**
	 * Autowired constructor
	 * @param rollingStockService
	 * @param railroadService
	 * @param classificationService
	 * @param manufacturerService
	 * @param scaleService
	 */
	@Autowired
	public RollingStockController(RollingStockService rollingStockService, 
									RailroadService railroadService, 
									ClassificationService classificationService, 
									ManufacturerService manufacturerService, 
									ScaleService scaleService)
	{
		this.rollingStockService = rollingStockService; 
		this.railroadService = railroadService; 
		this.classificationService = classificationService; 
		this.manufacturerService = manufacturerService; 
		this.scaleService = scaleService; 
	}//end RollingStockController(services)
	
	/**
	 * Adds a RollingStock entity to the database.
	 * @param body the result of JSON.stringify() of the railroad object from a form on the front end
	 */
	@PostMapping("/add/{id}")
	public void addRollingStock(@RequestBody String body, @PathVariable String id)
	{
		HashMap requestBody = JSONUtilities.fromJSON(body);
		System.out.println(body);
		this.rollingStockService.add(new RollingStock(
				railroadService.get((int) Double.parseDouble(requestBody.get("railroad").toString())),
				((Double) requestBody.get("carNumber")).intValue(),
				((Double) requestBody.get("length")).intValue(),
				new Model(
						requestBody.get("model").toString(), 
						classificationService.get((int) Double.parseDouble(requestBody.get("classification").toString()))),
				new Product(
						manufacturerService.get((int) Double.parseDouble(requestBody.get("manufacturer").toString())), 
						scaleService.get((int) Double.parseDouble(requestBody.get("classification").toString())), 
						requestBody.get("sku").toString()),
				requestBody.get("notes").toString(),
				Integer.parseInt(id)
				));
	}//end addRollingStock
	
	/**
	 * Returns all the RollingStock items in the database
	 * @return a String representation of a JSON array of objects representing the RollingStock items
	 */
	@GetMapping("/all/{id}")
	public String getAll(@PathVariable String id)
	{
		String json = JSONUtilities.listToJSON(rollingStockService.getAll(Integer.parseInt(id)));
		System.out.println(json);
		return json; 
	}
	
	@GetMapping("/available/{id}")
	public String getAvailable(@PathVariable Integer id)
	{
		return JSONUtilities.listToJSON(rollingStockService.getAvailable(id));
	}
	
}//end RollingStockController
