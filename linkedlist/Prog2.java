package linkedlist;

import java.util.Scanner;

/*
 * 1. Write a menu driven program to implement a doubly linked list with the following
operations
a. Insert an element at any position (front, end or intermediate)
b. Delete an element from any position (front, end or intermediate)
c. Display the list
 */


class DoublyLinkedList<T> {
	
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
	Node<T> tail;
	
	
	DoublyLinkedList() {
    	this.head = null;
    	this.tail = null;
    }
	
	//a. Insert an element at any front
	void insertFront(T data) {
		Node<T> newNode = new Node<>(data);
		
        if(head == null) {
            head = newNode;
            tail = newNode;
        }
        
        else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
	}
	
	//a. Insert an element at any end
	void insertEnd(T data) {
		Node<T> newNode = new Node<>(data);
		
		if(head == null) {
            head = newNode;
            tail = newNode;
        }
		
		else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
	}
	
	//a. Insert an element at any intermediate
	void insertIntermediate(int pos, T data) {
		if(pos < 0)
            System.out.println("Invalid position");
            
		else if(pos == 0)
            insertFront(data);
        
        else {
        	Node<T> newNode = new Node<>(data);
        	Node<T> curr = head;
        	
        	for(int i = 1; curr.next != null && i < pos; i++)
        		curr = curr.next;
        	
        	if(curr.next == null)
        		insertEnd(data);
        		
        	else if(curr == null)
        		System.out.println("Position out of bounds");
        	
        	else {
        		newNode.next = curr.next;
        		newNode.prev = curr;
        		if(curr.next != null)
        			curr.next.prev = newNode;
        		
        		else
        			tail = newNode;
        			
        		curr.next = newNode;
        	}
        }
	}
	
	//b. Delete an element from front
	void deleteFront() {
		if(head == null)
			System.out.println("List is already empty");
		
		else if(head.next == null) {
			head = null;
			tail = null;
		}
		
		else {
			head = head.next;
			head.prev = null;
		}
	}
	
	//b. Delete an element from end
	void deleteEnd() {
		if(head == null)
			System.out.println("List is already empty");
		
		else if(head.next == null) {
			head = null;
			tail = null;
		}
		
		else {
			tail = tail.prev;
			tail.next = null;
		}
	}
	
	//b. Delete an element from intermediate
	void deleteIntermediate(int pos) {
		if(head == null)
			System.out.println("List is already empty");
		
		else if(pos < 0)
			System.out.println("Invalid position");
		
		else if(pos == 0)
			deleteFront();
		
		else {
			Node<T> curr = head;
			
			for(int i = 0; curr.next != null && i <= pos; i++)
				curr = curr.next;
			
			if(curr.next == null)
				deleteEnd();
			
			else if(curr == null)
				System.out.println("Position out of bounds");
			
			else if(curr.next != null)
				curr.next.prev = curr.prev;
			
			else
				tail = curr.prev;
			
			curr.prev.next = curr.next;
		}
	}
	
	//c. Display the list
	void display() {
		if(head == null)
			System.out.println("List is empty");
		
		else {
			Node<T> curr = head;
			
			while(curr != null) {
				System.out.print(curr.data + " -> ");
				curr = curr.next;
			}
			System.out.println();
		}
	}
}

public class Prog2 {

	public static void main(String[] args) {
		DoublyLinkedList<Integer> DLL = new DoublyLinkedList<>();
		boolean flag = true;
		int data, pos;
		Scanner sc = new Scanner(System.in);
		
		while(flag) {
			System.out.print("\n0. Exit \n"
								+ "1. Insert\n"
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
							DLL.insertFront(data);
							System.out.println("Element inserted!!!");
							DLL.display();
							break;
							
						case 2:
							System.out.print("Enter an element to be inserted: ");
							data = sc.nextInt();
							DLL.insertEnd(data);
							System.out.println("Element inserted!!!");
							DLL.display();
							break;
							
						case 3:
							System.out.print("Enter an element to be inserted: ");
							data = sc.nextInt();
							System.out.println("Enter position where the element to be inserted: ");
							pos = sc.nextInt();
							DLL.insertIntermediate(pos, data);
							System.out.println("Element inserted!!!");
							DLL.display();
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
							DLL.deleteFront();
							System.out.println("Element deleted!!!");
							DLL.display();
							break;
			
						case 2:
							DLL.deleteEnd();
							System.out.println("Element deleted!!!");
							DLL.display();
							break;
			
						case 3:
							System.out.println("Enter position where the element to be deleted: ");
							pos = sc.nextInt();
							DLL.deleteIntermediate(pos);
							System.out.println("Element deleted!!!");
							DLL.display();
							break;
							
						default:
							System.out.println("Enter valid choice");
					}
					break;
					
				case 3:
					DLL.display();
					break;
					
				default:
					System.out.println("Enter valid choice");
			}
		}
	}
}