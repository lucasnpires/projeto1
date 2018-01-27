package br.com.lucas.io.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.lucas.io.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
