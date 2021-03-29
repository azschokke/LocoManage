package locomanage.alicen.zschokke.service;

import java.util.List;

import locomanage.alicen.zschokke.dao.DAO;
import locomanage.alicen.zschokke.db_access.DBAccess;
import locomanage.alicen.zschokke.entities.RollingStock;

public class RollingStockService extends DBAccess implements DAO<RollingStock>
{
	/**
	 * Adds a train car to the database.
	 * @param t the train car to be added
	 */
	@Override
	public void add(RollingStock r) 
	{
		this.connect(); 
		em.getTransaction().begin();
		em.persist(r);
		em.getTransaction().commit();
		this.disconnect();
	}//end add

	/**
	 * Accessor for the TrainCar in the database with the matching id, if one exists. 
	 * @param id the unique id of the TrainCar 
	 * @return the TrainCar with the matching id, or null if no match is found
	 */
	@Override
	public RollingStock get(int id)
	{
		this.connect(); 
		RollingStock t = em.find(RollingStock.class, id);
		this.disconnect(); 
		return t;
	}//end get

	/**
	 * Updates the train car's information in the database
	 * @param t the TrainCar with the updated information
	 */
	@Override
	public void update(RollingStock r)
	{
		this.connect();
		RollingStock f = em.find(RollingStock.class, r.getId());
		f.setCarNumber(r.getCarNumber());
		f.setLength(r.getLength());
		f.setNotes(r.getNotes());
		this.disconnect(); 
	}//end update

	/**
	 * Removes the train car with the given id from the database.
	 * @param id the id of the TrainCar to be removed
	 */
	@Override
	public void remove(int id) 
	{
		this.connect();
		em.remove(em.find(RollingStock.class, id));
		this.disconnect(); 
	}//end remove

	/**
	 * Accessor for all the TrainCars in the database
	 * @return a List of all the TrainCars in the database
	 */
	@Override
	public List<RollingStock> getAll() 
	{
		this.connect();
		@SuppressWarnings("unchecked")
		List<RollingStock> cars = em.createNamedQuery("getAllCars").getResultList();
		this.disconnect(); 
		return cars;
	}//end getAll()

	
}//end TrainCarDAO
