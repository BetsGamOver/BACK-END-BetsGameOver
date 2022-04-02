package edu.eci.ieti.betsGameOver.repository;

import edu.eci.ieti.betsGameOver.model.Deporte;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository("deporteRepository")
public interface DeporteRepository extends MongoRepository<Deporte, String> {
	
}