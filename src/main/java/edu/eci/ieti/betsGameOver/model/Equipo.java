package edu.eci.ieti.betsGameOver.model;

import edu.eci.ieti.betsGameOver.dto.EquipoDto;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.UUID;

@Document(collection = "team")
public class Equipo {
	
    @Id
    public String teamId;
    public String teamName;
    public Deporte sport;
    public int noPlayers;
    private List<Jugador> jugadores;
    private List<Partida> partidas;

    public Equipo(EquipoDto equipoDto) {
        this.teamId = UUID.randomUUID().toString();
        this.teamName = equipoDto.getTeamName();
        this.sport = equipoDto.getSport();
        this.noPlayers = equipoDto.getNoPlayers();
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Deporte getSport() {
        return sport;
    }

    public void setSport(Deporte sport) {
        this.sport = sport;
    }

    public int getNoPlayers() {
        return noPlayers;
    }

    public void setNoPlayers(int noPlayers) {
        this.noPlayers = noPlayers;
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }
    public void setJugadores(List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }
    public List<Partida> getPartidas() {
        return partidas;

    }

    public void setPartidas(List<Partida> partidas) {
        this.partidas = partidas;
    }

    public void update(EquipoDto equipoDto){
        this.teamName = equipoDto.getTeamName();
        this.sport = equipoDto.getSport();
        this.noPlayers = equipoDto.getNoPlayers();
    }

    @Override
    public String toString() {
        return "Equipo{" +
                "teamId='" + teamId + '\'' +
                ", teamName='" + teamName + '\'' +
                ", sport=" + sport +
                ", noPlayers=" + noPlayers +
                '}';
    }
}