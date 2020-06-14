package Codigo;

/**
 *
 * @author danie
 */
class Fauna_Node{
    Fauna key;
    int height;
    Fauna_Node left;
    Fauna_Node right;
    Fauna_Node(Fauna key){
        this.key=key;
        this.height=1;
    }
}

public class AVL_Fauna {
    Fauna_Node root;
    
    int height(Fauna_Node N){
        if(N==null) return 0;
        return N.height;
    }
 int max(int a, int b) {
    return (a > b) ? a : b;
 }

 Fauna_Node rightRotate(Fauna_Node y) {
    Fauna_Node x = y.left;
    Fauna_Node T2 = x.right;

    // Perform rotation
    x.right = y;
    y.left = T2;

    // actualiza alturas
    y.height = max(height(y.left),height(y.right))+1;
    x.height = max(height(x.left),height(x.right))+1;

    // Return new root
    return x;
 }

 Fauna_Node leftRotate(Fauna_Node x) {
    Fauna_Node y = x.right;
    Fauna_Node T2 = y.left;

    // configura la rotación
    y.left = x;
    x.right = T2;

    // actualiza alturas
    x.height = max(height(x.left),height(x.right))+1;
    y.height = max(height(y.left),height(y.right))+1;

    return y;
 }

 int getBalance(Fauna_Node N) {
 if (N == null)
    return 0;

 return height(N.left) - height(N.right);
 }
 Fauna_Node Find(Fauna_Node node, Fauna key) {
    if (node == null)
        return (null);
    if(key.getId()== node.key.getId())
        return node;
    else if (key.getId() < node.key.getId())
        return Find(node.left, key);
    else if (key.getId() > node.key.getId())
        return  Find(node.right, key);
    else{
        return null;
    }
 }
 Fauna_Node insert(Fauna_Node node, Fauna key) {
 if (node == null){
    return (new Fauna_Node(key));}

 if (key.getId() < node.key.getId())
    node.left = insert(node.left, key);
 else if (key.getId() > node.key.getId())
    node.right = insert(node.right, key);
 else // no permite valores duplicados
    return node;

 node.height = 1 + max(height(node.left),height(node.right));

 int balance = getBalance(node);

 // desbalanceado izquierda izquierda
 if (balance > 1 && key.getId() < node.left.key.getId())
    return rightRotate(node);

 // derecha derecha
 if (balance < -1 && key.getId() > node.right.key.getId())
    return leftRotate(node);

 // Izquierda derecha|
 if (balance > 1 && key.getId() >node.left.key.getId()) {
    node.left = leftRotate(node.left);
 return rightRotate(node);
 }

 // Derecha Izquierda
 if (balance < -1 && key.getId() < node.right.key.getId()) {
    node.right = rightRotate(node.right);
    return leftRotate(node);
 }
 return node;
 }
 //
 Fauna_Node minValueNode(Fauna_Node node) {  
        Fauna_Node current = node;  
  
        /* loop down to find the leftmost leaf */
        while (current.left != null)  
            current = current.left;  
  
        return current;  
    }  
  
    Fauna_Node deleteNode(Fauna_Node root, Fauna key){  
        // STEP 1: PERFORM STANDARD BST DELETE  
        if (root == null)  
            return root;  
  
        // If the key to be deleted is smaller than  
        // the root's key, then it lies in left subtree  
        if (key.getId() < root.key.getId())  
            root.left = deleteNode(root.left, key);  
  
        // If the key to be deleted is greater than the  
        // root's key, then it lies in right subtree  
        else if (key.getId() > root.key.getId())  
            root.right = deleteNode(root.right, key);  
  
        // if key is same as root's key, then this is the node  
        // to be deleted  
        else{  
  
            // node with only one child or no child  
            if ((root.left == null) || (root.right == null)){  
                Fauna_Node temp = null;  
                if (temp == root.left)  
                    temp = root.right;  
                else
                    temp = root.left;  
  
                // No child case  
                if (temp == null)  
                {  
                    temp = root;  
                    root = null;  
                }else // One child case  
                    root = temp; // Copy the contents of  
                                // the non-empty child  
            }else{  
                // node with two children: Get the inorder  
                // successor (smallest in the right subtree)  
                Fauna_Node temp = minValueNode(root.right);  
  
                // Copy the inorder successor's data to this node  
                root.key = temp.key;  
  
                // Delete the inorder successor  
                root.right = deleteNode(root.right, temp.key);  
            }  
        }  
        // If the tree had only one node then return  
        if (root == null)  
            return root;  
  
        // STEP 2: UPDATE HEIGHT OF THE CURRENT NODE  
        root.height = max(height(root.left), height(root.right)) + 1;  
  
        // STEP 3: GET THE BALANCE FACTOR OF THIS NODE (to check whether  
        // this node became unbalanced)  
        int balance = getBalance(root);  
  
        // If this node becomes unbalanced, then there are 4 cases  
        // Left Left Case  
        if (balance > 1 && getBalance(root.left) >= 0)  
            return rightRotate(root);  
  
        // Left Right Case  
        if (balance > 1 && getBalance(root.left) < 0)  {  
            root.left = leftRotate(root.left);  
            return rightRotate(root);  
        }  
        // Right Right Case  
        if (balance < -1 && getBalance(root.right) <= 0)  
            return leftRotate(root);  
        // Right Left Case  
        if (balance < -1 && getBalance(root.right) > 0){  
            root.right = rightRotate(root.right);  
            return leftRotate(root);  
        }  
  
        return root;  
    }  
 //
   void preOrder(Fauna_Node node) { 
        if (node != null) { 
            System.out.print(node.key.getId() + " "); 
            preOrder(node.left); 
            preOrder(node.right); 
        } 
    }  
}
