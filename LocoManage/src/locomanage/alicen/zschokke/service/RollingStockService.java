package locomanage.alicen.zschokke.service;

/* IMPORTS */
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import locomanage.alicen.zschokke.entities.RollingStock;
import locomanage.alicen.zschokke.repositories.RollingStockRepository;

/**
 * RollingStockService to handle Database operations for RollingStock entities.
 * @author cena-
 *
 */
@Service
public class RollingStockService 
{
	//RollingStockRepository object for db access
	private RollingStockRepository rsr; 
	
	/**
	 * Autowired Constructor
	 * @param rollingStockRepository
	 */
	@Autowired
	public RollingStockService(RollingStockRepository rollingStockRepository)
	{
		this.rsr = rollingStockRepository; 
	}
	
	/**
	 * Retrieves all the Rolling Stock entities in the database.
	 * @return an Iterable of RollingStock items
	 */
	public Iterable<RollingStock> getAll(Integer id)
	{
		return rsr.findAll(id); 
	}//end getAll()
	
	/**
	 * Adds a RollingStock entity to the database
	 * @param r the RollingStock item to be added
	 */
	public void add(RollingStock r)
	{
		rsr.save(r);
	}
	
	/**
	 * Retrieves the RollingStock item with the given id from the database.
	 * @param id the Integer id of the RollingStock entity to retrieve
	 * @return 
	 */
	public RollingStock get(Integer id)
	{
		try
		{
			return rsr.findById(id).get(); 
		}
		catch(NoSuchElementException e)
		{
			return null; 
		}
	}
	
	/**
	 * Retrieves all of the RollingStock not currently in a chain from the database. 
	 * @return an Iterable of RollingStock items
	 */
	public Iterable<RollingStock> getAvailable(Integer id)
	{
		return this.rsr.findAvailable(id); 
	}
	
	/**
	 * Updates a RollingStock entity in the database
	 * @param rollingStock the RollingStock with the updated information
	 */
	public void update(RollingStock rollingStock)
	{
		try
		{
			RollingStock found = this.rsr.findById(rollingStock.getId()).get();
			found.setCarNumber(rollingStock.getCarNumber());
			found.setInChain(rollingStock.getInChain());
			found.setLength(rollingStock.getLength());
			found.setModel(rollingStock.getModel());
			found.setNotes(rollingStock.getNotes());
			found.setOwner(rollingStock.getOwner());
			found.setProductInfo(rollingStock.getProductInfo());
			found.setUserId(rollingStock.getUserId());
			found.setInChain(rollingStock.getInChain());
			this.rsr.save(found);
		}//end try
		catch(NullPointerException | NoSuchElementException e){}	
		
	}//end update()
	
}//end RollingStockService
