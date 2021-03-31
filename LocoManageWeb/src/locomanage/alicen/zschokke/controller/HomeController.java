package locomanage.alicen.zschokke.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import locomanage.alicen.zschokke.entities.Classification;

@Controller
public class HomeController 
{
	@GetMapping("/")
	public String showIndex()
	{
		return "index"; 
	}
	
	@GetMapping("/classification")
	public String greeting(@RequestParam(value="name", defaultValue="World") String name, Model model)
	{
		model.addAttribute("object", new Classification(name).toJSON());
		return "index";
	}
	
	
}//end homeController
