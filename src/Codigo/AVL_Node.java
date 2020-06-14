package Proyecto;

/**
 *
 * @author danie
 */
public class AVL_Node {
    int key;
    AVL_Node left;
    AVL_Node right;
    int height;

    public AVL_Node(int key) {
        this.key = key;
        this.height=1;
    }
}
