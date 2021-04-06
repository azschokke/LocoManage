package locomanage.alicen.zschokke.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import locomanage.alicen.zschokke.entities.Location;

@Repository
public interface LocationRepository extends CrudRepository<Location, Integer>
{
	public Optional<Location> findByName(String name);
	
	public Iterable<Location> findAll();
	
	@Query("SELECT l FROM Location l WHERE l.parentId = 0")
	public Iterable<Location> findRoots();
}
