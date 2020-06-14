package Codigo;

/**
 *
 * @author danie
 */
public class MaxHeapEcoparque {
    private Ecoparque[] Heap;
    private int size;
    private int maxsize;
    private static final int FRONT = 1;

    public MaxHeapEcoparque(int size){
        this.maxsize = size;
        this.size = 0;
        Heap = new Ecoparque[this.maxsize + 1];
        Heap[0] = new Ecoparque(Integer.MAX_VALUE);
        for(int i=0;i<size;i++){
            Heap[i+1]=(new Ecoparque(0));
        }
    }

    private int parent(int pos) {
        return pos / 2;
    }

    private int leftChild(int pos) {
        if(pos>size) return 0;
        return (2 * pos);
    }

    private int rightChild(int pos) {
        if(pos>size) return 0;
        return (2 * pos) + 1;
    }

    private boolean isLeaf(int pos) {
        if (pos >= (size / 2) && pos <= size) {
            return true;
        }
        return false;
    }

    private void swap(int fpos, int spos) {
        Ecoparque tmp;
        tmp = Heap[fpos];
        Heap[fpos]= Heap[spos];
        Heap[spos]= tmp;
    }

    private void maxHeapify(int pos) {
        if (!isLeaf(pos)) {
            if (Heap[pos].busquedas < Heap[leftChild(pos)].busquedas
                    || Heap[pos].busquedas <Heap[rightChild(pos)].busquedas) {
                if (Heap[leftChild(pos)].busquedas > Heap[rightChild(pos)].busquedas) {
                    swap(pos, leftChild(pos)); 
                    maxHeapify(leftChild(pos)); 
                } else {
                    swap(pos, rightChild(pos));
                    maxHeapify(rightChild(pos)); 
                }
            }
        }
    } 
    private void siftUp(int i){
        while(i>1 && Heap[parent(i)].busquedas<Heap[i].busquedas){
            swap(parent(i),i);
            i=parent(i);
        } 
    }

    public void deleteIndex(int i){
        Heap[i]=Heap[0];
        siftUp(i);
        extractMax();
    }
    public void siftDown(int i){
        int maxIndex=i;
            int l=leftChild(i);
            if(l<=size && Heap[l].busquedas>Heap[maxIndex].busquedas){
                maxIndex=l;
            }
            int r= rightChild(i);
            if(r<=size && Heap[r].busquedas>Heap[maxIndex].busquedas){
                maxIndex=r;
            }
            if(i!=maxIndex){
                swap(i,maxIndex);
                siftDown(maxIndex);
            }
    }
    public void changePriority(int i,int p){
        int oldp=Heap[i].busquedas;
        Heap[i].busquedas=p;
        if(p>oldp){
            siftUp(i);
        }else{
            siftDown(i);
        }
    }

    public void insert(Ecoparque element) {
        Heap[++size].busquedas = element.busquedas;
        Heap[size].ecosistema=element.ecosistema;
        Heap[size].id=element.id;
        Heap[size].nombre=element.nombre;
        Heap[size].ubicacion=element.ubicacion;
        Heap[size].interes=element.interes;
        int current = size;
        while (Heap[current].busquedas > Heap[parent(current)].busquedas) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

   public void print() 
       { 
           for (int i = 1; i <= size / 2; i++) { 
               System.out.print(" valor padre : " + Heap[i] + " hijo izquierdo : " + Heap[leftChild(i)] + " hijo derecho :" + Heap[rightChild(i)]); 
               System.out.println(); 
           } 
       }

    public void maxHeap() {
        for (int pos = (size / 2); pos >= 1; pos--) {
        maxHeapify(pos);
        }
    }

    public Object extractMax() {
        Ecoparque popped = Heap[FRONT];
        Heap[1] = Heap[size--]; 
        siftDown(1);
        return popped;
    }
}
