package edu.eci.ieti.betsGameOver.repository;

import edu.eci.ieti.betsGameOver.model.Equipo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository("equipoRepository")
public interface EquipoRepository extends MongoRepository<Equipo, String> {
	
}