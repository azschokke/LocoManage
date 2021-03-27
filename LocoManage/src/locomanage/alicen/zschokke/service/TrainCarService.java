package locomanage.alicen.zschokke.service;

import java.util.List;

import locomanage.alicen.zschokke.dao.DAO;
import locomanage.alicen.zschokke.db_access.DBAccess;
import locomanage.alicen.zschokke.entities.TrainCar;

public class TrainCarService extends DBAccess implements DAO<TrainCar>
{
	/**
	 * Adds a train car to the database.
	 * @param t the train car to be added
	 */
	@Override
	public void add(TrainCar t) 
	{
		this.connect(); 
		em.getTransaction().begin();
		em.persist(t);
		em.getTransaction().commit();
		this.disconnect();
	}//end add

	/**
	 * Accessor for the TrainCar in the database with the matching id, if one exists. 
	 * @param id the unique id of the TrainCar 
	 * @return the TrainCar with the matching id, or null if no match is found
	 */
	@Override
	public TrainCar get(int id)
	{
		this.connect(); 
		TrainCar t = em.find(TrainCar.class, id);
		this.disconnect(); 
		return t;
	}//end get

	/**
	 * Updates the train car's information in the database
	 * @param t the TrainCar with the updated information
	 */
	@Override
	public void update(TrainCar t)
	{
		this.connect();
		TrainCar f = em.find(TrainCar.class, t.getId());
		f.setCarClass(t.getCarClass());
		f.setCarNumber(t.getCarNumber());
		f.setCategory(t.getCategory());
		f.setLength(t.getLength());
		f.setManufacturer(t.getManufacturer());
		f.setNotes(t.getNotes());
		f.setRailroad(t.getRailroad());
		f.setSku(t.getSku());
		f.setStatus(t.getStatus());
		this.disconnect(); 
	}

	/**
	 * Removes the train car with the given id from the database.
	 * @param id the id of the TrainCar to be removed
	 */
	@Override
	public void remove(int id) 
	{
		this.connect();
		em.remove(em.find(TrainCar.class, id));
		this.disconnect(); 
	}

	/**
	 * Accessor for all the TrainCars in the database
	 * @return a List of all the TrainCars in the database
	 */
	@Override
	public List<TrainCar> getAll() 
	{
		this.connect();
		@SuppressWarnings("unchecked")
		List<TrainCar> cars = em.createNamedQuery("getAllCars").getResultList();
		this.disconnect(); 
		return cars;
	}

	
}//end TrainCarDAO
