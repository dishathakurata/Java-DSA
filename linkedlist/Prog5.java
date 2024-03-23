package linkedlist;

import java.util.Scanner;

/*
 * 2. Write a program to implement a queue using linked list, such that the operations
‘enqueue’ and ‘dequeue’ are performed in constant time.
 */

class QueueLinkedList<T> {
	
	class Node<T> {
		T data;
		Node<T> next;
		
		Node(T data) {
			this.data = data;
			this.next = null;
		}
	}
	
	Node<T> front;
	Node<T> rear;
	
	QueueLinkedList() {
		this.front = null;
		this.rear = null;
	}
	
	//Enqueue
	void enqueue(T data) {
		Node<T> newNode = new Node<>(data);
		
		if(isEmpty())
			front = newNode;
		
		else
			rear.next = newNode;
		
		rear = newNode;
	}
	
	//Dequeue
	T dequeue() {
		if(isEmpty())
			return null;
		
		T dequeued = front.data;
        front = front.next;
        
        if(front == null)
            rear = null;
        
        return dequeued;
	}
	
	boolean isEmpty() {
		return front == null;
	}
	
	void display() {
		Node<T> curr = front;
        
		while(curr != null) {
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        }
        System.out.println();
	}
}

public class Prog5 {

	public static void main(String[] args) {
		QueueLinkedList<Integer> queue = new QueueLinkedList<>();
		Scanner sc = new Scanner(System.in);
		boolean flag = true;
		int data;
		
		while(flag) {
			System.out.print("\n0. Exit \n"
					+ "1. Enqueue \n"
					+ "2. Dequeue \n"
					+ "3. Display \n"
					+ "Enter your choice: ");
			int ch = sc.nextInt();
			
			switch(ch) {
				case 0:
					flag = false;
					break;
					
				case 1:
					System.out.print("Enter an element to be inserted: ");
					data = sc.nextInt();
					queue.enqueue(data);
					System.out.println("Element pushed!!!");
					queue.display();
					break;
					
				case 2:
					System.out.println("Popped element= " + queue.dequeue());
					queue.display();
					break;
					
				case 3:
					queue.display();
					break;
					
				default:
					System.out.println("Enter valid choice");
			}
		}
	}
}