package locomanage.alicen.zschokke.repositories;

import org.springframework.data.repository.CrudRepository;

import locomanage.alicen.zschokke.entities.User;

public interface UserRepository extends CrudRepository<User, Integer> 
{
	public User findUserById(Integer id);

	public User findByUsername(String username);
}//end UserRepository