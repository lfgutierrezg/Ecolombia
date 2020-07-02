package Codigo;


import java.io.IOException;

public class HashUsuario {
   UsuarioRegistrado[] hashArray; 
  private int carga;
   int arraySize;
  private final double factorCarga=0.75;
  private UsuarioRegistrado bufItem; // for deleted items
  private int PrimoMenor;

  HashUsuario(int size) {
      carga=0;
    arraySize = size;
    hashArray = new UsuarioRegistrado[arraySize];
    bufItem = new UsuarioRegistrado("no", "no", 
            "no", "no", "no", "no","-1");
    
    for(int i=arraySize-1;i>0;i--){
        PrimoMenor=i;
                if(esPrimo(PrimoMenor)){
                    break;
                }
    }
  }

  public void displayTable() {
    System.out.print("Table: ");
    for (int j = 0; j < arraySize; j++) {
      if (hashArray[j] != null)
        System.out.print(hashArray[j].getId() + " ");
      else
        System.out.print("** ");
    }
    System.out.println("");
  }

  public int hashFunc1(int key) {
    return key % arraySize;
  }

  public int hashFunc2(int key) {
    return PrimoMenor- key % PrimoMenor;
  }

  public void insert( UsuarioRegistrado item) {
      double c=carga;
      double A=arraySize;
      double FC=c/A;
      
      
      if(FC>=factorCarga){
          resize();
      }
  
    int key=item.getId();
    int hashVal = hashFunc1(key); // hash the key
    int stepSize = hashFunc2(key); // get step size
    // until empty cell or -1
    while (hashArray[hashVal] != null && hashArray[hashVal].getId() != -1) {
      hashVal += stepSize; // add the step
      hashVal %= arraySize; // for wraparound
    }
    hashArray[hashVal] = item; // insert item
    carga++;
  }

  public UsuarioRegistrado delete(int key) {
    
    int hashVal = hashFunc1(key); 
    int stepSize = hashFunc2(key); // get step size

    while (hashArray[hashVal] != null) {
      if (hashArray[hashVal].getId()== key) {
        UsuarioRegistrado temp = hashArray[hashVal]; // save item
        hashArray[hashVal] = bufItem; // delete item
        carga--;
        return temp; // return item
      }
      hashVal += stepSize; // add the step
      hashVal %= arraySize; // for wraparound
    }
    return null; // can't find item
  }

  public UsuarioRegistrado find(int key) {
    int hashVal = hashFunc1(key); // hash the key
    int stepSize = hashFunc2(key); // get step size

    while (hashArray[hashVal] != null) {
      if (hashArray[hashVal].getId() == key)
        return hashArray[hashVal]; // yes, return item
      hashVal += stepSize; // add the step
      hashVal %= arraySize; // for wraparound
    }
    return null; // can't find item
  }

    private void resize() {
        int t=2*arraySize;
        while(!esPrimo(t)){
            t=t+1;
        }
        
         UsuarioRegistrado[] temp=hashArray;
         hashArray = new UsuarioRegistrado[t];
         int f=arraySize;
         arraySize=t;
         carga=0;
         for(int i=arraySize-1;i>0;i--){
        PrimoMenor=i;
                if(esPrimo(PrimoMenor)){
                    break;
                }
        }
         
         for(int i=0;i<f;i++){
             if(temp[i]!=null){
                 insert(temp[i]);
             }
         }
    }
    
    public static boolean esPrimo(int numero){
  int contador = 2;
  boolean primo=true;
  while ((primo) && (contador!=numero)){
    if (numero % contador == 0)
      primo = false;
    contador++;
  }
  return primo;
}
    
}
