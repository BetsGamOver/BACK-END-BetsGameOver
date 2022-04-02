package edu.eci.ieti.betsGameOver.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import edu.eci.ieti.betsGameOver.model.Partida;

@Repository("partidaRepository")
public interface PartidaRepository extends MongoRepository<Partida, String>{

}