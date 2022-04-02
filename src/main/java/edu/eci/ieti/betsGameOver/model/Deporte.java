package edu.eci.ieti.betsGameOver.model;

import edu.eci.ieti.betsGameOver.dto.DeporteDto;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document(collection = "sport")
public class Deporte {
	
    @Id
    public String sportId;
    public String sportName;

    public Deporte(DeporteDto deporteDto) {
        this.sportId = UUID.randomUUID().toString();
        this.sportName = deporteDto.getSportName();
    }

    public String getSportId() {
        return sportId;
    }

    public void setSportId(String sportId) {
        this.sportId = sportId;
    }

    public String getSportName() {
        return sportName;
    }

    public void setSportName(String sportName) {
        this.sportName = sportName;
    }

    public void update(DeporteDto deporteDto){
        this.sportName = deporteDto.getSportName();
    }

    @Override
    public String toString() {
        return "Deporte{" +
                "sportId='" + sportId + '\'' +
                ", sportName='" + sportName + '\'' +
                '}';
    }
}