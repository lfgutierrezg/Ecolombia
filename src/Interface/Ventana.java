/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Interface;

import Codigo.*;
import Codigo.Eco_lombia;
import Codigo.NewsSection;
import Interface.Inicio;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;

/**
 *
 * @author felipe-c4
 */
public class Ventana extends javax.swing.JFrame {
     public HashUsuario Usuarios;
     public NewsSection noticias;
     public DynamicArray<Flora> flora = new DynamicArray<>(10);
     public DynamicArray<Fauna> fauna = new DynamicArray<>(10);
     public DynamicArray<Ecoparque> ecoparque = new DynamicArray<>(10);
     public Inicio inicio;
    public Ventana(HashUsuario Usuarios,NewsSection noticias,DynamicArray<Flora> flora,DynamicArray<Fauna> fauna,DynamicArray<Ecoparque> ecoparque) {
        initComponents();
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.Usuarios=Usuarios;
        this.noticias=noticias; 
        this.flora=flora;
        this.fauna=fauna;
        this.ecoparque=ecoparque;
        
        
       // Eco_lombia.insertarFaunas(this.fauna);
        //Eco_lombia.insertarFloras(this.flora);
       // Eco_lombia.insertarEcoparques(this.ecoparque);
        Eco_lombia.InsetUsuarios(Usuarios);
        this.inicio= new Inicio(this,noticias);
        this.setVisible(true);   
    }
    
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ECOLOMBIA");
        setResizable(false);
        setType(java.awt.Window.Type.UTILITY);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1000, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        }//GEN-LAST:event_formWindowClosed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        Eco_lombia.exit(this.flora, this.ecoparque, this.fauna);
        Eco_lombia.SalirUsuarios(this.Usuarios);


    }//GEN-LAST:event_formWindowClosing

    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
