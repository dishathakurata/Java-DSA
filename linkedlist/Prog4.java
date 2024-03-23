package linkedlist;

import java.util.Scanner;

/*
 * 1. Write a program to implement a stack using linked list, such that the operations ‘push’
and ‘pop’ are performed in constant time.
 */

class StackLinkedList<T> {
	
	class Node<T> {
		T data;
		Node<T> next;
		
		Node(T data) {
			this.data = data;
			this.next = null;
		}
	}
	
	Node<T> top;
	
	
	StackLinkedList() {
		this.top = null;
	}
	
	//Push
	void push(T data) {
		Node<T> newNode = new Node<>(data);
		
		newNode.next = top;
        top = newNode;
	}
	
	//Pop
	T pop() {
		if(isEmpty())
            return null;
		
		T popped = top.data;
		top = top.next;
		return popped;
	}
	
	T peek() {
		if(isEmpty())
			return null;
		
        return top.data;
	}
	
	boolean isEmpty() {
		return top == null;
	}
}

public class Prog4 {

	public static void main(String[] args) {
		StackLinkedList<Integer> stack = new StackLinkedList<>();
		Scanner sc = new Scanner(System.in);
		boolean flag = true;
		int data;
		
		while(flag) {
			System.out.print("\n0. Exit \n"
					+ "1. Push \n"
					+ "2. Pop \n"
					+ "Enter your choice: ");
			int ch = sc.nextInt();
			
			switch(ch) {
				case 0:
					flag = false;
					break;
					
				case 1:
					System.out.print("Enter an element to be inserted: ");
					data = sc.nextInt();
					stack.push(data);
					System.out.println("Element pushed!!!");
					System.out.println("Peek element= " + stack.peek());
					break;
					
				case 2:
					System.out.println("Popped element= " + stack.pop());
					break;
					
				default:
					System.out.println("Enter valid choice");
			}
		}
	}
}