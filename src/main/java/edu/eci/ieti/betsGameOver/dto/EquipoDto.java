package edu.eci.ieti.betsGameOver.dto;

import edu.eci.ieti.betsGameOver.model.Deporte;

public class EquipoDto {
	
    public String teamName;
    public Deporte sport;
    public int noPlayers;

    public EquipoDto() {

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
}