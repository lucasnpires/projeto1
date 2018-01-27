package br.com.lucas.io.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import br.com.lucas.io.entity.User;
import br.com.lucas.io.repository.UserRepository;

@Component
public class DataInitializr implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	UserRepository userRepository;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		
		List<User> users = userRepository.findAll();

		if (users.isEmpty()) {
			createUser("Admin", "admin@admin.com.br");
			createUser("Lucas", "npires.lucas@gmail.com");
			createUser("Joao", "joao@gmail.com.br");
		}
		
		User userLucas = userRepository.getOne(2L);
		System.out.println("USUÁRIO A SER DELETADO: "+userLucas.getName());
		
		userRepository.delete(userLucas);
		
	}
	
	public void createUser(String name, String email) {
		User user = new User(name, email);
		userRepository.save(user);
	}

}
