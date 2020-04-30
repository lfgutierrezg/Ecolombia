/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Codigo;
import java.io.File;
/**
 *
 * @author Usuario
 */
public class DBEcoparks {
    private String Name;
    private String Ubication;    
    private String Ecosystem;
    private String Intereses;
    
    public DBEcoparks(String scName, String tIntereses, String tUbication, String tEcosystem) {
        this.Ubication = tUbication;
        this.Name=scName;
        this.Ecosystem=tEcosystem;
        this.Intereses= tIntereses;
    }
    
    @Override
    public String toString() {
        return Name + "     "+Ubication+"       "+Ecosystem+"       "+Intereses;
    }
    
    public String getEcosystem() {
        return Ecosystem;
    }
    
    public String getName() {
        return Name;
    }
    
    public String getIntereses() {
        return Intereses;
    }
    
     public String getUbication() {
        return Ubication;
    }
}
