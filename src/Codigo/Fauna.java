package Codigo;




public class Fauna {
    String nombre_cientifico;
    String nombre_comun;
    String ubicacion;
    String ecosistema;
    String filo;
    String clase;
    String orden;
    String familia;
    String genero;
    String alimentacion;
    String depredador;
    String especie;

    public Fauna(String nombre_cientifico, String nombre_comun, String ubicacion, String ecosistema, String filo, String clase, String orden, String familia, String genero, String alimentacion, String depredador, String especie) {
        this.nombre_cientifico = nombre_cientifico;
        this.nombre_comun = nombre_comun;
        this.ubicacion = ubicacion;
        this.ecosistema = ecosistema;
        this.filo = filo;
        this.clase = clase;
        this.orden = orden;
        this.familia = familia;
        this.genero = genero;
        this.alimentacion = alimentacion;
        this.depredador = depredador;
        this.especie = especie;
    }

    @Override
    public String toString() {
        return "El nombre cientifico es "+ nombre_cientifico +
                "\nEl reino es Animalia"+
                "\nEl filo es "+ filo +
                "\nLa clase es "+ clase +
                "\nEl orden es " + orden +
                "\nLa familia es " + familia +
                "\nEl genero es " + genero + 
                "\nLa especie es " + especie +
                "\nHabita en el ecosistema de " + ecosistema +
                "\nSe ubica en " + ubicacion +
                "\nSe alimenta de " + alimentacion + 
                "\nEs depredado por " + depredador ;
    }

    public String getNombre_cientifico() {
        return nombre_cientifico;
    }

    public void setNombre_cientifico(String nombre_cientifico) {
        this.nombre_cientifico = nombre_cientifico;
    }

    public String getNombre_comun() {
        return nombre_comun;
    }

    public void setNombre_comun(String nombre_comun) {
        this.nombre_comun = nombre_comun;
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

    public String getFilo() {
        return filo;
    }

    public void setFilo(String filo) {
        this.filo = filo;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public String getOrden() {
        return orden;
    }

    public void setOrden(String orden) {
        this.orden = orden;
    }

    public String getFamilia() {
        return familia;
    }

    public void setFamilia(String familia) {
        this.familia = familia;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getAlimentacion() {
        return alimentacion;
    }

    public void setAlimentacion(String alimentacion) {
        this.alimentacion = alimentacion;
    }

    public String getDepredador() {
        return depredador;
    }

    public void setDepredador(String depredador) {
        this.depredador = depredador;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }
    
}
