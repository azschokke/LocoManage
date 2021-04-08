package locomanage.alicen.zschokke.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import locomanage.alicen.zschokke.entities.Classification;

/**
 * Extends CrudRepository, specific to Classification. 
 * @author Alicen Zschokke
 */
public interface ClassificationRepository extends CrudRepository<Classification, Integer>
{
	/**
	 * Returns an Iterable of all the Classifications in the database. 
	 */
	public Iterable<Classification> findAll(); 
	
	/**
	 * Returns an Optional, with type Classification, containing the Classification found by parameter name.
	 * @param name the String name of the Classification to retrieve
	 * @return An Optional containing the Classification, or an empty Optional if none exists. 
	 */
	public Optional<Classification> findByNameIgnoreCase(String name); 
}//end ClassificationRepository