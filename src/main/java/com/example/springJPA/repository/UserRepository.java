package com.example.springJPA.repository;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query; // MySQL
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.springJPA.entity.User;

/**
 *  Habilita o uso de repositorio (metodos com querys pre-definidas) para a entidade User */

// public interface UserRepository extends JpaRepository<User, Long> {  // MYSQL usage
public interface UserRepository extends MongoRepository<User, Long> {	// Mongo Usage
	
	User findByName(String name); /* usa o Name de findByName para pesquisar por esta coluna no banco de dados */
	User findByEmail(String email);
	User findByNameAndEmail(String name, String email);
	User findByNameIgnoreCase(String name);
	/* Veja DOC do spring JPA para mais construções */
	
	// Apenas MYSQL
	//@Query("select u from User u where u.name = ?1")
	//User findByName2(String name); /* Opcao de uso construindo a query */
	
	//@Query("select u from User u where u.name like %?1%")
	//User findByNameLike(String name); 	
		
	// Apenas mongoDB
	@Query("{ 'name' : ?0 }")
	User findByName2(String name); /* Opcao de uso construindo a query */	
	
	@Query("{ 'name' : {$regex : ?0 } }")
	User findByNameLike(String name); 		
	
}
