package linkedlist;

import java.util.Scanner;

import linkedlist.SinglyLinkedList.Node;

/*
 * 2. Write a menu driven program to implement a doubly circular linked list with the
following operations
a. Insert an element at any position (front, end or intermediate)
b. Delete an element from any position (front, end or intermediate)
c. Display the list
 */

class DoublyCircularLinkedList<T> {
	
	class Node<T> {
		T data;
		Node<T> prev;
		Node<T> next;
		
		Node(T data) {
			this.data = data;
			this.prev = null;
			this.next = null;
		}
	}
	
	Node<T> head;

	
    DoublyCircularLinkedList() {
    	this.head = null;
    }
    
    //a. Insert an element at front
    void insertFront(T data) {
    	Node<T> newNode = new Node<>(data);
    	
        if(head == null) {
            newNode.next = newNode;
            newNode.prev = newNode;
            head = newNode;
        }
        
        else {
            newNode.next = head;
            newNode.prev = head.prev;
            head.prev.next = newNode;
            head.prev = newNode;
            head = newNode;
        }
    }
    
    //a. Insert an element at end
    void insertEnd(T data) {
    	Node<T> newNode = new Node<>(data);
    	
        if(head == null) {
            newNode.next = newNode;
            newNode.prev = newNode;
            head = newNode;
        }
        
        else {
        	newNode.next = head;
            newNode.prev = head.prev;
            head.prev.next = newNode;
            head.prev = newNode;
        }
    }
    
    //a. Insert an element at intermediate
    void insertIntermediate(int pos, T data) {
    	Node<T> newNode = new Node<>(data);
    	Node<T> curr = head;
    	
    	if(pos < 0)
    		System.out.println("Invalid position");
    	
    	else if(pos == 0)
    		insertFront(data);
    	
    	else {
    		for(int i = 1; i < pos && curr != null; i++)
                curr = curr.next;
    		
    		if(curr.next == null)
        		insertEnd(data);
                
    		else if(curr == null)
                System.out.println("Position out of bounds");
            
            else {
            	newNode.next = curr.next;
            	newNode.prev = curr;
            	curr.next.prev = newNode;
            	curr.next = newNode;
            }
    	}
    }
    
    //b. Delete an element from front
    void deleteFront() {
    	if(head == null)
            System.out.println("List is already empty");

         else if(head.next == head)
            head = null;
    	
         else {
        	 head.prev.next = head.next;
        	 head.next.prev = head.prev;
        	 head = head.next;
         }
    }
    
    //b. Delete an element from end
    void deleteEnd() {
    	if(head == null)
            System.out.println("List is already empty");

         else if(head.next == head)
            head = null;
    	
         else {
        	 head.prev.prev.next = head;
        	 head.prev = head.prev.prev;
         }
    }
    
    //b. Delete an element from intermediate
    void deleteIntermediate(int pos) {
    	Node<T> curr = head;
    	
    	if(pos < 0)
    		System.out.println("Invalid position");
    	
    	else if(pos == 0)
    		deleteFront();
    	
    	else {
    		for(int i = 1; curr.next != null && i < pos; i++) {
    			curr = curr.next;
    			if(curr == head)
    				System.out.println("Invalid position");
    		}
    		
    		if(curr.next == null)
        		deleteEnd();
                
    		else if(curr == null)
                System.out.println("Position out of bounds");
    		
    		else if(curr.next != null) {
    			curr.prev.next = curr.next;
                curr.next.prev = curr.prev;
    		}
    	}
    }
    
    //c. Display the list
    void display() {
    	if(head == null)
            System.out.println("List is empty");
    	
    	else {
    		Node<T> curr = head;
    		
    		do {
    			System.out.print(curr.data + " -> ");
    			curr = curr.next;
    		} while(curr != head);
    		System.out.println();
    	}
    }
}

public class Prog3 {

	public static void main(String[] args) {
		DoublyCircularLinkedList<Integer> DCLL = new DoublyCircularLinkedList<>();
		Scanner sc = new Scanner(System.in);
		boolean flag = true;
		int data, pos;
		
		while(flag) {
			System.out.print("\n0. Exit \n"
					+ "1. Insert \n"
					+ "2. Delete \n"
					+ "3. Display \n"
					+ "Enter your choice: ");
			int ch = sc.nextInt();
			
			switch(ch) {
				case 0:
					flag = false;
					break;
					
				case 1:
					System.out.print("\nInsert at \n"
							+ "1. Front \n"
							+ "2. End \n"
							+ "3. Intermediate \n"
							+ "Enter your choice: ");
					int chInsert = sc.nextInt();
					
					switch(chInsert) {
						case 1:
							System.out.print("Enter an element to be inserted: ");
							data = sc.nextInt();
							DCLL.insertFront(data);
							System.out.println("Element inserted!!!");
							DCLL.display();
							break;
							
						case 2:
							System.out.print("Enter an element to be inserted: ");
							data = sc.nextInt();
							DCLL.insertEnd(data);
							System.out.println("Element inserted!!!");
							DCLL.display();
							break;
							
						case 3:
							System.out.print("Enter an element to be inserted: ");
							data = sc.nextInt();
							System.out.println("Enter position where the element to be inserted: ");
							pos = sc.nextInt();
							DCLL.insertIntermediate(pos, data);
							System.out.println("Element inserted!!!");
							DCLL.display();
							break;
							
						default:
							System.out.println("Enter valid choice");
					}
					break;
					
				case 2:
					System.out.print("\nDelete from \n"
										+ "1. Front \n"
										+ "2. End \n"
										+ "3. Intermediate \n"
										+ "Enter your choice: ");
					int chDelete = sc.nextInt();
	
					switch(chDelete) {
						case 1:
							DCLL.deleteFront();
							System.out.println("Element deleted!!!");
							DCLL.display();
							break;
			
						case 2:
							DCLL.deleteEnd();
							System.out.println("Element deleted!!!");
							DCLL.display();
							break;
			
						case 3:
							System.out.println("Enter position where the element to be deleted: ");
							pos = sc.nextInt();
							DCLL.deleteIntermediate(pos);
							System.out.println("Element deleted!!!");
							DCLL.display();
							break;
							
						default:
							System.out.println("Enter valid choice");
					}
					break;
					
				case 3:
					DCLL.display();
					break;
					
				default:
					System.out.println("Enter valid choice");
			}
		}
	}
}