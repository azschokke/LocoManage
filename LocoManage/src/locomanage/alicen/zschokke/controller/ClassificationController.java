package locomanage.alicen.zschokke.controller;

/* IMPORTS */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import locomanage.alicen.zschokke.entities.Classification;
import locomanage.alicen.zschokke.json.JSONUtilities;
import locomanage.alicen.zschokke.service.ClassificationService;

/**
 * Rest Controller for handling operations with the classification entity. 
 * @author Alicen Zschokke
 */
@RestController
@CrossOrigin
@RequestMapping("/classification")
public class ClassificationController 
{
	//ClassificationService object for the class
	private ClassificationService classificationService;
	
	/**
	 * Constructor
	 * @param classificationService
	 */
	@Autowired
	public ClassificationController(ClassificationService classificationService)
	{
		this.classificationService = classificationService; 
	}//end ClassificationController
	
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
		}//end try
		catch(NullPointerException e)
		{
			return "{}"; 
		}//end catch
	}//end getClassification(id)
	
	/**
	 * Retrieves all classifications from the database.
	 * @return a JSON array of all the classifications in the database
	 */
	@GetMapping("/all")
	public String getClassifications()
	{
		return JSONUtilities.listToJSON(classificationService.getAll());
	}//end getClassifications()
	
	/**
	 * Adds a classification to the database
	 * @param name the name of the classification to add to the database
	 */
	@PostMapping("/add")
	public void addClassification(@RequestBody String body)
	{
		classificationService.add(new Classification(body));
	}//end addClassification(body)
	
	/**
	 * Removes the classification with the given id from the database. 
	 * @param id the id number of the classification to be removed
	 */
	@GetMapping("/delete")
	public void removeClassification(@RequestBody Integer id)
	{
		classificationService.remove(classificationService.get(id));
	}
	
}//end ClassificationController
