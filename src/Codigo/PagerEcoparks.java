
package Codigo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Usuario
 */
public class PagerEcoparks {
    public int pageNum;
    public int resPerPage;
    DynamicArray<Ecoparque> Resultados;

    public PagerEcoparks(DynamicArray<Ecoparque> datosEcoparque) {
        this.pageNum=1;
        this.resPerPage=10;
        this.Resultados = datosEcoparque;
    }
   
    public String [] resultsName(){
       String[] results = new String[resPerPage];
       
       for(int i=0;i<Resultados.size;i++){
        if(i<pageNum*resPerPage&&i>=(pageNum-1)*resPerPage){
            String[] parts = Resultados.value(i).toString().split(";");
            results[i%resPerPage]=i+1+". "+ parts[0];
        }
       }
       return results;
       
    }
    
    public String [] resultsInteres(){
       String[] results = new String[resPerPage];
       
       for(int i=0;i<Resultados.size;i++){
        if(i<pageNum*resPerPage&&i>=(pageNum-1)*resPerPage){
            String[] parts = Resultados.value(i).toString().split(";");
            results[i%resPerPage]= parts[3];
        }
       }
       return results;
       
    }
    
    public String [] resultsEcosystem(){
       String[] results = new String[resPerPage];
       
       for(int i=0;i<Resultados.size;i++){
        if(i<pageNum*resPerPage&&i>=(pageNum-1)*resPerPage){
            String[] parts = Resultados.value(i).toString().split(";");
            results[i%resPerPage]= parts[2];
        }
       }
       return results;
       
    }
    
    public String [] resultsUbication(){
       String[] results = new String[resPerPage];
       
       for(int i=0;i<Resultados.size;i++){
        if(i<pageNum*resPerPage&&i>=(pageNum-1)*resPerPage){
            String[] parts = Resultados.value(i).toString().split(";");
            results[i%resPerPage]= parts[1];
        }
       }
       return results;
       
    }
    
    public void nextPage(){
       pageNum++;
       if(pageNum>(Resultados.size/resPerPage+1)){
           pageNum=Resultados.size/resPerPage+1;
       }
    }
    
    public void prevPage(){
       pageNum--;
       if(pageNum<1){
           pageNum=1;
       }
    }
    
    public void show10Results(){
       resPerPage=10;
    }
    
    public void show20Results(){
       resPerPage=20;
    }
    
    public void show15Results(){
       resPerPage=15;
    }
}
