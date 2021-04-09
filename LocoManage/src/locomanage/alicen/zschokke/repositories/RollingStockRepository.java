package locomanage.alicen.zschokke.repositories;

/* IMPORTS */
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import locomanage.alicen.zschokke.entities.RollingStock;

/**
 * RollingStockRepository extends CrudRepository to handle db access for RollingStock entities. 
 * @author Alicen Zschokke
 */
public interface RollingStockRepository extends CrudRepository<RollingStock, Integer>
{
	/**
	 * Returns a List of all the RollingStock in the database.
	 * @return a List of RollingStock
	 */
	@Query("SELECT r FROM RollingStock r WHERE r.userId = ?1")
	public List<RollingStock> findAll(Integer id); 
	
	/**
	 * Returns a List of all the RollingStock not in a chain in the database. 
	 * @return a List of RollingStock
	 */
	@Query("SELECT r FROM RollingStock r WHERE r.inChain = 0 AND r.userId = ?1")
	public List<RollingStock> findAvailable(Integer id); 
}
