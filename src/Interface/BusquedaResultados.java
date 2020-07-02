/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Codigo.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author felipe-c4
 */
public class BusquedaResultados extends javax.swing.JPanel {
    
    JPanel Volverinicio;
    JPanel regresar;
    
    //
     //public JPanel panel;
    //public JPanel panel2;
    public JLabel buenas;
    public JLabel buenas1;
    public JLabel flTitle;
    public JLabel faTitle;
    public JLabel ecTitle;
    public JLabel nTitle;
    public int modo=0;
    public JButton prevButton;
    public JButton nextButton;

    public JButton Hinicio;
    public JRadioButton result10;
    public JRadioButton result15;
    public JRadioButton result20;
    
    DynamicArray<Flora> resFlora =new DynamicArray<>(10) ;
    DynamicArray<Fauna> resFauna =new DynamicArray<>(10)  ;
    DynamicArray<Ecoparque> resEcop =new DynamicArray<>(10) ;
    
    JLabel [] rFLName = new JLabel[20];
    
    JLabel [] rFLScName = new JLabel[20];
    JLabel [] rFLEcos = new JLabel[20];
    JLabel [] rFLUbic = new JLabel[20];
    PagerFlora PagFlora=new PagerFlora(resFlora);
    PagerFauna PagFauna = new PagerFauna(resFauna) ;
    PagerEcoparks PagEcop =new PagerEcoparks(resEcop);
   
