package edu.eci.ieti.betsGameOver.service;

import edu.eci.ieti.betsGameOver.model.*;
import edu.eci.ieti.betsGameOver.persistence.GameOverException;
import edu.eci.ieti.betsGameOver.persistence.GameoverPersistence;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("betsGameOverService")
public class BetsGameOverService extends UserServices{

    private GameoverPersistence gameoverPersistence;

    public String helloWorld(){
        return "Hello World Hola Mundo";
    }

    public void updateUser(Usuario user) throws GameOverException {
        gameoverPersistence.updateUser(user);
    }

    public List<Partida> findPartidaByDateAndActivo(Date fecha){
        return gameoverPersistence.findPartidaByDateAndActivo(fecha);
    }

    public List<Partida> getAllPartidas(){
        return gameoverPersistence.getAllPartidas();
    }
}