package locomanage.alicen.zschokke.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import locomanage.alicen.zschokke.entities.Railroad;

public interface RailroadRepository extends CrudRepository<Railroad, Integer>
{
	public Iterable<Railroad> findAll(); 
	
	public Optional<Railroad> findByName(String name); 
}
