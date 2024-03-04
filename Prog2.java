package queue;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * 2. Write a menu driven program to implement a circular queue (use an array to store
the elements of the queue).
You can follow any one of the schemes A circular list with front and rear indices and
one position left vacant. Or, A circular list with front and rear indices and an integer
variable counting entries
 */

class OverflowException extends Exception {

	String msg;

	OverflowException() {
		this.msg = "Stack Overflow";
	}

	OverflowException(String msg) {
		this.msg = msg;
	}
}

class UnderflowException extends Exception {

	String msg;

	UnderflowException() {
		this.msg = "Stack Overflow";
	}

	UnderflowException(String msg) {
		this.msg = msg;
	}
}

class LeftVacant<T> {
	int rear, front, size;
	T[] queue1;
	
	LeftVacant(int size) {
		rear=0;
		front=0;
		this.queue1 = (T[]) new Object[size];
		this.size = size;
	}
	
	boolean isFull() {
		return rear == size - 1;
	}
	
	boolean isEmpty() {
		return rear == front;
	}
	
	void insert(T elem) throws OverflowException {
		int newRear = (rear + 1) % size;
		if(isFull() || front == newRear)
			throw new OverflowException();
		
		else {
			rear = newRear;
			queue1[rear] = elem;
		}
	}
	
	T serve() throws UnderflowException {
		if(isEmpty()) 
			throw new UnderflowException();
		
		front = (front + 1) % size;
		return queue1[front];
	}
	
	void disp() {
		for(int i = this.front + 1; i <= this.rear; i++) {
			if(queue1[i] == null)
				continue;
			
			System.out.print(queue1[i] + " ");
		}
	}
	
}

class CountingEntries<T> {
	int rear, front, size, count = 0;
	T[] queue2;
	
	CountingEntries(int size) {
		this.size = size;
		rear = -1;
		front = -1;
		this.queue2 = (T[]) new Object[size];
	}
	
	void insert(T val) throws OverflowException {
		if((front == 0 && rear == size - 1) || front == rear + 1)
			throw new OverflowException();
		
		else if(front == -1 && rear == -1) {
			front = 0;
			rear = 0;
			queue2[rear] = val;
		}
		
		else if(front != 0 && rear == size - 1) {
			rear = 0;
			queue2[rear] = val;
		}
		
		else {
			rear++;
			queue2[rear] = val;
		}
		
		count++;
	}
	
	T serve() throws UnderflowException {
		T val;
		if(front == -1 && rear == -1)
			throw new UnderflowException();
		
		val = queue2[front];
		if(front == rear) {
			front = -1;
			rear = -1;
		}
		
		else {
			if(front == size - 1)
				front = 0;
			else
				front++;
		}
		
		count--;
		return val;
	}
	
	int count() {
		return count;
	}
}

public class Prog2<T> {

	public static void main(String[] args) throws OverflowException, UnderflowException {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("1. Left Vacant" + "\n2. Counting Entries" + "\n\nEnter your choice: ");
		int n = sc.nextInt();
		
		switch(n) {
		case 1: LeftVacant<Integer> lv = new LeftVacant<>(5);
		
				lv.insert(1);
				lv.insert(2);
				lv.insert(3);
		
				System.out.println("\nDeleted element: " + lv.serve());
				lv.insert(4);
				System.out.print("Queue elements: ");
				lv.disp();
				break;
				
		case 2: CountingEntries<Integer> c = new CountingEntries<>(5);
		
				c.insert(1);
				c.insert(2); 
				c.insert(3);
				c.insert(4);
				System.out.println("\nDeleted element: " + c.serve());
				c.insert(5);
				System.out.println("Number of elements= " + c.count());
				break;
				
		default: System.out.println("Enter valid choice");
		}
	}
}
