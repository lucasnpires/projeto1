package br.com.lucas.io.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import br.com.lucas.io.entity.User;

public interface UserRepository extends MongoRepository<User, String>{
	
	User findByName(String name);
	
	@Query("{ 'email' : ?0 }")
	User findByEmailQualquerCoisa(String email);
	
//	@Query("select u from User u where u.status = ?1")
//	List<User> findAllByStatus(String status);
	
	User findByNameIgnoreCase(String name);
	
	User findByNameIgnoreCaseLike(String name);

}
