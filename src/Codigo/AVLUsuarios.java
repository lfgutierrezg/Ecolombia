/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Codigo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

class NodeAVLU {

 UsuarioRegistrado key; 
 int height; 
 NodeAVLU left, right;

 NodeAVLU(UsuarioRegistrado d) {
    key = d;
    height = 1;
 }
 }


 public class AVLUsuarios {

    NodeAVLU root;

 int height(NodeAVLU N) {
 if (N == null)
 return 0;

 return N.height;
 }

 int max(int a, int b) {
 return (a > b) ? a : b;
 }

 NodeAVLU rightRotate(NodeAVLU y) {
 NodeAVLU x = y.left;
 NodeAVLU T2 = x.right;

 // Perform rotation
 x.right = y;
 y.left = T2;

 // actualiza alturas
 y.height = max(height(y.left),height(y.right))+1;
 x.height = max(height(x.left),height(x.right))+1;
 

 // Return new root
 return x;
 }

 NodeAVLU leftRotate(NodeAVLU x) {
 NodeAVLU y = x.right;
 NodeAVLU T2 = y.left;

 // configura la rotación
 y.left = x;
 x.right = T2;

 // actualiza alturas
 x.height = max(height(x.left),height(x.right))+1;
 y.height = max(height(y.left),height(y.right))+1;

 return y;
 }

 int getBalance(NodeAVLU N) {
 if (N == null)
 return 0;

 return height(N.left) - height(N.right);
 }
 NodeAVLU Find(NodeAVLU node, UsuarioRegistrado key) {


    if (node == null){
    return (null);}

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
 NodeAVLU insert(NodeAVLU node, UsuarioRegistrado key) {


 if (node == null){
 return (new NodeAVLU(key));}

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
 NodeAVLU minValueNode(NodeAVLU node)  
    {  
        NodeAVLU current = node;  
  
        /* loop down to find the leftmost leaf */
        while (current.left != null)  
        current = current.left;  
  
        return current;  
    }  
  
    NodeAVLU deleteNode(NodeAVLU root, UsuarioRegistrado key)  
    {  
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
        else
        {  
  
            // node with only one child or no child  
            if ((root.left == null) || (root.right == null))  
            {  
                NodeAVLU temp = null;  
                if (temp == root.left)  
                    temp = root.right;  
                else
                    temp = root.left;  
  
                // No child case  
                if (temp == null)  
                {  
                    temp = root;  
                    root = null;  
                }  
                else // One child case  
                    root = temp; // Copy the contents of  
                                // the non-empty child  
            }  
            else
            {  
  
                // node with two children: Get the inorder  
                // successor (smallest in the right subtree)  
                NodeAVLU temp = minValueNode(root.right);  
  
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
        if (balance > 1 && getBalance(root.left) < 0)  
        {  
            root.left = leftRotate(root.left);  
            return rightRotate(root);  
        }  
  
        // Right Right Case  
        if (balance < -1 && getBalance(root.right) <= 0)  
            return leftRotate(root);  
  
        // Right Left Case  
        if (balance < -1 && getBalance(root.right) > 0)  
        {  
            root.right = rightRotate(root.right);  
            return leftRotate(root);  
        }  
  
        return root;  
    }  
 //
   void preOrder(NodeAVLU node) { 
        if (node != null) { 
            System.out.print(node.key.getId() + " "); 
            preOrder(node.left); 
            preOrder(node.right); 
        } 
    } 

   
   void preOrderOutput(NodeAVLU node,OutputStreamWriter Out) { 
        if (node != null) { 
            
            try {
                Out.write(node.key.getCorreo()+","+node.key.getPassword()+","
                        +node.key.getInstitucion()+","+node.key.getProfesion()+","+node.key.getNombres() 
                        +","+node.key.getApellidos()+","+node.key.getId()+"\n");
            } catch (IOException ex) {
                Logger.getLogger(AVLUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            }
; 
            preOrderOutput(node.left,Out); 
            preOrderOutput(node.right,Out); 
        } 
    } 
 }     
        

