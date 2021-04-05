package locomanage.alicen.zschokke.controller;

import java.util.StringJoiner;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	/**
	 * Constructor
	 * @param classificationService
	 */
	@Autowired
	public ClassificationController(ClassificationService classificationService)
	{
		this.classificationService = classificationService; 
	}
	
	/**
	 * Retrieves a classification from the database by id. 
	 * @param id the Integer id number of the classifiction to retrieve
	 * @return a JSON representation of the classification matching parameter id
	 */
	@GetMapping("/{id}")
	public String getClassification(@PathVariable Integer id)
	{
		try
		{
			return classificationService.get(id).toJSON(); 
		}
		catch(NullPointerException e)
		{
			return "{}"; 
		}
	}//end getClassification
	
	/**
	 * Retrieves all classifications from the database
	 * @return a JSON array of all the classifications in the database
	 */
	@GetMapping("/all")
	public String getClassifications()
	{
		return listToJSON(classificationService.getAll());
	}
	
	/**
	 * Adds a classification to the database
	 * @param name the name of the classification to add to the database
	 */
	@PostMapping("/add/{name}")
	public void addClassification(@PathVariable String name)
	{
		classificationService.add(new Classification(name));
	}
	
	/**
	 * Removes the classification with the given id from the database. 
	 * @param id the id number of the classification to be removed
	 */
	@GetMapping("/{id}/delete")
	public void removeClassification(@PathVariable Integer id)
	{
		classificationService.remove(classificationService.get(id));
	}
	
	/*
	 * Converts an Iterable to a JSON array
	 */
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
