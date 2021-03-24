package locomanage.alicen.zschokke.dao;

import java.util.List;

import locomanage.alicen.zschokke.db_access.DBAccess;
import locomanage.alicen.zschokke.entities.Train;

public class TrainService extends DBAccess implements DAOI<Train>
{
	
	//TODO javadocs
	@Override
	public void add(Train t) 
	{
		this.connect(); 
		em.persist(t);
		this.disconnect(); 
	}//end add(t)

	//TODO javadocs
	@Override
	public Train get(int id) 
	{
		this.connect();
		Train t = em.find(Train.class, id);
		this.disconnect(); 
		return t;
	}//end get(id)
	
	//TODO javadocs
	@Override
	public void update(Train t) 
	{
		// TODO Auto-generated method stub
	}//end update(t)
	
	//TODO javadocs
	@Override
	public void remove(int id) 
	{
		this.connect(); 
		em.remove(em.find(Train.class, id));
		this.disconnect(); 		
	}//end remove(id)

	//TODO javadocs
	@Override
	public List<Train> getAll() 
	{
		// TODO Auto-generated method stub
		return null;
	}//end getAll()
	
}//end TrainDAO
