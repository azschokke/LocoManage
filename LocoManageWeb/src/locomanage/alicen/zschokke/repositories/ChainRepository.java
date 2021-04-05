package locomanage.alicen.zschokke.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import locomanage.alicen.zschokke.entities.Chain;

public interface ChainRepository extends CrudRepository<Chain, Integer>{
	public List<Chain> findAll(); 
}
