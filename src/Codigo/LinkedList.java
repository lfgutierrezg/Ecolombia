
package Codigo;

public class LinkedList<T> {
    private Node head;
    private int size;
    private Node tail;
    public LinkedList(){
	this.head=null;
	this.tail=null;
	this.size=0;
    }
    public void add(T key) {
	Node newNode = new Node(key);
	newNode.next = null;
	if (this.tail == null) {
            this.head=this.tail=newNode;
	}else {
            this.tail.next=newNode;
            this.tail=newNode;
	}
	this.size++;		
    }
    public Object topBack() {
        return this.tail.key;
    }
    public void print() {
        if (this.size==0){
            return ;
        }else{
            Node node = this.head;
            for(int i=0;i<this.size;i++){
                System.out.println(node.key);
                node=node.next;
            }        
        }
    }
    public int size(){
        return this.size;
    }
    public Node getNodeAt(int index) {
        if (this.head == null || (this.size -1)<index) return null;
        Node currentNode = this.head;
        for(int i=0;i<index;i++){
            currentNode=currentNode.next;
	}
	return currentNode;
    }
    public Object getValueOF(int index){
        if (this.head == null || (this.size -1)<index) return null;
        Node currentNode = this.head;
        for(int i=0;i<index;i++){
            currentNode=currentNode.next;
	}
	return currentNode.key;
    }
    public void addAfter(Node node, T key) {
	if(this.head==null || node == null) return;		
            Node newNode = new Node(key);
            Node prev=node;
            Node next = node.next;
            prev.next = newNode;
            newNode.next = next;
            if (this.tail== node) {
		 this.tail=newNode;
            }
            this.size++;
    }
    public int indexOf(T key){
        Node currentNode= this.head;
        int index=0;
        while (currentNode != null && !currentNode.key.equals(key)){
            currentNode=currentNode.next;
            index++;
        }
        if(currentNode == null){
            return -1;
        }else{
        return index;
        }
    }
    public boolean isEmpty() {
	if(this.size==0) {
	return true;
	}else {
            return false;
	}
    }
    public void delete(int index){
        if (index<0 || index>=size) return;
        Node temp= this.head;
        if(index==0){
            this.head=this.head.next;
        }
        else if (index==size-1){
            if(size==1){
                head=tail=null;
            }else{
            while(temp.next.next!=null){
                temp=temp.next;
            }
            temp.next=null;
            tail=temp;
            }    
        }else{
            for (int i = 0;i<index-1;i++){
                temp=temp.next;
            }
            temp.next=temp.next.next;
        }
        this.size--;
    }
    public void makeEmpty() {
	this.head=null;
	this.tail=null;
	this.size=0;
    }
    public Object topFront() {
        return this.head.key;
    }
    public void popBack(){
        if(head==null)return;
        if(head==tail){
            head=tail=null;
        }else{
            Node temp=head;
            while(temp.next.next!=null){
                temp=temp.next;
            }
            temp.next=null;
            tail=temp;
        }
        size--;
    }
    public void popFront() {
	if(this.head==null) return;
	this.head=this.head.next;
	if(this.head==null) {
            this.tail=null;
        }
        this.size--;
    }
}
