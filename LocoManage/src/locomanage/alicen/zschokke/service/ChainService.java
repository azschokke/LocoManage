package locomanage.alicen.zschokke.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import locomanage.alicen.zschokke.entities.Chain;
import locomanage.alicen.zschokke.repositories.ChainRepository;

/**
 * Service methods for the Chain entities in the database
 * @author Alicen Zschokke
 *
 */
@Service
public class ChainService 
{
	//chainRepository object for accessing db
	private ChainRepository chainRepository; 
	
	/**
	 * Autowired constructor.
	 * @param chainRepository
	 */
	@Autowired
	public ChainService(ChainRepository chainRepository)
	{
		this.chainRepository = chainRepository;
	}
	
	/**
	 * Returns a list of all the chains in the database. 
	 * @return a List of Chain objects from the database
	 */
	public List<Chain> getAll()
	{
		return chainRepository.findAll();
	}//end getAll(); 
	
	/**
	 * Finds a specific Chain in the database by the id
	 * @param id the integer id of the chain
	 * @return the Chain with the matching id, or null if no such chain exists
	 */
	public Chain get(int id)
	{
		try
		{
			return chainRepository.findById(id).get();
		}
		catch(NoSuchElementException e)
		{
			return null; 
		}
	}//end get(id)
	
	/**
	 * Updates the chain in the database with the matching id to the information of the parameter chain.
	 * @param c the Chain with the updated information
	 * @return true if the update was successful, otherwise false
	 */
	public boolean update(Chain c)
	{
		try
		{
			Chain found = chainRepository.findById(c.getId()).get();
			found.setLocation(c.getLocation());
		}
		catch(NoSuchElementException e)
		{
			return false; 
		}
		return true; 
	}//end update(Chain c)
	
	/**
	 * Removes the parameter Chain from the database.
	 * @param c the Chain to be removed
	 */
	public void remove(Chain c)
	{
		chainRepository.delete(c);
	}
	
	/**
	 * Adds a chain to the database
	 * @param c the chain to be added
	 */
	public void add(Chain c)
	{
		this.chainRepository.save(c);
	}
	
	
}//end ChainService