    //
    public BusquedaResultados(JFrame ventana,JPanel inicio, JPanel regresar) {
        
        initComponents();
        
        this.Volverinicio = inicio;
        this.regresar= regresar;

        ventana.add(this);
        this.setVisible(false);
        
        this.setBounds(0, 0, 1000, 800);
        
    }
    private void Apriete() {
        int temporal=0;
        
        while (temporal<20){
           JLabel t = new JLabel();
           rFLName[temporal]= t;
           
           JLabel t1 = new JLabel();
           rFLScName[temporal]=t1;
           
           JLabel t2 = new JLabel();
           rFLEcos[temporal]=t2;
           
           JLabel t3 = new JLabel();
           rFLUbic[temporal]=t3;
           
           temporal++;
        }
        buenas=new JLabel();
        buenas.setBounds(200,470,150,30);
        buenas.setForeground(Color.WHITE);
        buenas.setOpaque(true);
        buenas.setBackground(Color.GREEN);
      buenas.setFont( new Font("Ancizar Sans",Font.BOLD,25));
      buenas.setVisible(true);
      
        for(int i= 0; i<rFLName.length;i++){
            rFLName[i].setBounds(150,50+40*i,170,40);
        rFLName[i].setForeground(Color.WHITE);
        rFLName[i].setBackground(Color.black);
        rFLName[i].setFont( new Font("Ancizar Sans",Font.BOLD,20));
           
           rFLScName[i].setBounds(335,50+40*i,170,40);
        rFLScName[i].setForeground(Color.white);
        rFLScName[i].setBackground(Color.black);
        rFLScName[i].setFont( new Font("Ancizar Sans",Font.PLAIN,20));
           
           
           rFLEcos[i].setBounds(520,50+40*i,170,40);
        rFLEcos[i].setForeground(Color.white);
        rFLEcos[i].setBackground(Color.black);
        rFLEcos[i].setFont( new Font("Ancizar Sans",Font.PLAIN,20));
           
           
           rFLUbic[i].setBounds(705,50+40*i,170,40);
        rFLUbic[i].setForeground(Color.white);
        rFLUbic[i].setBackground(Color.black);
        rFLUbic[i].setFont( new Font("Ancizar Sans",Font.PLAIN,20));
           
        }
             
             
        buenas1=new JLabel();
        buenas1.setBounds(10,270,500,60);
        buenas1.setForeground(Color.green);
        buenas1.setFont( new Font("Ancizar Sans",Font.BOLD,45));
        
        flTitle=new JLabel();
        flTitle.setBounds(160,140,170,30);
        flTitle.setForeground(Color.yellow);
        flTitle.setFont( new Font("Ancizar Sans",Font.BOLD,30));
        flTitle.setText("Flora");
        
        faTitle=new JLabel();
        faTitle.setBounds(345,140,170,30);
        //buenas1.setOpaque(true);
        faTitle.setForeground(Color.blue);
        faTitle.setFont( new Font("Ancizar Sans",Font.BOLD,30));
        faTitle.setText("Fauna");

        
        ecTitle=new JLabel();
        ecTitle.setBounds(530,140,170,30);
        ecTitle.setForeground(Color.red);
        ecTitle.setFont( new Font("Ancizar Sans",Font.BOLD,30));
        ecTitle.setText("Ecoparques");
        
        nTitle=new JLabel();
        nTitle.setBounds(160,140,170,30);
        nTitle.setForeground(Color.green);
        nTitle.setFont( new Font("Ancizar Sans",Font.BOLD,30));
        nTitle.setText("Flora");
        
             
           buenas.setText("Página: "+PagFlora.pageNum+" ");
           
           
           
    PagFlora.show20Results();
    PagFauna.show20Results();
    PagEcop.show20Results();

             
   result10= new JRadioButton("10 resultados",true);
   result10.setBounds(50,510,150,40);
   result10.setForeground(Color.white);
   result10.setOpaque(true);
   result10.setBackground(Color.black);
   result10.setFont( new Font("Ancizar Sans",Font.BOLD,20));
   
   result20= new JRadioButton("20 resultados",false);
   result20.setBounds(350,510,150,40);
   result20.setForeground(Color.white);
   result20.setOpaque(true);
   result20.setBackground(Color.black);
   result20.setFont( new Font("Ancizar Sans",Font.BOLD,20));
   
   result15= new JRadioButton("15 resultados",false);
   result15.setBounds(200,510,150,40);
   result15.setForeground(Color.white);
   result15.setOpaque(true);
   result15.setBackground(Color.black);
   result15.setFont( new Font("Ancizar Sans",Font.BOLD,20));
   
   
   ButtonGroup nResult = new ButtonGroup();
   nResult.add(result10);
   nResult.add(result15);
   nResult.add(result20);

    prevButton = new JButton(new ImageIcon(getClass().getResource("/Interface/"+"prev.png")));
    prevButton.setBounds(120,470,50,30);
    prevButton.setBackground(Color.black);
    prevButton.setEnabled(true);
    prevButton.setForeground(Color.yellow);
    prevButton.setFont( new Font("Ancizar Sans",Font.BOLD,17));
    
    
    nextButton = new JButton(new ImageIcon(getClass().getResource("/Interface/"+"next.png")));
    nextButton.setBounds(370,470,50,30);
    nextButton.setBackground(Color.black);
    nextButton.setEnabled(true);
    nextButton.setForeground(Color.yellow);
    nextButton.setFont( new Font("Ancizar Sans",Font.BOLD,17));
  
 
   ActionListener next = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
           
           
           
           
           if(modo==1){
               PagFlora.nextPage();
               buenas.setText("Página: "+(PagFlora.pageNum));
           for(int i = 0; i < PagFlora.resPerPage;i++){
             rFLName[i].setText(PagFlora.resultsName()[i]);
             rFLScName[i].setText(PagFlora.resultsScName()[i]);
             rFLEcos[i].setText(PagFlora.resultsEcosystem()[i]);
             rFLUbic[i].setText(PagFlora.resultsUbication()[i]);
           }
           }
           if(modo==2){
               PagFauna.nextPage();
               buenas.setText("Página: "+(PagFauna.pageNum));
           for(int i = 0; i < PagFauna.resPerPage;i++){
             rFLName[i].setText(PagFauna.resultsName()[i]);
             rFLScName[i].setText(PagFauna.resultsScName()[i]);
             rFLEcos[i].setText(PagFauna.resultsEcosystem()[i]);
             rFLUbic[i].setText(PagFauna.resultsUbication()[i]);
           }
           }
           
           if(modo==3){
               PagEcop.nextPage();
               buenas.setText("Página: "+(PagEcop.pageNum));
           for(int i = 0; i < PagEcop.resPerPage;i++){
             rFLName[i].setText(PagEcop.resultsName()[i]);
             rFLScName[i].setText(PagEcop.resultsInteres()[i]);
             rFLEcos[i].setText(PagEcop.resultsEcosystem()[i]);
             rFLUbic[i].setText(PagEcop.resultsUbication()[i]);
           }
           }
          
           
           //To change body of generated methods, choose Tools | Templates.
        }
    };
   
