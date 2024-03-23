package linkedlist;

import java.util.Scanner;

/*
 * 1. Write a menu driven program to implement a singly linked list with the following
operations
a. Insert an element at any position (front, end or intermediate)
b. Delete an element from any position (front, end or intermediate)
c. Display the list
d. Perform a linear search on the list
e. Insert an element after a specified element
f. Delete a specified element
g. Count the number of nodes
h. Reverse the list, so that the last element becomes the first, and so on
i. Concatenate two lists
 */


class SinglyLinkedList<T> {
	
	class Node<T> {
		T data;
		Node<T> next;
		
		Node(T data) {
			this.data = data;
			this.next = null;
		}
	}
	
	Node<T> head;

	
    SinglyLinkedList() {
    	this.head = null;
    }
    
    //a. Insert an element at front
    void insertFront(T data) {
    	Node<T> newNode = new Node<>(data);
        newNode.next = head;
        head = newNode;
    }
    
    //a. Insert an element at end
    void insertEnd(T data) {
    	Node<T> newNode = new Node<>(data);
    	
    	if(head == null)
    		head = newNode;
    	
    	else {
    		Node<T> curr = head;
    		
    		while(curr.next != null)
    			curr = curr.next;
    		
    		curr.next = newNode;
    	}
    }
    
    //a. Insert an element at intermediate
    void insertIntermediate(int pos, T data) {
    	if(pos < 0)
    		System.out.println("Invalid position");
    	
    	else if(pos == 0)
    		insertFront(data);

    	else {
    		Node<T> newNode = new Node<>(data);
    		Node<T> curr = head;
    		
    		for(int i = 1; curr != null && i < pos; i++) {
                curr = curr.next;
            }
    		
    		if(curr.next == null)
    			insertEnd(data);
    		
    		else if(curr == null)
                System.out.println("Position out of bounds");
            
            else {
            	newNode.next = curr.next;
            	curr.next = newNode;
            }
    	}
    }
    
    //b. Delete an element from front
    void deleteFront() {
    	if(head == null)
    		System.out.println("List is already empty");
    	
    	else
    		head = head.next;
    }
    
