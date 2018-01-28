package br.com.lucas.io.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.lucas.io.entity.Role;

public interface RoleRepository extends MongoRepository<Role, String>{
	
	Role findByName(String name);

}
