package locomanage.alicen.zschokke.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import locomanage.alicen.zschokke.entities.Classification;
import locomanage.alicen.zschokke.entities.Manufacturer;
import locomanage.alicen.zschokke.entities.Model;
import locomanage.alicen.zschokke.entities.Product;
import locomanage.alicen.zschokke.entities.Railroad;
import locomanage.alicen.zschokke.entities.Scale;
import locomanage.alicen.zschokke.service.ClassificationService;

import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class RestfulController 
{
	private ClassificationService classificationService; 
	
	@Autowired
	public RestfulController(ClassificationService classificationService)
	{
		this.classificationService = classificationService; 
	}
	@GetMapping("/JSON")
	public String showIndex()
	{
		return "index"; 
	}
	
	@GetMapping("/classificationJSON")
	public String classification(@RequestParam(value="name", defaultValue="World") String name, org.springframework.ui.Model model)
	{
		classificationService.saveUser(new Classification("locomotive"));
		return new Classification("locomotive").toJSON();
	}
	
	@GetMapping("/manufacturerJSON")
	public String manufacturer()
	{
		return new Manufacturer("Rapido").toJSON(); 
	}
	
	@GetMapping("/modelJSON")
	public String classification()
	{
		return new Model("F40HP", new Classification("locomotive")).toJSON(); 
	}
	
	@GetMapping("/productJSON")
	public String product()
	{
		return new Product(new Manufacturer("Rapido"), new Scale("HO"), "123ABC").toJSON(); 
	}
	
	@GetMapping("/railroadJSON")
	public String railroad()
	{
		return new Railroad("Amtrak").toJSON(); 
	}
	
	@GetMapping("/rollingStockJSON")
	public String rollingStock()
	{
		return null; 
	}
	
	@GetMapping("/scaleJSON")
	public String scale()
	{
		return new Scale("HO").toJSON(); 
	}
	
}//end homeController
