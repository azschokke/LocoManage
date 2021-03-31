package locomanage.alicen.zschokke.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import locomanage.alicen.zschokke.entities.Manufacturer;
import locomanage.alicen.zschokke.service.ManufacturerService;

@CrossOrigin
@RestController
@RequestMapping("/manufacturer")
public class ManufacturerController 
{
	private ManufacturerService manufacturerService;
	
	private ManufacturerController(ManufacturerService manufacturerService)
	{
		this.manufacturerService = manufacturerService; 
	}
	
	@PostMapping("/add/{name}")
	public void addManufacturer(@PathVariable String name)
	{
		manufacturerService.add(new Manufacturer(name));
	}//end addManufacturer
	
	@GetMapping("/manufacturer{id}")
	public String getManufacturer(@PathVariable Integer id)
	{
		return manufacturerService.get(id).toJSON(); 
	}
}//end manufacturerService
