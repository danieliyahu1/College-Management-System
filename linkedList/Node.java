/*
assignment number : 8
File name : 		Node.java
Name : 				Daniel Eliyahu
ID : 				316461656
Email : 			danieliyahu1@gmail.com
*/

package linkedList;

/**
 * Represents a generic node in a generic linked list.
 */
public class Node<E> {
	E e;            // The E object that this node refers to
	Node<E> next;   // The Node object that this node refers to
	
	/** 
	 * Constructs a generic node that refers to the given element.
	 * @param e the element.
	 */
	public Node(E e) {
		this.e = e;
		this.next = null;
	}
	
	/** 
	 * Returns a textual representation of the element that this node refers to,
	 * by calling the toString() method of the element.
	 */
	public String toString() {
		return e.toString();
	}
}