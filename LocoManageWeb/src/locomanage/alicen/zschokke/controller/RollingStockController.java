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
import locomanage.alicen.zschokke.entities.Model;
import locomanage.alicen.zschokke.entities.Product;
import locomanage.alicen.zschokke.entities.Railroad;
import locomanage.alicen.zschokke.entities.RollingStock;
import locomanage.alicen.zschokke.service.ClassificationService;
import locomanage.alicen.zschokke.service.ManufacturerService;
import locomanage.alicen.zschokke.service.RailroadService;
import locomanage.alicen.zschokke.service.RollingStockService;
import locomanage.alicen.zschokke.service.ScaleService;

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
	}
	
	@PostMapping("/add")
	public void addRollingStock(@RequestBody String body)
	{
		System.out.println(body);
		String[] input = body.split(","); 
		Railroad railroad = railroadService.get(Integer.parseInt(input[0].trim()));
		System.out.println("rr: " + railroad.toJSON());
		int carNumber = Integer.parseInt(input[1].trim());
		System.out.println("car num: " + carNumber);
		int length = Integer.parseInt(input[2].trim());
		System.out.println("length: " + length);
		Model model = new Model(input[3].trim(), classificationService.get(Integer.parseInt(input[5].trim())));
		System.out.println("model: " + model.toJSON());
		Product productInfo = new Product( manufacturerService.get(Integer.parseInt(input[7].trim())), scaleService.get(Integer.parseInt(input[4])), input[6].trim() );
		System.out.println("productinfo: " + productInfo.toJSON());
		rollingStockService.add(new RollingStock(railroad, carNumber, length, model, productInfo, input[8]));
	}//end addRollingStock
	
	@GetMapping("/all")
	public String getAll()
	{
		String json = listToJSON(rollingStockService.getAll());
		System.out.println(json);
		return json; 
	}
	
	/*
	 * Converts an Iterable<Location> to a JSON array the locations
	 */
	private static String listToJSON(Iterable<RollingStock> list)
	{
		StringJoiner result = new StringJoiner(", ", "[", "]");
		
		for(RollingStock l : list)
		{
			result.add(l.toJSON());
		}
		return result.toString(); 
	}//end listToJSON
}//end RollingStockController
