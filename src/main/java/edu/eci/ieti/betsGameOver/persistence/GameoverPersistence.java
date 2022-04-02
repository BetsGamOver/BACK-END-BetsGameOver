package edu.eci.ieti.betsGameOver.persistence;

import edu.eci.ieti.betsGameOver.dto.DeporteDto;
import edu.eci.ieti.betsGameOver.dto.EquipoDto;
import edu.eci.ieti.betsGameOver.model.Deporte;
import edu.eci.ieti.betsGameOver.model.Equipo;
import edu.eci.ieti.betsGameOver.model.Partida;
import edu.eci.ieti.betsGameOver.model.Usuario;
import edu.eci.ieti.betsGameOver.repository.UserRepository;

import java.util.List;

import javax.annotation.Resource;

import java.util.Date;

public interface GameoverPersistence {
	
    List<Partida> findPartidaByDateAndActivo(Date fecha);

    List<Partida> getAllPartidas();

    Usuario saveUser(Usuario usuario);

    Usuario getUserByUsername(String username) throws GameOverException;

    void updateUser(Usuario user) throws GameOverException;

    Equipo addTeam(EquipoDto equipoDto) throws GameOverException;

    Equipo getTeamByID(String id) throws GameOverException;

    List<Equipo> getAllTeams();

    Boolean deleteTeam(String id) throws GameOverException;

    Equipo updateTeam(EquipoDto equipoDto, String Id) throws GameOverException;

    Deporte addSport(DeporteDto deporteDto) throws GameOverException;

    Deporte getSportByID(String id) throws GameOverException;

    List<Deporte> getAllSports();

    Boolean deleteSport(String id) throws  GameOverException;

    List<String> findResult(Usuario user) throws GameOverException;
}