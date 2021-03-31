package locomanage.alicen.zschokke.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}//end ClassificationController
