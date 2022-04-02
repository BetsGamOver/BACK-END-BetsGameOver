package edu.eci.ieti.betsGameOver.model;

import java.util.Date;

public class Partida {

    private String ID;
    private String name;
    private Equipo equipo1;
    private Equipo equipo2;
    private Date fecha;
    private boolean activo;
    private String marcador;

    public Partida(String id, String name, Equipo equipo1, Equipo equipo2, Date fecha, boolean activo) {
        ID = id;
        this.name = name;
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.fecha = fecha;
        this.activo = activo;
    }

    public String getMarcador() { return marcador; }

    public void setMarcador(String marcador) { this.marcador = marcador; }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Equipo getEquipo1() {
        return equipo1;
    }

    public void setEquipo1(Equipo equipo1) {
        this.equipo1 = equipo1;
    }

    public Equipo getEquipo2() {
        return equipo2;
    }

    public void setEquipo2(Equipo equipo2) {
        this.equipo2 = equipo2;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}