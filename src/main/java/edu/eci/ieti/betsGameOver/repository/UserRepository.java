package edu.eci.ieti.betsGameOver.repository;

import edu.eci.ieti.betsGameOver.model.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository("userRepository")
public interface UserRepository extends MongoRepository<Usuario, String> {

}