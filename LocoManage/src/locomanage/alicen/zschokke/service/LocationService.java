package locomanage.alicen.zschokke.service;

import java.util.List;

import locomanage.alicen.zschokke.dao.DAOI;
import locomanage.alicen.zschokke.db_access.DBAccess;
import locomanage.alicen.zschokke.entities.Location;

public class LocationService extends DBAccess implements DAOI<Location>
{
	//TODO javadocs
	@Override
	public void add(Location l)
	{
		this.connect();
		em.getTransaction().begin(); 
		em.persist(l);
		em.getTransaction().commit();
		this.disconnect(); 
	}//end add

	//TODO javadocs
	@Override
	public Location get(int id) 
	{
		this.connect(); 
		Location l = em.find(Location.class, id);
		this.disconnect(); 
		return l;
	}//end get(id)
	
	//TODO javadocs
	@Override
	public void update(Location l)
	{
		this.connect(); 
		Location f = em.find(Location.class, l.getId());
		f.setChildren(l.getChildren());
		f.setName(l.getName());
		f.setParent(l.getParent());
		f.setTrack(l.isTrack());
		this.disconnect();
	}//end update(l)

	//TODO javadocs
	@Override
	public void remove(int id) 
	{
		this.connect();
		em.remove(em.find(Location.class, id));
		this.disconnect(); 
	}//end remove

	//TODO javadocs
	@Override
	public List<Location> getAll() 
	{
		// TODO Auto-generated method stub
		return null;
	}

}
