package com.example.springJPA.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.example.springJPA.entity.User;
import com.example.springJPA.repository.UserRepository;

/**
 * Implementa a inicializacao de dados nas tabelas criadas pela aplicacao 
 * Executa apenas na inicializacao da aplicacao */

@Component
public class DataInitialize implements ApplicationListener<ContextRefreshedEvent>{

	@Autowired
	UserRepository userRepository;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		System.out.println("Entrou DataInitialize...");
		
		List<User> users = userRepository.findAll();
		if (users.isEmpty()) {
			
			User user = new User();
			user.setName("Rogerio Souza");
			user.setEmail("radsouza@gmail.com");
			userRepository.save(user);
			
			createUser("Marcia Gravina", "marcia.gravina@gmail.com");
			createUser("Jose Verdan", "jose.verdan@gmail.com");
			createUser("Zeth Souza", "zeth.souza@gmail.com");
			createUser("Ely Gravina", "ely.gravina@gmail.com");
		}
		
		// MSQL - getOne
		/*
		try {
			User user2 = userRepository.getOne(8L); // Busca o id 3 na base - L de long 
			System.out.println("Pesquisando user Id 8...");
			System.out.println("Usuario pesquisado - Id [" + user2.getId() + "] - Nome [" + user2.getName() + "] - [" + user2.getEmail() + "]");
			
			System.out.println("Excluindo user Id 8...");
			userRepository.deleteById(8L);
	
			System.out.println("Tentando pesquisar user Id 8...");
			user2 = userRepository.getOne(8L); 
			System.out.println("Usuario pesquisado - Id [" + user2.getId() + "] - Nome [" + user2.getName() + "] - [" + user2.getEmail() + "]");
			
		} catch (Exception e) {
			System.out.println("Falha ao pesquisar user Id 8 - Error -> [" + e + "]");
		}
		
		try {
			User user2 = userRepository.getOne(10L); 
			System.out.println("Pesquisando user Id 10...");
			System.out.println("Usuario pesquisado - Id [" + user2.getId() + "] - Nome [" + user2.getName() + "] - [" + user2.getEmail() + "]");
			
			System.out.println("Alterando user Id 10...");
			if (user2.getName().equalsIgnoreCase("Zeth Souza")) {
				user2.setName("Zeth Arcanjo Souza");
			} else {
				user2.setName("Zeth Souza");
			}
			userRepository.save(user2);
	
			System.out.println("Tentando pesquisar user Id 10...");
			user2 = userRepository.getOne(10L); 
			System.out.println("Usuario pesquisado - Id [" + user2.getId() + "] - Nome [" + user2.getName() + "] - [" + user2.getEmail() + "]");
			
		} catch (Exception e) {
			System.out.println("Falha ao pesquisar user Id 10 - Error -> [" + e + "]");
		}
		*/
		
		try {
			User user2 = userRepository.findByName("Jose Verdan"); 
			System.out.println("Pesquisando user pelo nome - Jose Verdan...");
			System.out.println("Usuario pesquisado - Id [" + user2.getId() + "] - Nome [" + user2.getName() + "] - [" + user2.getEmail() + "]");
		} catch (Exception e) {
			System.out.println("Falha ao pesquisar user pelo Nome - Jose - Error -> [" + e + "]");
		}		
		
		try {
			User user2 = userRepository.findByName2("Jose Verdan"); 
			System.out.println("Pesquisando user pelo nome - Jose Verdan usando o metodo findByName2...");
			System.out.println("Usuario pesquisado - Id [" + user2.getId() + "] - Nome [" + user2.getName() + "] - [" + user2.getEmail() + "]");
		} catch (Exception e) {
			System.out.println("Falha ao pesquisar user pelo Nome - Jose - Error -> [" + e + "]");
		}		
		
		try {
			User user2 = userRepository.findByNameLike("Verdan"); 
			System.out.println("Pesquisando user pelo nome com like - Verdan...");
			System.out.println("Usuario pesquisado - Id [" + user2.getId() + "] - Nome [" + user2.getName() + "] - [" + user2.getEmail() + "]");
		} catch (Exception e) {
			System.out.println("Falha ao pesquisar user pelo Nome com like - Error -> [" + e + "]");
		}			
		
		try {
			User user2 = userRepository.findByEmail("radsouza@gmail.com"); 
			System.out.println("Pesquisando pelo email - radsouza@gmail.com...");
			System.out.println("Usuario pesquisado - Id [" + user2.getId() + "] - Nome [" + user2.getName() + "] - [" + user2.getEmail() + "]");
		} catch (Exception e) {
			System.out.println("Falha ao pesquisar user pelo email - Error -> [" + e + "]");
		}	
		
		try {
			User user2 = userRepository.findByNameAndEmail("Jose Verdan", "radsouza@gmail.com"); 
			System.out.println("Pesquisando pelo nome e email - Jose Verdan e radsouza@gmail.com...");
			System.out.println("Usuario pesquisado - Id [" + user2.getId() + "] - Nome [" + user2.getName() + "] - [" + user2.getEmail() + "]");
		} catch (Exception e) {
			System.out.println("Falha ao pesquisar user pelo nome e email - Error -> [" + e + "]");
		}			

		try {
			User user2 = userRepository.findByNameAndEmail("Rogerio Souza", "radsouza@gmail.com"); 
			System.out.println("Pesquisando pelo nome e email - Rogerio Souza e radsouza@gmail.com...");
			System.out.println("Usuario pesquisado - Id [" + user2.getId() + "] - Nome [" + user2.getName() + "] - [" + user2.getEmail() + "]");
		} catch (Exception e) {
			System.out.println("Falha ao pesquisar user pelo nome e email - Error -> [" + e + "]");
		}			
		
	}
	
	public void createUser(String name, String email) {
		User user = new User(name, email);
		userRepository.save(user);
	}

}
