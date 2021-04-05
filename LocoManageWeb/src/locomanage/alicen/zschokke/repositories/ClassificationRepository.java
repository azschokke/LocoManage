package locomanage.alicen.zschokke.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import locomanage.alicen.zschokke.entities.Classification;

/**
 * Extends CrudRepository, specific to Classification. 
 * @author Alicen Zschokke
 *
 */
public interface ClassificationRepository extends CrudRepository<Classification, Integer>
{
	public Iterable<Classification> findAll(); 
	
	public Optional<Classification> findByNameIgnoreCase(String name); 
}//end ClassificationRepository