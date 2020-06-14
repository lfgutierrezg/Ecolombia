package Codigo;

/**
 *
 * @author danie
 */
public class Ecoparque {
    int id;
    String nombre;
    String ubicacion;
    String ecosistema;
    String interes;
    int busquedas;
   
    public Ecoparque(int busquedas){
        this.busquedas=busquedas;
    }
    
    public Ecoparque(int id, String nombre, String ubicacion, String ecosistema, String interes) {
        this.id=id;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.ecosistema = ecosistema;
        this.interes = interes;
        this.busquedas=0;
    }
    
//    @Override
//    public String toString() {
//        return "El Ecoparque "+ nombre + " Se encuentra ubicado en "+ ubicacion +" y posee el ecosistema de "+ ecosistema +""
//                + " id: "+id;
//    }
    
     @Override
    public String toString() {
        return  nombre + ";"+ ubicacion +";"+ ecosistema +";"+interes+";"+id;
    }
    
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
