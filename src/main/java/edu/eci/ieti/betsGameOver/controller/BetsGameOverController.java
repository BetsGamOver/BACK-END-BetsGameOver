package edu.eci.ieti.betsGameOver.controller;

import java.util.List;
import java.util.Date;

import javax.annotation.Resource;

import edu.eci.ieti.betsGameOver.model.Partida;
import edu.eci.ieti.betsGameOver.model.Usuario;
import edu.eci.ieti.betsGameOver.persistence.GameOverException;
import edu.eci.ieti.betsGameOver.service.BetsGameOverService;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/betsgameover")
public class BetsGameOverController {

    @Resource(name = "betsGameOverService")
    private BetsGameOverService betsGameOverService;

    @RequestMapping("/helloworld")
    public String helloWorld() {
        return betsGameOverService.helloWorld();
    }

    @GetMapping
    public List<Partida> getAll(){
        return betsGameOverService.getAllPartidas();
    }

    @GetMapping("/partidasRecientes")
    public List<Partida> findPartidaByDateAndActivo(@PathVariable Date fecha) {
        return betsGameOverService.findPartidaByDateAndActivo(fecha);
    }

    @GetMapping( "/{name}" )
    public Usuario findByName(@PathVariable String name) throws GameOverException {
        return betsGameOverService.getUserByUsername(name);
    }

    @PutMapping()
    public void update(@RequestBody Usuario usuario) throws GameOverException {
    	betsGameOverService.updateUser(usuario);
    }
}