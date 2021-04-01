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
	
	public Iterable<Classification> getAll()
	{
		return classificationRepository.findAll();
	}//end getAll()
	
	public Classification get(Integer id)
	{
		try
		{
			return classificationRepository.findById(id).get();
		}
		catch(NoSuchElementException e){}
		return null;
	}//end get(Integer id)
	
	public Classification get(String name)
	{
//		System.out.println("getString");
		try
		{
			return classificationRepository.findByName(name).get();
		}
		catch(NoSuchElementException e){}
		return null;
	}
	
	public void remove(Classification classification)
	{
		classificationRepository.delete(classification);
	}
	
}//end ClassificationService
