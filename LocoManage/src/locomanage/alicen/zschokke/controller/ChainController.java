package locomanage.alicen.zschokke.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import locomanage.alicen.zschokke.entities.Chain;
import locomanage.alicen.zschokke.entities.RollingStock;
import locomanage.alicen.zschokke.json.JSONUtilities;
import locomanage.alicen.zschokke.service.ChainService;
import locomanage.alicen.zschokke.service.RollingStockService;

/**
 * Controller for handling requests concerning Chain entities. 
 * @author Alicen Zschokke
 *
 */
@CrossOrigin
@RestController
@RequestMapping("/chain")
public class ChainController 
{
	//chain service
	private ChainService chainService;
	private RollingStockService rollingStockService; 
	
	@Autowired
	public ChainController(ChainService chainService, RollingStockService rollingStockService)
	{
		this.chainService = chainService; 
		this.rollingStockService = rollingStockService; 
	}//end ChainController(chainService, rollingStockService)
	
	@PostMapping("/add")
	public void add(@RequestBody String body)
	{
		System.out.println(body);
		HashMap<String, Object> requestBody = JSONUtilities.fromJSON(body);
		System.out.println(requestBody);
		Chain chain = new Chain(requestBody.get("name").toString());
		ArrayList<String> numbers = (ArrayList<String>) requestBody.get("cars");
		for(String n : numbers)
		{
			RollingStock rs = this.rollingStockService.get(Integer.parseInt(n));
			chain.addRollingStock(rs);
			rs.setInChain(true); 
			this.rollingStockService.update(rs);
		}//end for
		this.chainService.add(chain);
	}//end add()
	
	@GetMapping("/all")
	public String getAll()
	{
		return JSONUtilities.listToJSON(this.chainService.getAll());
	}
}//end ChainController
