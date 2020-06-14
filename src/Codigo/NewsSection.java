package Codigo;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Usuario
 */
public class NewsSection {
    CircularQueue<News> banner ;
    protected int a;     
    public NewsSection(){
    this.banner = new CircularQueue(5) ;   
    this.a=0;
    
    }
   public void addNew(News noticia){
        
      banner.enqueue(noticia);
    }
   
   public String printNewTitle(){
       if(banner.size<a) return null;
       String[] parts = banner.value(a).toString().split("-");
    return parts[0];
    
   }
   
   public String printNewDescript(){
       if(banner.size<a) return null;
       String[] parts = banner.value(a).toString().split("-");
    return parts[1];
    
   }
   
   public String printNewImage(){
       if(banner.size<a) return null;
       String[] parts = banner.value(a).toString().split("-");
    return parts[2];
    
   }
   
   public void nextPage(){
    a++;
    if(a>=banner.size){
       a=banner.size-1;
    }
    
    
   }
   public void prevPage(){
    a--;
    if(a<0){
       a=0;
    }
   }
   
}
