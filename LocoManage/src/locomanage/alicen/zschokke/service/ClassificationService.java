package locomanage.alicen.zschokke.service;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import locomanage.alicen.zschokke.entities.Classification;
import locomanage.alicen.zschokke.repositories.ClassificationRepository;

/**
 * Contains service methods for CRUD operations with Classification entities. 
 * @author Alicen Zschokke
 *
 */
@Service
public class ClassificationService 
{
	//inject repository
	private ClassificationRepository classificationRepository;
	
	/**
	 * Constructor
	 * @param classificationRepository
	 */
	@Autowired //tells this class where the managed bean should be injected
	public ClassificationService(ClassificationRepository classificationRepository)
	{
		this.classificationRepository = classificationRepository; 
	}
	
	/**
	 * Adds the parameter classification if it is not null and does not already exist in the database. 
	 * @param classification
	 */
	public void add(Classification classification)
	{
		if(classification != null && this.get(classification.getName()) == null)
		{ 
			classificationRepository.save(classification);		
		}//end if	
	}//end add
	
	/**
	 * Retrieves all the classifications in the database. 
	 * @return an Iterable containing all of the Classifications in the database
	 */
	public Iterable<Classification> getAll()
	{
		return classificationRepository.findAll();
	}//end getAll()
	
	/**
	 * Retrieves a classifiction by id number
	 * @param id the Integer id to find the classification matching
	 * @return the matching Classification, or null if one does not exist
	 */
	public Classification get(Integer id)
	{
		try
		{
			return classificationRepository.findById(id).get();
		}
		catch(NoSuchElementException e){}
		return null;
	}//end get(Integer id)
	
	/**
	 * Retrieves a classification by name
	 * @param name the String name of the classification
	 * @return the matching classification, or null if one does not exist
	 */
	public Classification get(String name)
	{
//		System.out.println("getString");
		try
		{
			return classificationRepository.findByNameIgnoreCase(name).get();
		}
		catch(NoSuchElementException e){}
		return null;
	}
	
	/**
	 * Removes the parameter classification from the database. 
	 * @param classification the classification to be removed
	 */
	public void remove(Classification classification)
	{
		classificationRepository.delete(classification);
	}
	
	/**
	 * Updates the classification with the matching id number to the information in the parameter classification
	 * @param classification the classification with the updated information
	 */
	public void update(Classification classification)
	{
		System.out.println("update");
		try
		{
			Classification found = classificationRepository.findById(classification.getId()).get();
			found.setName(classification.getName());
			classificationRepository.save(found);
		}
		catch(NoSuchElementException e)
		{
			System.out.println("caught");
		}
	}//end update()
	
}//end ClassificationService
