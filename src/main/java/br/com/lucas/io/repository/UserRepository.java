package br.com.lucas.io.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.lucas.io.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	User findByName(String name);
	
	User findByEmail(String email);
	
	@Query("select u from User u where u.status = ?1")
	List<User> findAllByStatus(String status);

}
