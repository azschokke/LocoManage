package locomanage.alicen.zschokke.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import locomanage.alicen.zschokke.entities.Classification;
import locomanage.alicen.zschokke.entities.Manufacturer;
import locomanage.alicen.zschokke.entities.Scale;
import locomanage.alicen.zschokke.service.ClassificationService;
import locomanage.alicen.zschokke.service.ManufacturerService;
import locomanage.alicen.zschokke.service.ScaleService;
//TODO comment
/**
 * Controller to interact with jsp pages - minimal function. 
 * @author Alicen Zschokke
 */
@Controller
public class AController 
{
	private ClassificationService classificationService;
	private ScaleService scaleService; 
	private ManufacturerService manufacturerService; 
	
	@Autowired
	public AController(ClassificationService classificationService, ScaleService scaleService, ManufacturerService manufacturerService)
	{
		this.classificationService = classificationService; 
		this.scaleService = scaleService; 
		this.manufacturerService = manufacturerService; 
	}
	
	@GetMapping("/")
	public String showIndex(Model model)
	{
		model.addAttribute("manufacturer", new Manufacturer());
		model.addAttribute("scale", new Scale());
		model.addAttribute("classification", new Classification());
		return "index"; 
	}
	
	@PostMapping("/addManufacturer")
	public String addManufacturer(@ModelAttribute("manufacturer") Manufacturer manufacturer)
	{
		manufacturerService.add(manufacturer);
		return "index"; 
	}//end addManfacturer
	
	@PostMapping("/addScale")
	public String addScale(@ModelAttribute("scale") Scale scale)
	{
		scaleService.add(scale);
		return "index";
	}
	
	@PostMapping("/addClassification")
	public String addClassification(@ModelAttribute("classification") Classification classification)
	{
		classificationService.add(classification);
		return "index"; 
	}
}//end homeController
