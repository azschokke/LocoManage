package locomanage.alicen.zschokke.controller;

import java.util.StringJoiner;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import locomanage.alicen.zschokke.entities.Classification;
import locomanage.alicen.zschokke.service.ClassificationService;

@RestController
@CrossOrigin
@RequestMapping("/classification")
public class ClassificationController 
{
	private ClassificationService classificationService;
	
	public ClassificationController(ClassificationService classificationService)
	{
		this.classificationService = classificationService; 
	}
	
	@GetMapping("/{id}")
	public String getClassification(@PathVariable Integer id)
	{
		return classificationService.get(id).toJSON(); 
	}
	
	@GetMapping("/all")
	public String getClassifications()
	{
		return listToJSON(classificationService.getAll());
	}
	
	@PostMapping("/add/{name}")
	public void addClassification(@PathVariable String name)
	{
		System.out.println(name);
		Classification c = new Classification(name);
		System.out.println(c.toJSON());
		classificationService.add(c);
	}
	
	@GetMapping("/{id}/delete")
	public void removeClassification(@PathVariable Integer id)
	{
		classificationService.remove(classificationService.get(id));
	}
	
	private static String listToJSON(Iterable<Classification> list)
	{
		StringJoiner result = new StringJoiner(", ", "[", "]");
		
		for(Classification c : list)
		{
			result = result.add(c.toJSON());
		}
		return result.toString(); 
	}//end listToJSON
	
}//end ClassificationController