ActionListener prev = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            
           
           
           
           
           if(modo==1){
               PagFlora.prevPage();
               buenas.setText("Página: "+PagFlora.pageNum);
           for(int i = 0; i < PagFlora.resPerPage;i++){
             rFLName[i].setText(PagFlora.resultsName()[i]);
             rFLScName[i].setText(PagFlora.resultsScName()[i]);
             rFLEcos[i].setText(PagFlora.resultsEcosystem()[i]);
             rFLUbic[i].setText(PagFlora.resultsUbication()[i]);
           }
           }
           if(modo==2){
               PagFauna.prevPage();
               buenas.setText("Página: "+PagFauna.pageNum);
           for(int i = 0; i < PagFauna.resPerPage;i++){
             rFLName[i].setText(PagFauna.resultsName()[i]);
             rFLScName[i].setText(PagFauna.resultsScName()[i]);
             rFLEcos[i].setText(PagFauna.resultsEcosystem()[i]);
             rFLUbic[i].setText(PagFauna.resultsUbication()[i]);
           }
           }
           
           if(modo==3){
               PagEcop.prevPage();
               buenas.setText("Página: "+PagEcop.pageNum);
           for(int i = 0; i < PagEcop.resPerPage;i++){
             rFLName[i].setText(PagEcop.resultsName()[i]);
             rFLScName[i].setText(PagEcop.resultsInteres()[i]);
             rFLEcos[i].setText(PagEcop.resultsEcosystem()[i]);
             rFLUbic[i].setText(PagEcop.resultsUbication()[i]);
           }
           }
           
           //To change body of generated methods, choose Tools | Templates.
        }
    };
     ActionListener res10 = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            
            
           
           
           
           for(int i= 0; i< PagFlora.resPerPage;i++){
            rFLName[i].setBounds(150,50+40*i,170,40);
        rFLName[i].setForeground(Color.white);
        //resFloraLabel[i].setOpaque(true);
        rFLName[i].setBackground(Color.black);
        rFLName[i].setFont( new Font("Ancizar Sans",Font.BOLD,20));
           JPBusc.add(rFLName[i]);
           
           rFLScName[i].setBounds(335,50+40*i,170,40);
        rFLScName[i].setForeground(Color.white);
        //resFloraLabel[i].setOpaque(true);
        rFLScName[i].setBackground(Color.black);
        rFLScName[i].setFont( new Font("Ancizar Sans",Font.PLAIN,20));
           JPBusc.add(rFLScName[i]);
           
           rFLEcos[i].setBounds(520,50+40*i,170,40);
        rFLEcos[i].setForeground(Color.white);
        //resFloraLabel[i].setOpaque(true);
        rFLEcos[i].setBackground(Color.black);
        rFLEcos[i].setFont( new Font("Ancizar Sans",Font.PLAIN,20));
           JPBusc.add(rFLEcos[i]);
           
           rFLUbic[i].setBounds(715,50+40*i,170,40);
        rFLUbic[i].setForeground(Color.white);
        //resFloraLabel[i].setOpaque(true);
        rFLUbic[i].setBackground(Color.black);
        rFLUbic[i].setFont( new Font("Ancizar Sans",Font.PLAIN,20));
           JPBusc.add(rFLUbic[i]);
           
        }
           
           if(modo==1){
               
           
               PagFlora.show10Results();
           for(int i = 0; i < PagFlora.resPerPage;i++){
             rFLName[i].setText(PagFlora.resultsName()[i]);
             rFLScName[i].setText(PagFlora.resultsScName()[i]);
             rFLEcos[i].setText(PagFlora.resultsEcosystem()[i]);
             rFLUbic[i].setText(PagFlora.resultsUbication()[i]);
           }
           for(int i = 0; i < rFLName.length- PagFlora.resPerPage;i++){
             rFLName[i+PagFlora.resPerPage].setText(" ");
             rFLScName[i+PagFlora.resPerPage].setText(" ");
             rFLEcos[i+PagFlora.resPerPage].setText(" ");
             rFLUbic[i+PagFlora.resPerPage].setText(" ");
           }
           buenas.setText("Página: "+PagFlora.pageNum);
           }
           if(modo==2){
               
           
               PagFauna.show10Results();
           for(int i = 0; i < PagFauna.resPerPage;i++){
             rFLName[i].setText(PagFauna.resultsName()[i]);
             rFLScName[i].setText(PagFauna.resultsScName()[i]);
             rFLEcos[i].setText(PagFauna.resultsEcosystem()[i]);
             rFLUbic[i].setText(PagFauna.resultsUbication()[i]);
           }
           for(int i = 0; i < rFLName.length- PagFauna.resPerPage;i++){
             rFLName[i+PagFauna.resPerPage].setText(" ");
             rFLScName[i+PagFauna.resPerPage].setText(" ");
             rFLEcos[i+PagFauna.resPerPage].setText(" ");
             rFLUbic[i+PagFauna.resPerPage].setText(" ");
           }
           buenas.setText("Página: "+PagFauna.pageNum);
           }
           if(modo==3){
               
           
               PagEcop.show10Results();
           for(int i = 0; i < PagEcop.resPerPage;i++){
             rFLName[i].setText(PagEcop.resultsName()[i]);
             rFLScName[i].setText(PagEcop.resultsInteres()[i]);
             rFLEcos[i].setText(PagEcop.resultsEcosystem()[i]);
             rFLUbic[i].setText(PagFlora.resultsUbication()[i]);
           }
           for(int i = 0; i < rFLName.length- PagEcop.resPerPage;i++){
             rFLName[i+PagEcop.resPerPage].setText(" ");
             rFLScName[i+PagEcop.resPerPage].setText(" ");
             rFLEcos[i+PagEcop.resPerPage].setText(" ");
             rFLUbic[i+PagEcop.resPerPage].setText(" ");
           }
           buenas.setText("Página: "+PagEcop.pageNum);
           }
           
           
           
           
           
           //To change body of generated methods, choose Tools | Templates.
        }
    };
     
     ActionListener res15 = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            
           
           
           
           for(int i= 0; i< 15;i++){
            rFLName[i].setBounds(150,50+26*i,160,26);
        rFLName[i].setForeground(Color.white);
        //resFloraLabel[i].setOpaque(true);
        rFLName[i].setBackground(Color.black);
        rFLName[i].setFont( new Font("Ancizar Sans",Font.BOLD,17));
           JPBusc.add(rFLName[i]);
           
           rFLScName[i].setBounds(325,50+26*i,160,26);
        rFLScName[i].setForeground(Color.white);
        //resFloraLabel[i].setOpaque(true);
        rFLScName[i].setBackground(Color.black);
        rFLScName[i].setFont( new Font("Ancizar Sans",Font.PLAIN,17));
           JPBusc.add(rFLScName[i]);
           
           rFLEcos[i].setBounds(500,50+26*i,160,26);
        rFLEcos[i].setForeground(Color.white);
        //resFloraLabel[i].setOpaque(true);
        rFLEcos[i].setBackground(Color.black);
        rFLEcos[i].setFont( new Font("Ancizar Sans",Font.PLAIN,17));
           JPBusc.add(rFLEcos[i]);
           
           rFLUbic[i].setBounds(665,50+26*i,160,26);
        rFLUbic[i].setForeground(Color.white);
        //resFloraLabel[i].setOpaque(true);
        rFLUbic[i].setBackground(Color.black);
        rFLUbic[i].setFont( new Font("Ancizar Sans",Font.PLAIN,17));
           JPBusc.add(rFLUbic[i]);
           
        }
           
           if(modo==1){
               PagFlora.show15Results();
           for(int i = 0; i < 15;i++){
               
             rFLName[i].setText(PagFlora.resultsName()[i]);
             rFLScName[i].setText(PagFlora.resultsScName()[i]);
             rFLEcos[i].setText(PagFlora.resultsEcosystem()[i]);
             rFLUbic[i].setText(PagFlora.resultsUbication()[i]);
           }
           for(int i = 0; i < rFLName.length- PagFlora.resPerPage;i++){
             rFLName[i+PagFlora.resPerPage].setText(" ");
             rFLScName[i+PagFlora.resPerPage].setText(" ");
             rFLEcos[i+PagFlora.resPerPage].setText(" ");
             rFLUbic[i+PagFlora.resPerPage].setText(" ");
           }
           buenas.setText("Página: "+PagFlora.pageNum);
           }
           if(modo==2){
               PagFauna.show15Results();
               
           for(int i = 0; i < PagFauna.resPerPage;i++){
             rFLName[i].setText(PagFauna.resultsName()[i]);
             rFLScName[i].setText(PagFauna.resultsScName()[i]);
             rFLEcos[i].setText(PagFauna.resultsEcosystem()[i]);
             rFLUbic[i].setText(PagFauna.resultsUbication()[i]);
           }
           for(int i = 0; i < rFLName.length- PagFauna.resPerPage;i++){
             rFLName[i+PagFauna.resPerPage].setText(" ");
             rFLScName[i+PagFauna.resPerPage].setText(" ");
             rFLEcos[i+PagFauna.resPerPage].setText(" ");
             rFLUbic[i+PagFauna.resPerPage].setText(" ");
           }
           buenas.setText("Página: "+PagFauna.pageNum);
           }
           if(modo==3){
               PagEcop.show15Results();
               
           for(int i = 0; i < PagEcop.resPerPage;i++){
             rFLName[i].setText(PagEcop.resultsName()[i]);
             rFLScName[i].setText(PagEcop.resultsInteres()[i]);
             rFLEcos[i].setText(PagEcop.resultsEcosystem()[i]);
             rFLUbic[i].setText(PagFlora.resultsUbication()[i]);
           }
           for(int i = 0; i < rFLName.length- PagEcop.resPerPage;i++){
             rFLName[i+PagEcop.resPerPage].setText(" ");
             rFLScName[i+PagEcop.resPerPage].setText(" ");
             rFLEcos[i+PagEcop.resPerPage].setText(" ");
             rFLUbic[i+PagEcop.resPerPage].setText(" ");
           }
           buenas.setText("Página: "+PagEcop.pageNum);
           }
           
           
           
           //To change body of generated methods, choose Tools | Templates.
        }
    };
     
     ActionListener res20 = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            
           
           
           
           for(int i= 0; i< 20;i++){
            rFLName[i].setBounds(150,50+20*i,150,20);
        rFLName[i].setForeground(Color.white);
        //resFloraLabel[i].setOpaque(true);
        rFLName[i].setBackground(Color.black);
        rFLName[i].setFont( new Font("Ancizar Sans",Font.BOLD,12));
           JPBusc.add(rFLName[i]);
           
           rFLScName[i].setBounds(315,50+20*i,150,20);
        rFLScName[i].setForeground(Color.white);
        //resFloraLabel[i].setOpaque(true);
        rFLScName[i].setBackground(Color.black);
        rFLScName[i].setFont( new Font("Ancizar Sans",Font.PLAIN,12));
           JPBusc.add(rFLScName[i]);
           
           rFLEcos[i].setBounds(480,50+20*i,150,20);
        rFLEcos[i].setForeground(Color.white);
        //resFloraLabel[i].setOpaque(true);
        rFLEcos[i].setBackground(Color.black);
        rFLEcos[i].setFont( new Font("Ancizar Sans",Font.PLAIN,12));
           JPBusc.add(rFLEcos[i]);
           
           rFLUbic[i].setBounds(645,50+20*i,150,20);
        rFLUbic[i].setForeground(Color.white);
        //resFloraLabel[i].setOpaque(true);
        rFLUbic[i].setBackground(Color.black);
        rFLUbic[i].setFont( new Font("Ancizar Sans",Font.PLAIN,12));
           JPBusc.add(rFLUbic[i]);
           
        }
           
           
           if(modo==1){
               PagFlora.show20Results();
               
           for(int i = 0; i < PagFlora.resPerPage;i++){
             rFLName[i].setText(PagFlora.resultsName()[i]);
             rFLScName[i].setText(PagFlora.resultsScName()[i]);
             rFLEcos[i].setText(PagFlora.resultsEcosystem()[i]);
             rFLUbic[i].setText(PagFlora.resultsUbication()[i]);
           }
           
           buenas.setText("Página: "+PagFlora.pageNum);
           }
           if(modo==2){
               PagFauna.show20Results();
           for(int i = 0; i < PagFauna.resPerPage;i++){
               
             rFLName[i].setText(PagFauna.resultsName()[i]);
             rFLScName[i].setText(PagFauna.resultsScName()[i]);
             rFLEcos[i].setText(PagFauna.resultsEcosystem()[i]);
             rFLUbic[i].setText(PagFauna.resultsUbication()[i]);
           }
           
           buenas.setText("Página: "+PagFauna.pageNum);
           }
           if(modo==3){
               PagEcop.show20Results();
               
           for(int i = 0; i < PagEcop.resPerPage;i++){
             rFLName[i].setText(PagEcop.resultsName()[i]);
             rFLScName[i].setText(PagEcop.resultsInteres()[i]);
             rFLEcos[i].setText(PagEcop.resultsEcosystem()[i]);
             rFLUbic[i].setText(PagEcop.resultsUbication()[i]);
           }
           
           buenas.setText("Página: "+PagEcop.pageNum);
           }
           
           
           
           //To change body of generated methods, choose Tools | Templates.
        }
    };
