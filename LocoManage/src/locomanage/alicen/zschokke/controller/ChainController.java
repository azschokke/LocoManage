package locomanage.alicen.zschokke.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@PostMapping("/add/{id}")
	public void add(@RequestBody String body, @PathVariable Integer id)
	{
		System.out.println("addChain");
		System.out.println(body);
		HashMap<String, Object> requestBody = JSONUtilities.fromJson(body);
		System.out.println(requestBody);
		Chain chain = new Chain(requestBody.get("name").toString());
		chain.setUserId(id);
		ArrayList<String> numbers = (ArrayList<String>) requestBody.get("cars");
		for(String n : numbers)
		{
			RollingStock rs = this.rollingStockService.get(Integer.parseInt(n));
//			System.out.println(rs);
			chain.addRollingStock(rs);
		}//end for
		chain = this.chainService.add(chain);
		for(String n : numbers)
		{
			RollingStock rs = this.rollingStockService.get(Integer.parseInt(n));
			rs.setInChain(chain.getId());
			System.out.println(rs.getInChain());
			this.rollingStockService.update(rs);
		}//end for 
		
	}//end add()
	
	@GetMapping("/all/{id}")
	public String getAll(@PathVariable Integer id)
	{
		return JSONUtilities.listToJson(this.chainService.getAll(id));
	}
}//end ChainController
