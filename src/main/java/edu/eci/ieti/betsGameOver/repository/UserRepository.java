package edu.eci.ieti.betsGameOver.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import edu.eci.ieti.betsGameOver.model.User;

@Repository("userRepository")
public interface UserRepository extends MongoRepository<User, String>{
	
	@Query("{id:'?0'}")
	User findUserById(String id);
	
}