package locomanage.alicen.zschokke.repositories;

/* IMPORTS */
import org.springframework.data.repository.CrudRepository;

import locomanage.alicen.zschokke.entities.Manufacturer;

/**
 * ManufacturerRepository extends CrudRepository to handle db access for Manufacturer entities with an Integer primary key.
 * @author Alicen Zschokke
 */
public interface ManufacturerRepository extends CrudRepository<Manufacturer, Integer>
{
	/**
	 * Retrieves all the Manufacturers from the database.
	 * @return an Iterable of Manufacturer entities from the database
	 */
	public Iterable<Manufacturer> findAll(); 
}
