package locomanage.alicen.zschokke.service;

import java.util.NoSuchElementException;

/* IMPORTS */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import locomanage.alicen.zschokke.entities.Scale;
import locomanage.alicen.zschokke.repositories.ScaleRepository;

/**
 * Service for handling Scale entities. 
 * @author Alicen Zschokke
 */
@Service
public class ScaleService 
{
	//scaleRepository for db access
	private ScaleRepository scaleRepository; 
	
	/**
	 * Autowired constructor
	 * @param scaleRepository
	 */
	@Autowired
	public ScaleService(ScaleRepository scaleRepository)
	{
		this.scaleRepository = scaleRepository; 
	}
	
	/**
	 * Returns an Iterable of all the Scale entities in the database.
	 * @return an Iterable of Scale entities
	 */
	public Iterable<Scale> getAll()
	{
		return scaleRepository.findAll();
	}
	
	/**
	 * Adds a scale to the database.
	 * @param s the Scale to be added
	 */
	public void add(Scale s)
	{
		scaleRepository.save(s);
	}
	
	/**
	 * Retrieves a scale entity from the database by id.
	 * @param id the id of the scale to be retrieved
	 * @return the Scale with the matching unique Integer id or null if no match exists
	 */
	public Scale get(Integer id)
	{
		try
		{
			return scaleRepository.findById(id).get(); 
		}
		catch(NoSuchElementException e)
		{
			return null; 
		}
	}//end get(id) 
	
}//end ScaleService
