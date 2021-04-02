package locomanage.alicen.zschokke.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import locomanage.alicen.zschokke.service.RollingStockService;

@RestController
@CrossOrigin
@RequestMapping("/rollingStock")
public class RollingStockController
{
	private RollingStockService rollingStockService; 
	
	@Autowired
	public RollingStockController(RollingStockService rollingStockService)
	{
		this.rollingStockService = rollingStockService; 
	}
	
	
}//end RollingStockController
