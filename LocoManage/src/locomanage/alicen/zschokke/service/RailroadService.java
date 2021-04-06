package locomanage.alicen.zschokke.service;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import locomanage.alicen.zschokke.entities.Railroad;
import locomanage.alicen.zschokke.repositories.RailroadRepository;

/**
 * Services for railroad entities. 
 * @author Alicen Zschokke
 *
 */
@Service
public class RailroadService
{
	private RailroadRepository railroadRepository; 
	
	/**
	 * Constructor
	 * @param railroadRepository
	 */
	@Autowired
	public RailroadService(RailroadRepository railroadRepository)
	{
		this.railroadRepository = railroadRepository; 
	}
	
	/**
	 * Finds a railroad by its id
	 * @param id unique Integer id of the railroad
	 * @return the railroad with the matching id, or null if none exists
	 */
	public Railroad get(Integer id)
	{
		try
		{
			return railroadRepository.findById(id).get();
		}
		catch(NoSuchElementException e) {}
		return null; 
	}//end get
	
	/**
	 * Adds a railroad to the database
	 * @param railroad the railroad to be added to the database
	 */
	public void add(Railroad railroad)
	{
		System.out.println("add");
		if(railroad != null)
		{
			System.out.println("not null");
			if(railroadRepository.findByName(railroad.getName()).equals(Optional.empty()))
			{
				railroadRepository.save(railroad);
			}//end if
		}//end if
	}//end add(railroad)
	
	/**
	 * Retrieves all the Railroads from the database
	 * @return an Iterable of Railroad objects from the database
	 */
	public Iterable<Railroad> getAll()
	{
		return railroadRepository.findAll();
	}
	
	/**
	 * Updates the name of the railroad with the matching id in the database.
	 * @param railroad the Railroad with the updated name
	 */
	public void update(Railroad railroad)
	{
		Railroad found = this.railroadRepository.findById(railroad.getId()).get(); 
		found.setName(railroad.getName());
		this.railroadRepository.save(found);
	}//end update
	
	/**
	 * Removes a railroad from the database
	 * @param id the unique integer id of the railroad to be removed
	 */
	public void remove(Integer id)
	{
		this.railroadRepository.delete(this.railroadRepository.findById(id).get());
	}//end remove
	
}//end RailroadService
