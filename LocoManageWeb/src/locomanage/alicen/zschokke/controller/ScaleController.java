package locomanage.alicen.zschokke.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import locomanage.alicen.zschokke.service.ScaleService;

@CrossOrigin
@RestController
@RequestMapping("/scale")
public class ScaleController 
{
	private ScaleService scaleService; 
	
	@Autowired
	public ScaleController(ScaleService scaleService)
	{
		this.scaleService = scaleService; 
	}
	
	@GetMapping("/{id}")
	public String getScale(@PathVariable Integer id)
	{
		return scaleService.get(id).toJSON(); 
	}
}