    //b. Delete an element from end
    void deleteEnd() {
    	if(head == null)
    		System.out.println("List is already empty");
    	
    	else if(head.next == null)
    		head = head.next;
    	
    	else {
    		Node<T> curr = head;
    		
    		while(curr.next.next != null)
    			curr = curr.next;
    		
    		curr.next = null;
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
    		
    		for(int i = 1; curr != null && i < pos; i++) {
                curr = curr.next;
            }
    		
    		if(curr.next == null)
    			deleteEnd();
    		
    		else if(curr == null)
                System.out.println("Position out of bounds");
            
            else {
            	curr.next = curr.next.next;
            }
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
    
    //d. Perform a linear search on the list
    boolean search(T data) {
    	Node<T> curr = head;
    	
    	while(curr != null) {
    		if(curr.data == data)
    			return true;
    		
    		curr = curr.next;
    	}
    	
    	return false;
    }
    
    //e. Insert an element after a specified element
    void insertAfterElem(T preData, T data) {
    	Node<T> curr = head;
    	
    	while(curr != null && curr.data != preData)
    		curr = curr.next;
    	
    	if(curr == null)
    		System.out.println(preData + " doesn't exist");
    	
    	else {
    		Node<T> newNode = new Node<>(data);
    		newNode.next = curr.next;
    		curr.next = newNode;
    	}
    }
    
    //f. Delete a specified element
    void deleteElem(T data) {
    	if(head.data == data)
    		deleteFront();
    	
    	Node<T> curr = head;
    	
    	while(curr != null && curr.next.data != data)
    		curr = curr.next;
    	
    	if(curr.next == null)
    		System.out.println(data + " doesn't exist");
    	
    	else if(curr.next.next == null)
    		deleteEnd();
    	
    	else
    		curr.next = curr.next.next;
    }
    
    //g. Count the number of nodes
    int countNodes() {
    	int count = 0;
    	Node<T> curr = head;
    	
    	while(curr != null) {
    		count += 1;
    		curr = curr.next;
    	}
    	
    	return count;
    }
    
    //h. Reverse the list, so that the last element becomes the first, and so on
    void reverse() {
    	Node<T> curr = head;
    	Node<T> prev = null;
    	Node<T> next = null;
    	
    	while(curr != null) {
    		next = curr.next;
    		curr.next = prev;
    		prev = curr;
    		curr = next;
    	}
    	
    	head = prev;
    }
    
    //i. Concatenate two lists
    void concat(SinglyLinkedList<T> list2) {
    	if(head == null)
    		head = list2.head;
    	
    	else {
    		Node<T> curr = head;
    		
    		while(curr.next != null)
    			curr = curr.next;
    		
    		curr.next = list2.head;
    	}
    }
}

public class Prog1 {
	public static void main(String[] args) {
		SinglyLinkedList<Integer> SLL = new SinglyLinkedList<>();
		int data, preData, pos;
		boolean flag = true;
		
		while(flag) {
			System.out.print("\n0. Exit \n"
					+ "1. Insert \n"
					+ "2. Delete \n"
					+ "3. Display the list \n"
					+ "4. Search on the list \n"
					+ "5. Count the number of nodes \n"
					+ "6. Reverse the list \n"
					+ "7. Concatenate two lists \n"
					+ "Enter you choice: ");
			
			Scanner sc = new Scanner(System.in);
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
										+ "4. After an element \n"
										+ "Enter your choics: ");
					int chInsert = sc.nextInt();
				
					switch(chInsert) {
						case 1:
							System.out.print("\nEnter an element to be inserted: ");
							data = sc.nextInt();
							SLL.insertFront(data);
							System.out.println("\nElement inserted!!!");
							SLL.display();
							break;
					
						case 2:
							System.out.print("\nEnter an element to be inserted: ");
							data = sc.nextInt();
							SLL.insertEnd(data);
							System.out.println("\nElement inserted!!!");
							SLL.display();
							break;
					
						case 3:
							System.out.print("\nEnter an element to be inserted: ");
							data = sc.nextInt();
							System.out.print("Enter position where the element needs to be inserted: ");
							pos = sc.nextInt();
							SLL.insertIntermediate(pos, data);
							System.out.println("\nElement inserted!!");
							SLL.display();
							break;
					
						case 4:
							System.out.print("\nEnter an element to be inserted: ");
							data = sc.nextInt();
							System.out.print("Enter element after which the element needs to be inserted: ");
							preData = sc.nextInt();
							SLL.insertAfterElem(preData, data);
							System.out.println("\nElement inserted!!");
							SLL.display();
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
										+ "4. A specified element \n"
										+ "Enter your choics: ");
				
					int chDelete = sc.nextInt();
				
					switch(chDelete) {
						case 1:
							SLL.deleteFront();
							System.out.println("\nElement deleted!!!");
							SLL.display();
							break;
					
						case 2:
							SLL.deleteEnd();
							System.out.println("\nElement deleted!!!");
							SLL.display();
							break;
					
						case 3:
							System.out.print("Enter position from where the element needs to be deleted: ");
							pos = sc.nextInt();
							SLL.deleteIntermediate(pos);
							System.out.println("\nElement deleted!!");
							SLL.display();
							break;
					
						case 4:
							System.out.print("Enter element which needs to be deleted: ");
							data = sc.nextInt();
							SLL.deleteElem(data);
							System.out.println("\nElement deleted!!");
							SLL.display();
							break;
					
						default:
							System.out.println("Enter valid choice");
					}
					break;
				
				case 3:
					SLL.display();
					break;
				
				case 4:
					System.out.print("Enter an element to be searched: ");
					data = sc.nextInt();
					System.out.println(SLL.search(data));
					break;
				
				case 5:
					System.out.print("Number of nodes= " + SLL.countNodes());
					break;
				
				case 6:
					System.out.print("Reverse: ");
					SLL.reverse();
					SLL.display();
					break;
			
				case 7:
					SinglyLinkedList<Integer> SLL2 = new SinglyLinkedList<>();
					SLL2.insertFront(11);
                    SLL2.insertEnd(12);
                    SLL2.insertEnd(13);
					System.out.print("Concatenation of two singly linked list: ");
					SLL.concat(SLL2);
					SLL.display();
					break;
			
				default:
					System.out.println("Enter valid choice");
			}
		}
	}
}