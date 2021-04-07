package locomanage.alicen.zschokke.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import locomanage.alicen.zschokke.entities.RollingStock;

public interface RollingStockRepository extends CrudRepository<RollingStock, Integer>
{
	public List<RollingStock> findAll(); 
	
	@Query("SELECT r FROM RollingStock r WHERE r.inChain = 0")
	public List<RollingStock> findAvailable(); 
}
