package locomanage.alicen.zschokke.service;

import java.util.List;
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
	
	public void add(Location location)
	{
		 if(location != null)
		 { 
			 if(locationRepository.findByName(location.getName()).equals(Optional.empty()))
			 {
				 Location loc = locationRepository.save(location);
				 try
				 {
					 Location pLoc = locationRepository.findById(loc.getParent().getId()).get(); 
					 Set s = pLoc.getChildren();
					 s.add(loc);
					 pLoc.setChildren(s);
				 }
				 catch(NoSuchElementException e)
				 {
					 
				 }
				 
				 
			 }//end if
		 }//end if
	}//end add
	
	public Iterable<Location> getAll()
	{
		return locationRepository.findAll();
	}
	
	public Iterable<Location> getRoots()
	{
		return locationRepository.findRoots(); 
	}
}//end LocationService
