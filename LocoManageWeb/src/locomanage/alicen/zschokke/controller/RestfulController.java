package locomanage.alicen.zschokke.controller;

import java.util.StringJoiner;

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
import locomanage.alicen.zschokke.service.ManufacturerService;
import locomanage.alicen.zschokke.service.ScaleService;

import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class RestfulController 
{
	private ClassificationService classificationService;
	private ScaleService scaleService; 
	private ManufacturerService manufacturerService; 
	
	@Autowired
	public RestfulController(ClassificationService classificationService, ScaleService scaleService, ManufacturerService manufacturerService)
	{
		this.classificationService = classificationService; 
		this.scaleService = scaleService; 
		this.manufacturerService = manufacturerService;
	}
	@GetMapping("/JSON")
	public String showIndex()
	{
		return "index"; 
	}
	
	@GetMapping("/classificationJSON")
	public String classification(@RequestParam(value="name", defaultValue="World") String name, org.springframework.ui.Model model)
	{
		//classificationService.saveUser(new Classification("locomotive"));
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
	
	@GetMapping("/classificationsJSON")
	public String getClassifications()
	{
		StringJoiner arr = new StringJoiner(", ", "[", "]");
		for(Classification c : classificationService.getAll())
		{
			arr.add(c.toJSON());
		}
		return arr.toString();
	}//end classifications
	
	@GetMapping("/scalesJSON")
	public String getScales()
	{
		StringJoiner arr = new StringJoiner(", ", "[", "]");
		for(Scale s : scaleService.getAll())
		{
			arr.add(s.toJSON());
		}
		return arr.toString();
	}
	
	@GetMapping("/manufacturersJSON")
	public String getManufacturers()
	{
		StringJoiner arr = new StringJoiner(", ", "[", "]");
		for(Manufacturer m : manufacturerService.getAll())
		{
			arr.add(m.toJSON());
		}
		return arr.toString();
	}
	
	@GetMapping("/railroadsJSON")
	public String getRailroads()
	{
		StringJoiner arr = new StringJoiner(", ", "[", "]");
		return arr.toString();
	}
}//end homeController
