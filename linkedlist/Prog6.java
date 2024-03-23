package linkedlist;

import java.util.Scanner;

//3. Write a menu driven program to implement a double ended queue using linked list.


class DequeLinkedList<T> {
	
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
	
    Node<T> front;
    Node<T> rear;

    DequeLinkedList() {
        this.front = null;
        this.rear = null;
    }

    //Insert at front
    void insertFront(T data) {
        Node<T> newNode = new Node<>(data);
        
        if(isEmpty()) {
            front = newNode;
            rear = newNode;
        }
        
        else {
            newNode.next = front;
            front.prev = newNode;
            front = newNode;
        }
    }

    //Insert at rear
    void insertRear(T data) {
        Node<T> newNode = new Node<>(data);
        
        if(isEmpty()) {
            front = newNode;
            rear = newNode;
        } 
        
        else {
            rear.next = newNode;
            newNode.prev = rear;
            rear = newNode;
        }
    }

    //Delete from front
    T deleteFront() {
        if (isEmpty())
            return null;
            
        T removed = front.data;
        
        if(front == rear) {
            front = null;
            rear = null;
        } 
        
        else {
            front = front.next;
            front.prev = null;
        }
        
        return removed;
    }

    //Delete from rear
    T deleteRear() {
        if(isEmpty())
            return null;
            
        T removed = rear.data;
        
        if(front == rear) {
            front = null;
            rear = null;
        } 
        
        else {
            rear = rear.prev;
            rear.next = null;
        }
        
        return removed;
    }

    public void display() {
        Node<T> curr = front;
        while(curr != null) {
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        }
        System.out.println();
    }

    boolean isEmpty() {
        return front == null;
    }
}

public class Prog6 {
    public static void main(String[] args) {
        DequeLinkedList<Integer> deque = new DequeLinkedList<>();
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        int data;

        while(flag) {
            System.out.print("\n0. Exit \n"
            					+ "1. Insert \n"
            					+ "2. Delete \n"
            					+ "3. Display \n"
            					+ "Enter you choice: ");
            int ch = sc.nextInt();

            switch(ch) {
            	case 0:
            		flag = false;
            		break;
            		
                case 1:
                    System.out.print("\nInsert at \n"
                    						+ "1. Front \n"
                    						+ "2. Rear \n"
                    						+ "Enter your choice: ");
                    int chInsert = sc.nextInt();
                    
                    switch(chInsert) {
                    	case 1:
                    		System.out.print("Enter an element to be inserted: ");
                            data = sc.nextInt();
                            deque.insertFront(data);
                            System.out.println("Element inserted!!!");
                            deque.display();
                            break;
                            
                    	case 2:
                    		System.out.print("Enter an element to inserted: ");
                            data = sc.nextInt();
                            deque.insertRear(data);
                            System.out.println("Element inserted!!!");
                            deque.display();
                            break;
                            
                        default:
                        	System.out.println("Enter valid choice");
                    }
                    break;
                case 2:
                	System.out.print("\nDelete from \n"
    						+ "1. Front \n"
    						+ "2. Rear \n"
    						+ "Enter your choice: ");
                	int chDelete = sc.nextInt();
    
                	switch(chDelete) {
                		case 1:
                			System.out.println("Dequeued element= " + deque.deleteFront());
                			deque.display();
                			break;
            
                		case 2:
                			System.out.println("Dequeued element= " + deque.deleteRear());
                			deque.display();
                			break;
            
                		default:
                			System.out.println("Enter valid choice");
                	}
                	break;
                	
                case 3:
                    deque.display();
                    break;
                    
                default:
                    System.out.println("Enter valid choice");
            }
        }
    }
}