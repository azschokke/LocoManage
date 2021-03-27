package locomanage.alicen.zschokke.service;

import java.util.List;

import locomanage.alicen.zschokke.dao.DAO;
import locomanage.alicen.zschokke.db_access.DBAccess;
import locomanage.alicen.zschokke.entities.Location;

public class LocationService extends DBAccess implements DAO<Location>
{
	/**
	 * Adds a Location to the databse. 
	 * @param l the location to be added
	 */
	@Override
	public void add(Location l)
	{
		this.connect();
		em.getTransaction().begin(); 
		em.persist(l);
		em.getTransaction().commit();
		this.disconnect(); 
	}//end add

	/**
	 * Accessor for a Location in the database. 
	 * @param id the id of the Location
	 * @return Location the location with the matching id, or null if no match is found
	 */
	@Override
	public Location get(int id) 
	{
		this.connect(); 
		Location l = em.find(Location.class, id);
		this.disconnect(); 
		return l;
	}//end get(id)
	
	/**
	 * Updates a Location in the database.
	 * @param l the Location with the updated information
	 */
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

	/**
	 * Removes a Location from the database. 
	 * @param id the id of the Location to be removed
	 */
	@Override
	public void remove(int id) 
	{
		this.connect();
		em.remove(em.find(Location.class, id));
		this.disconnect(); 
	}//end remove

	/**
	 * Returns a List of all the Locations in the database. 
	 */
	@Override
	public List<Location> getAll() 
	{
		// TODO get all locations from database
		return null;
	}

}
