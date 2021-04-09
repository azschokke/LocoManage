package locomanage.alicen.zschokke.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import locomanage.alicen.zschokke.entities.Chain;
import locomanage.alicen.zschokke.entities.Location;

/**
 * Chain repository, extends CrudRepository for use with Chain objects and Integer unique id.
 * @author Alicen Zschokke
 *
 */
public interface ChainRepository extends CrudRepository<Chain, Integer>
{
	/**
	 * Returns a List of all the Chains in the database. 
	 */
	@Query("SELECT c from Chain c WHERE c.userId = ?1")
	public List<Chain> findAll(Integer id); 
	
	/**
	 * Returns a List of all the Chains in the database. 
	 */
	@Query("SELECT c from Chain c WHERE c.location = ?1")
	public List<Chain> findChainByLocation(Location location); 
}
