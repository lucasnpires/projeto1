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
			User userAdmin = new User();
			userAdmin.setNome("admin");
			userAdmin.setEmail("admin@admin.com.br");
			userRepository.save(userAdmin);
		}
	}

}
