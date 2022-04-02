package edu.eci.ieti.betsGameOver.repository;

import edu.eci.ieti.betsGameOver.model.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository("betRepository")
public interface BetRepository extends MongoRepository<Usuario, String> {
	
}