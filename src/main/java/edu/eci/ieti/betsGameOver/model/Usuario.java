package edu.eci.ieti.betsGameOver.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Document(collection = "user")
public class Usuario {

    @Id
    public String userId;
    public String username;
    public String nombreCompleto;
    public String direccionResidencia;
    public String password;
    public String email;
    public String numero;
    public Deporte deporteFavorito;
    public Equipo equipoFavorito;
    public List<Partida> resultados;

    public Usuario(){}

    public Usuario(String username, String nombreCompleto, String direccionResidencia, String password, String email, String numero, Deporte deporteFavorito, Equipo equipoFavorito) {
        this.username = username;
        this.nombreCompleto = nombreCompleto;
        this.direccionResidencia = direccionResidencia;
        this.password = password;
        this.email = email;
        this.numero = numero;
        this.deporteFavorito = deporteFavorito;
        this.equipoFavorito = equipoFavorito;
            List<Partida> resultados = new ArrayList<Partida>();
    }

    public List<Partida> getResultados() { return resultados; }

    public void setResultados(List<Partida> resultados) { this.resultados = resultados; }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDireccionResidencia() {
        return direccionResidencia;
    }

    public void setDireccionResidencia(String direccionResidencia) {
        this.direccionResidencia = direccionResidencia;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Deporte getDeporteFavorito() {
        return deporteFavorito;
    }

    public void setDeporteFavorito(Deporte deporteFavorito) {
        this.deporteFavorito = deporteFavorito;
    }

    public Equipo getEquipoFavorito() {
        return equipoFavorito;
    }

    public void setEquipoFavorito(Equipo equipoFavorito) {
        this.equipoFavorito = equipoFavorito;
    }

    public void changeValues(Usuario user){
        this.password = user.password;
        this.direccionResidencia = user.direccionResidencia;
        this.numero = user.numero;
        this.email = user.email;
        this.deporteFavorito = user.deporteFavorito;
        this.equipoFavorito = user.equipoFavorito;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "userId='" + userId + '\'' +
                ", username='" + username + '\'' +
                ", nombreCompleto='" + nombreCompleto + '\'' +
                ", direccionResidencia='" + direccionResidencia + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", numero='" + numero + '\'' +
                ", deporteFavorito=" + deporteFavorito +
                ", equipoFavorito=" + equipoFavorito +
                '}';
    }
}