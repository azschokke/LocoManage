package locomanage.alicen.zschokke.repositories;

import org.springframework.data.repository.CrudRepository;

import locomanage.alicen.zschokke.entities.Scale;

public interface ScaleRepository extends CrudRepository<Scale, Integer>
{
	public Iterable<Scale> findAll(); 
}
