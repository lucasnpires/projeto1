package br.com.lucas.io.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import br.com.lucas.io.entity.Role;
import br.com.lucas.io.entity.User;
import br.com.lucas.io.repository.RoleRepository;
import br.com.lucas.io.repository.UserRepository;

@Component
public class DataInitializr implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleRepository roleRepository;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		
		List<User> users = userRepository.findAll();

		if (users.isEmpty()) {
			createUser("Admin", "admin@admin.com.br", "Ativo");
			createUser("Lucas", "npires.lucas@gmail.com", "Ativo");
			createUser("Joao", "joao@gmail.com.br", "Desabilitado");
			
			createRole("Administrador");
			createRole("Manutenção");
		}
		
		findByName();
		System.out.println("#######################");
		
		findByNameIgnoreCase();
		
		findByNameIgnoreCaseLike();
		
		findByEmailQualquerCoisa();
		
//		findAllByStatus();
//		getOneByIdAndDelete("2");
	}

	private void findByEmailQualquerCoisa() {
		User user = userRepository.findByEmailQualquerCoisa("npires.lucas@gmail.com");
		System.out.println("EMAIL ENCONTRADO: "+user.getEmail());
		System.out.println("NOME DO USUÁRIO DO EMAIL: "+user.getName());
	}

	private void findByNameIgnoreCaseLike() {
		User user = userRepository.findByNameIgnoreCaseLike("lu");
		System.out.println("NOME ENCONTRADO NO findByNameIgnoreCaseLike: "+user.getName());
	}

	private void findByNameIgnoreCase() {
		User user = userRepository.findByNameIgnoreCase("lucas");
		System.out.println("NOME ENCONTRADO NO findByNameIgnoreCase: "+user.getName());
	}
	
	private void findByName() {
		User user = userRepository.findByName("Lucas");
		System.out.println("NOME DO USUARIO ENCONTRADO: "+user.getName());
	}
	
	public void createUser(String name, String email, String status) {
		User user = new User(name, email,status);
		userRepository.save(user);
	}
	
	private void createRole(String name) {
		Role role = new Role(name);
		roleRepository.save(role);
		
	}
	
//	private void getOneByIdAndDelete(String id) {
//		Optional<User> user = userRepository.findById(id);
//		System.out.println("USUÁRIO A SER EXCLUÍDO: "+user.get().getName());
//		userRepository.deleteById(id);
//	}
	

//	private void findAllByStatus() {
//		List<User> usersAtivos = userRepository.findAllByStatus("Ativo");
//		System.out.println("#######################");
//		System.out.println("USUÁRIOS ATIVOS");
//		usersAtivos.forEach(user ->{
//			System.out.println("#######################");
//			System.out.println("CÓDIGO: "+user.getId());
//			System.out.println("NOME: "+user.getName());
//			System.out.println("EMAIL: "+user.getEmail());
//			System.out.println("#######################");
//		});
//		System.out.println("QUANTIDADE DE USUÁRIOS ATIVOS: "+usersAtivos.size());
//	}

}
