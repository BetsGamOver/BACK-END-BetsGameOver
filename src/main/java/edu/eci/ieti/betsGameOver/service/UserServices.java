package edu.eci.ieti.betsGameOver.service;

import edu.eci.ieti.betsGameOver.model.Usuario;
import edu.eci.ieti.betsGameOver.persistence.GameOverException;
import edu.eci.ieti.betsGameOver.persistence.GameoverPersistence;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServices {
	
    @Resource(name = "gameoverPersistence")
	GameoverPersistence gameoverPersistence;

    public Usuario getUserByUsername(String username) throws GameOverException {
        return gameoverPersistence.getUserByUsername(username);
    }
}