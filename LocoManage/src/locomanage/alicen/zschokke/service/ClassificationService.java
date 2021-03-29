package locomanage.alicen.zschokke.service;

import java.util.List;

import locomanage.alicen.zschokke.dao.DAO;
import locomanage.alicen.zschokke.db_access.DBAccess;
import locomanage.alicen.zschokke.entities.Classification;

public class ClassificationService extends DBAccess implements DAO<Classification>
{
	//TODO javadoc
	@Override
	public void add(Classification c) 
	{
		this.connect(); 
		em.getTransaction().begin(); 
		em.persist(c);
		em.getTransaction().commit();
		this.disconnect(); 
	}//end add

	//TODO javadoc
	@Override
	public Classification get(int id) 
	{
		this.connect(); 
		Classification c  = em.find(Classification.class, id);
		this.disconnect(); 
		return c; 
	}//end get

	//TODO javadoc
	@Override
	public void update(Classification c)
	{
		this.connect(); 
		Classification original = em.find(Classification.class, c.getId());
		original.setName(c.getName());
		this.disconnect(); 
	}//end update

	//TODO javadoc
	@Override
	public void remove(int id)
	{
		this.connect(); 
		em.remove(em.find(Classification.class, id));
		this.disconnect(); 
	}//end remove

	//TODO javadoc
	@Override
	public List<Classification> getAll()
	{
		this.connect(); 
		@SuppressWarnings("unchecked")
		List<Classification> classifications = em.createNativeQuery("SELECT c FROM Classification c", Classification.class).getResultList();
		this.disconnect(); 
		return classifications;
	}//end getAll()
	
	
	
}//end class ClassificationService
