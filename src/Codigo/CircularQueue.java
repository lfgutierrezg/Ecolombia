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
import java.lang.reflect.Array;

/**
 *
 * @author danie
 */
public class CircularQueue<T> {
    protected T array  [];
    protected int size;
    
    public CircularQueue(int size1 ) {
        this.array = (T[]) new Object[size1] ;
        this.size = 0;
        
    }
    public int size() {
            return size;
    }
    public boolean isEmpty() {
        if(size==0){
            return true;
        }else{
            return false;
        }
    }
    public <T> Object value(int index){
        if(size<index) return null;
        return array[index];
    }
    public void enqueue(T key) {
        if(size>=array.length){
            dequeue();
        }
        array[size]=key;
        size++;
        
    }
    
    public void dequeue() {
        if(isEmpty()) return;
        for(int i=0;i<size-1;i++){
            array[i]=array[i+1];
        }
        size--;
    }
}