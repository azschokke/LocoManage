package locomanage.alicen.zschokke.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import locomanage.alicen.zschokke.service.ChainService;

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
	
	@Autowired
	public ChainController(ChainService chainService)
	{
		this.chainService = chainService; 
	}
	
	@PostMapping("/add")
	public void add(@RequestBody String body)
	{
		//TODO all of this tomorrow morning
	}//end add()
	
	//autowire
}
