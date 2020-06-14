package Codigo;

/**
 *
 * @author danie
 */
public class Flora_Node {
    Flora key;
    int height;
    Flora_Node left;
    Flora_Node right;
    Flora_Node(Flora key){
        this.key=key;
        this.height=1;
    }
}
