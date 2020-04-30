package Codigo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

 * @author danie
 */
public class Ecoparque {
    String nombre;
    String ubicacion;
    String ecosistema;
    String interes;
    
    public Ecoparque(String nombre, String ubicacion, String ecosistema, String interes) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.ecosistema = ecosistema;
        this.interes = interes;
    }
    
    @Override
    public String toString() {
        return "El Ecoparque "+ nombre + " Se encuentra ubicado en "+ ubicacion +" y posee el ecosistema de "+ ecosistema;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getEcosistema() {
        return ecosistema;
    }

    public void setEcosistema(String ecosistema) {
        this.ecosistema = ecosistema;
    }

    public String getInteres() {
        return interes;
    }

    public void setInteres(String interes) {
        this.interes = interes;
    }
    
}
