package locomanage.alicen.zschokke.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import locomanage.alicen.zschokke.entities.Classification;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestfulController 
{
	@GetMapping("/")
	public String showIndex()
	{
		return "index"; 
	}
	
	@GetMapping("/classification")
	public String greeting(@RequestParam(value="name", defaultValue="World") String name, Model model)
	{
		model.addAttribute("object", new Classification(name));
		return new Classification(name).toJSON();
	}
	
	
}//end homeController
