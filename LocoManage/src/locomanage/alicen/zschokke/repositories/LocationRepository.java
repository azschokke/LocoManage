package locomanage.alicen.zschokke.repositories;

/* IMPORTS */
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import locomanage.alicen.zschokke.entities.Location;

/**
 * LocationRepository extends CrudRepository to handle Database Access for Location Objects with an Integer Unique id
 * @author Alicen Zschokke
 */
@Repository
public interface LocationRepository extends CrudRepository<Location, Integer>
{
	/**
	 * Retrieves an Optional containing a Location from the database by parameter name.
	 * @param name the name of the location to be retrieved
	 * @return an Optional containing the Location from the database with the given name, or an empty Optional if no match is found
	 */
	public Optional<Location> findByName(String name);
	
	/**
	 * Retrieves all the locations from the database.
	 * @return an Iterable of all the Locations in the database
	 */
	@Query("SELECT l FROM Location l WHERE l.userId = ?1")
	public Iterable<Location> findAll(Integer id);
	
	/**
	 * Retrieves all the Locations that do not have a parent Location in the database
	 * @return an Iterable of Location entities
	 */
	@Query("SELECT l FROM Location l WHERE l.parentId = 0 AND l.userId=?1")
	public Iterable<Location> findRoots(Integer id);
}
