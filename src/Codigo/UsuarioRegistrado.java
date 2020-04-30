package Codigo;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author felipe-c4
 */
public class UsuarioRegistrado {
    private String correo;
    private String password;
    private String institucion;
    private String Profesion;
    private String Nombres;
    private String Apellidos;
    private String id;

    public UsuarioRegistrado(String correo, String password, 
            String institucion, String Profesion, String Nombres, String Apellidos,String id) {
        
        this.correo = correo;
        this.password = password;
        this.institucion = institucion;
        this.Profesion = Profesion;
        this.Nombres = Nombres;
        this.Apellidos = Apellidos;
        this.id = id;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

    public String getProfesion() {
        return Profesion;
    }

    public void setProfesion(String Profesion) {
        this.Profesion = Profesion;
    }

    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String Nombres) {
        this.Nombres = Nombres;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    
}
