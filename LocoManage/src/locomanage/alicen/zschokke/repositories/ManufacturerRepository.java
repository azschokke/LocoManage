package locomanage.alicen.zschokke.repositories;

import org.springframework.data.repository.CrudRepository;

import locomanage.alicen.zschokke.entities.Manufacturer;

public interface ManufacturerRepository extends CrudRepository<Manufacturer, Integer>
{
	public Iterable<Manufacturer> findAll(); 
}
