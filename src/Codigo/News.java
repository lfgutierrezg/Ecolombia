/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Codigo;

/**
 *
 * @author Usuario
 */
import java.io.File;

import javax.swing.JLabel;
/**
 *
 * @author Usuario
 */
public class News {
    private String Title;
    private String Descrip;
    private String FontIma;    
    
    private int a;
    
    public News(  String tTitle, String tDescription, String tImagen ) {
        this.Title = tTitle;
        this.FontIma = tImagen;
        this.Descrip=tDescription;
        
    }
    
   
    
    
    public String getTitle() {
        return Title;
    }
    
  
    
     public String getDescrip() {
        return Descrip;
    }
     
     public String getFontIma() {
        return FontIma;
    }
     
   
     @Override
    public String toString() {
        return Title+"-"+Descrip+"-"+FontIma;
    }
}