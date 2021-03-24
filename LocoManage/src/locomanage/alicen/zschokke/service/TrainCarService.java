package locomanage.alicen.zschokke.service;

import java.util.List;

import locomanage.alicen.zschokke.dao.DAOI;
import locomanage.alicen.zschokke.db_access.DBAccess;
import locomanage.alicen.zschokke.entities.TrainCar;

public class TrainCarService extends DBAccess implements DAOI<TrainCar>
{
	//TODO javadoc
	@Override
	public void add(TrainCar t) 
	{
		this.connect(); 
		em.getTransaction().begin();
		em.persist(t);
		em.getTransaction().commit();
		this.disconnect();
	}//end add

	//TODO javadoc
	@Override
	public TrainCar get(int id)
	{
		this.connect(); 
		TrainCar t = em.find(TrainCar.class, id);
		this.disconnect(); 
		return t;
	}//end get

	//TODO javadoc
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

	//TODO javadoc
	@Override
	public void remove(int id) 
	{
		this.connect();
		em.remove(em.find(TrainCar.class, id));
		this.disconnect(); 
	}

	//TODO javadoc
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
