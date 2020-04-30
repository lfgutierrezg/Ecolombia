package Codigo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author danie
 */
public class Node<T> {
    T key;
    Node next;
	
	Node(T key){
		this.key=key;
		this.next=null;
		
	}
}
