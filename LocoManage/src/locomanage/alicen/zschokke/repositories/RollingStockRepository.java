package locomanage.alicen.zschokke.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import locomanage.alicen.zschokke.entities.RollingStock;

public interface RollingStockRepository extends CrudRepository<RollingStock, Integer>{
	public List<RollingStock> findAll(); 
}
