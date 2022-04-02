package edu.eci.ieti.betsGameOver.controller;

import edu.eci.ieti.betsGameOver.model.Usuario;
import org.springframework.security.core.annotation.AuthenticationPrincipal;

public class BaseController {
	
    public Usuario getCurrentUser(@AuthenticationPrincipal Usuario user) {
        return user;
    }
}