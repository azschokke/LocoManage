package locomanage.alicen.zschokke.service;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import locomanage.alicen.zschokke.entities.Location;
import locomanage.alicen.zschokke.repositories.LocationRepository;

@Service
public class LocationService 
{
	private LocationRepository locationRepository; 
	
	@Autowired
	public LocationService(LocationRepository locationRepository)
	{
		this.locationRepository = locationRepository; 
	}
	
	/**
	 * Retrieves a Location by its unique Integer id
	 * @param id the integer id of the Location to retrieve
	 * @return the Location with the given id, or null if no match is found
	 */
	public Location get(Integer id)
	{
		System.out.println("get by id: " + id);
		try
		{
			return locationRepository.findById(id).get(); 
		}
		catch(NoSuchElementException e)
		{
			System.out.println("go fish");
		}
		return null; 
	}//end get(id)
	
	/**
	 * Add a location to the database
	 * @param location the Location to be added
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void add(Location location)
	{
		 if(location != null)
		 { 
			 if(locationRepository.findByName(location.getName()).equals(Optional.empty()))
			 {
				 Location loc = locationRepository.save(location);
				 try
				 {
					 Location pLoc = locationRepository.findById(loc.getParent()).get(); 
					 Set s = pLoc.getChildren();
					 s.add(loc);
					 pLoc.setChildren(s);
					 locationRepository.save(pLoc);
				 }
				 catch(NoSuchElementException e) { }
				 
			 }//end if
		 }//end if
	}//end add
	
	public Iterable<Location> getAll(Integer id)
	{
		return locationRepository.findAll(id);
	}
	
	public Iterable<Location> getRoots(Integer id)
	{
		return locationRepository.findRoots(id); 
	}
}//end LocationService
