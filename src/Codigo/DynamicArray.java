package Codigo;


import java.lang.reflect.Array;

/**
 *
 * @author danie
 */
public class DynamicArray<T> {
    protected T array  [];
    protected int size;
    public DynamicArray(int size ) {
        this.array = (T[]) new Object[size] ;
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
    public Object value(int index){
        if(size<index) return null;
        return array[index];
    }
    public void push(T key) {
        if(size>=array.length){
            array=reSize();  
        }
        array[size]=key;
        size++;
    }
    public void delete(int index) {
        if(isEmpty() || index>=size) return;
        for(int i=index;i<size-1;i++){
            array[i]=array[i+1];
        }
        size--;
    }
    public void set(int index, T key){
        if(index<0 || index>=size)return;
        array[index]=key;
    }
    public T[] reSize(){
        T[] nuevoArray=(T[]) new Object[array.length*2];
        for(int i=0;i<array.length;i++){
            nuevoArray[i]=array[i];
        }
        return nuevoArray;
    }
}