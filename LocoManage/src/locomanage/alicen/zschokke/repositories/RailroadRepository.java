package locomanage.alicen.zschokke.repositories;

/* IMPORTS */
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import locomanage.alicen.zschokke.entities.Railroad;

public interface RailroadRepository extends CrudRepository<Railroad, Integer>
{
	/**
	 * Retrieves all the Railroad entities from the database
	 * @return an Iterable of Railroad entities
	 */
	public Iterable<Railroad> findAll(); 
	
	/**
	 * Retrieves an Optional containing the Railroad entity with the given name. 
	 * @param name the String name of the railroad to be retrieved
	 * @return An Optional containing the Railroad entity with the matching name, or an empty Optional if none was found
	 */
	public Optional<Railroad> findByName(String name); 
}
