package locomanage.alicen.zschokke.service;

import java.util.List;

import locomanage.alicen.zschokke.dao.DAOI;
import locomanage.alicen.zschokke.db_access.DBAccess;
import locomanage.alicen.zschokke.entities.Train;

public class TrainService extends DBAccess implements DAOI<Train>
{
	
	/**
	 * Adds a Train to the database. 
	 * @param t the Train to be added
	 */
	@Override
	public void add(Train t) 
	{
		this.connect(); 
		em.persist(t);
		this.disconnect(); 
	}//end add(t)

	/**
	 * Accessor for a train in the database
	 * @param id the id of the Train to be retrieved
	 * @param the Train with the matchind id, or null if no match is found
	 */
	@Override
	public Train get(int id) 
	{
		this.connect();
		Train t = em.find(Train.class, id);
		this.disconnect(); 
		return t;
	}//end get(id)
	
	/**
	 * Updates a Train's information in the database. 
	 * @param t the Train with the updated information
	 */
	@Override
	public void update(Train t) 
	{
		// TODO update Train
	}//end update(t)
	
	/**
	 * Removes a Train from the database. 
	 * @param id the id of the Train to be removed
	 */
	@Override
	public void remove(int id) 
	{
		this.connect(); 
		em.remove(em.find(Train.class, id));
		this.disconnect(); 		
	}//end remove(id)

	/**
	 * Accessor for all the Trains in the database. 
	 * @return a List of Trains in the database
	 */
	@Override
	public List<Train> getAll() 
	{
		// TODO get all trains
		return null;
	}//end getAll()
	
}//end TrainDAO
