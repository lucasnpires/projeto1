package br.com.lucas.io.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.lucas.io.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
	
	Role findByName(String name);

}
