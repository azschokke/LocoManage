package locomanage.alicen.zschokke.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import locomanage.alicen.zschokke.entities.Classification;

@RestController
public class HomeController 
{
	@GetMapping("/")
	public String landing()
	{
		return "what"; 
	}
	@GetMapping("/greeting")
	public Classification greeting(@RequestParam(value="name", defaultValue="World") String name)
	{
		return new Classification(name);
	}
}