//     
     
    nextButton.addActionListener(next);
    prevButton.addActionListener(prev);
    result10.addActionListener(res10);
    result15.addActionListener(res15);
    result20.addActionListener(res20);

    
    
        

                JPBusc.add(buenas1);
                
                
    
    }

public void flora(DynamicArray<Flora> Flora){
    PagFlora=new PagerFlora(Flora);
    modo=1;
              Apriete();

           PagFlora.show10Results();
           buenas1.setText(Integer.toString(modo));
           JPBusc.removeAll();
           
           for(int i= 0; i<rFLName.length;i++){
                    
                    JPBusc.add(rFLName[i]);
                    JPBusc.add(rFLScName[i]);
                    JPBusc.add(rFLEcos[i]);
                    JPBusc.add(rFLUbic[i]);
                    
                    
                }       
                JPBusc.add(buenas);
                JPBusc.add(prevButton);
                JPBusc.add(nextButton);
                JPBusc.add(result10);
                JPBusc.add(result20);
                JPBusc.add(result15);
                JPBusc.add(buenas1);
                JPBusc.add(flTitle);
                JPBusc.add(faTitle);
                JPBusc.add(ecTitle);
                JPBusc.add(nTitle);

                flTitle.setBounds(160,10,170,30);
                flTitle.setForeground(Color.yellow);
                flTitle.setFont( new Font("Ancizar Sans",Font.BOLD,20));
                flTitle.setText("Nombre");
                
           
                faTitle.setBounds(345,10,170,30);
                faTitle.setForeground(Color.yellow);
                faTitle.setFont( new Font("Ancizar Sans",Font.BOLD,20));
                faTitle.setText("N. Científico");
                
               
               ecTitle.setBounds(530,10,170,30);
               ecTitle.setForeground(Color.YELLOW);
               ecTitle.setFont( new Font("Ancizar Sans",Font.BOLD,20));
               ecTitle.setText("Ecosistema");
               
               nTitle.setBounds(715,10,170,30);
               nTitle.setForeground(Color.YELLOW);
               nTitle.setFont( new Font("Ancizar Sans",Font.BOLD,20));
               nTitle.setText("Ubicación");
               
                buenas1.setText("FLORA");
                buenas1.setFont( new Font("Ancizar Sans",Font.BOLD,20));
                for(int i = 0; i < PagFlora.resPerPage;i++){
                    
                    rFLName[i].setText(PagFlora.resultsName()[i]);
                    rFLScName[i].setText(PagFlora.resultsScName()[i]);
                    rFLEcos[i].setText(PagFlora.resultsEcosystem()[i]);
                    rFLUbic[i].setText(PagFlora.resultsUbication()[i]);
//                    rFLName[i].setBorder(new javax.swing.border.LineBorder(new java.awt.Color(155,155,155), 3, true));
//                    rFLScName[i].setBorder(new javax.swing.border.LineBorder(new java.awt.Color(155,155,155), 3, true));
//                    rFLEcos[i].setBorder(new javax.swing.border.LineBorder(new java.awt.Color(155,155,155), 3, true));
//                    rFLUbic[i].setBorder(new javax.swing.border.LineBorder(new java.awt.Color(155,155,155), 3, true));
                    
                }
}


    
    public void busqueda(String buscar){
        JTFbusqueda.setText(buscar);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BGOpcBusqueda = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        JBVolverInicio = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        JTFbusqueda = new javax.swing.JTextField();
        JBnuevaBusqueda = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        JPBusc = new javax.swing.JPanel();

        setBackground(new java.awt.Color(120, 120, 120));
        setMaximumSize(new java.awt.Dimension(250, 250));

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 72)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(1, 1, 1));
        jLabel1.setText("-");

        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 72)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(3, 222, 1));
        jLabel2.setText("ECO");

        jLabel3.setFont(new java.awt.Font("Ubuntu", 1, 72)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(253, 237, 67));
        jLabel3.setText("LOM");

        jLabel4.setFont(new java.awt.Font("Ubuntu", 1, 72)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(67, 155, 253));
        jLabel4.setText("BI");

        jLabel5.setFont(new java.awt.Font("Ubuntu", 1, 72)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 44, 29));
        jLabel5.setText("A");

        jLabel6.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(254, 254, 254));
        jLabel6.setText("RED COLABORATIVA PARA LA BIODIVERSIDAD Y ECOPARQUES COLOMBIANOS");

        JBVolverInicio.setBackground(new java.awt.Color(231, 231, 231));
        JBVolverInicio.setFont(new java.awt.Font("Ubuntu", 1, 20)); // NOI18N
        JBVolverInicio.setText("Inicio");
        JBVolverInicio.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.lightGray, null, null));
        JBVolverInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBVolverInicioActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(254, 254, 254));
        jLabel9.setText("Resultado de la busqueda :");

        JTFbusqueda.setEditable(false);
        JTFbusqueda.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        JTFbusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTFbusquedaActionPerformed(evt);
            }
        });

        JBnuevaBusqueda.setBackground(new java.awt.Color(76, 234, 86));
        JBnuevaBusqueda.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        JBnuevaBusqueda.setForeground(new java.awt.Color(254, 254, 254));
        JBnuevaBusqueda.setText("Nueva busqueda");
        JBnuevaBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBnuevaBusquedaActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(6, 208, 4));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1010, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        JPBusc.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout JPBuscLayout = new javax.swing.GroupLayout(JPBusc);
        JPBusc.setLayout(JPBuscLayout);
        JPBuscLayout.setHorizontalGroup(
            JPBuscLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        JPBuscLayout.setVerticalGroup(
            JPBuscLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 547, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(20, 254, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JBVolverInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(JTFbusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addComponent(JBnuevaBusqueda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(JPBusc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(JBVolverInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addGap(4, 4, 4)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(JTFbusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JBnuevaBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(JPBusc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void JTFbusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTFbusquedaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTFbusquedaActionPerformed

    private void JBVolverInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBVolverInicioActionPerformed
        Volverinicio.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_JBVolverInicioActionPerformed

    private void JBnuevaBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBnuevaBusquedaActionPerformed
        regresar.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_JBnuevaBusquedaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup BGOpcBusqueda;
    private javax.swing.JButton JBVolverInicio;
    private javax.swing.JButton JBnuevaBusqueda;
    private javax.swing.JPanel JPBusc;
    private javax.swing.JTextField JTFbusqueda;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables

    void Ecoparques(DynamicArray<Ecoparque> Ecop) {
           PagEcop =new PagerEcoparks(Ecop);
           modo=3;
           Apriete();
           PagEcop.show10Results();
           buenas1.setText(Integer.toString(modo));
           JPBusc.removeAll();
           for(int i= 0; i<rFLName.length;i++){
                    
                    JPBusc.add(rFLName[i]);
                   JPBusc.add(rFLScName[i]);
                   JPBusc.add(rFLEcos[i]);
                    JPBusc.add(rFLUbic[i]);
                    
                    
                }       JPBusc.add(buenas);
                JPBusc.add(prevButton);
                JPBusc.add(nextButton);
                JPBusc.add(result10);
                JPBusc.add(result20);
               JPBusc.add(result15);
                JPBusc.add(buenas1);
                JPBusc.add(flTitle);
               JPBusc.add(faTitle);
                JPBusc.add(ecTitle);
               JPBusc.add(nTitle);
               
                flTitle.setBounds(160,10,170,30);
                flTitle.setForeground(Color.yellow);
                flTitle.setFont( new Font("Ancizar Sans",Font.BOLD,20));
                flTitle.setText("Nombre");
                
           
                faTitle.setBounds(345,10,170,30);
                faTitle.setForeground(Color.yellow);
                faTitle.setFont( new Font("Ancizar Sans",Font.BOLD,20));
                faTitle.setText("Intereses");
                
               
               ecTitle.setBounds(530,10,170,30);
               ecTitle.setForeground(Color.yellow);
               ecTitle.setFont( new Font("Ancizar Sans",Font.BOLD,20));
               ecTitle.setText("Ecosistema");
               
               nTitle.setBounds(715,10,170,30);
               nTitle.setForeground(Color.yellow);
               nTitle.setFont( new Font("Ancizar Sans",Font.BOLD,20));
               nTitle.setText("Ubicación");
               buenas1.setText("ECOP");
               buenas1.setFont( new Font("Ancizar Sans",Font.BOLD,20));
              
                for(int i = 0; i < PagEcop.resPerPage;i++){
                    
                    rFLName[i].setText(PagEcop.resultsName()[i]);
                    rFLScName[i].setText(PagEcop.resultsInteres()[i]);
                    rFLEcos[i].setText(PagEcop.resultsEcosystem()[i]);
                    rFLUbic[i].setText(PagEcop.resultsUbication()[i]);
                }

        
    }

    void fauna(DynamicArray<Fauna> Fauna) {
PagFauna = new PagerFauna(Fauna) ;
           modo=2;
           Apriete();

           PagFauna.show10Results();
           buenas1.setText(Integer.toString(modo));
           JPBusc.removeAll();
           
           
        
           for(int i= 0; i<rFLName.length;i++){
                    
                    JPBusc.add(rFLName[i]);
                   JPBusc.add(rFLScName[i]);
                    JPBusc.add(rFLEcos[i]);
                    JPBusc.add(rFLUbic[i]);
                    
                    
                }       
                JPBusc.add(buenas);
                JPBusc.add(prevButton);
                JPBusc.add(nextButton);
               JPBusc.add(result10);
                JPBusc.add(result20);
                JPBusc.add(result15);
               JPBusc.add(buenas1);
                JPBusc.add(flTitle);
              JPBusc.add(faTitle);
                JPBusc.add(ecTitle);
              JPBusc.add(nTitle);
                flTitle.setBounds(160,10,170,30);
                flTitle.setForeground(Color.yellow);
                flTitle.setFont( new Font("Ancizar Sans",Font.BOLD,20));
                flTitle.setText("Nombre");
                
           
                faTitle.setBounds(345,10,170,30);
                faTitle.setForeground(Color.yellow);
                faTitle.setFont( new Font("Ancizar Sans",Font.BOLD,20));
                faTitle.setText("N. Científico");
                
               
               ecTitle.setBounds(530,10,170,30);
               ecTitle.setForeground(Color.yellow);
               ecTitle.setFont( new Font("Ancizar Sans",Font.BOLD,20));
               ecTitle.setText("Ecosistema");
               
               nTitle.setBounds(715,10,170,30);
               nTitle.setForeground(Color.yellow);
               nTitle.setFont( new Font("Ancizar Sans",Font.BOLD,20));
               nTitle.setText("Ubicación");
                buenas1.setText("FAUNA");
                buenas1.setFont( new Font("Ancizar Sans",Font.BOLD,20));
                
                for(int i = 0; i < PagFauna.resPerPage;i++){
                    
                    rFLName[i].setText(PagFauna.resultsName()[i]);
                    rFLScName[i].setText(PagFauna.resultsScName()[i]);
                    rFLEcos[i].setText(PagFauna.resultsEcosystem()[i]);
                    rFLUbic[i].setText(PagFauna.resultsUbication()[i]);
                }
           //To change body of generated methods, choose Tools | Templates.

    


    }

    
}
