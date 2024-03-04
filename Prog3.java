package queue;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * 3. Write a menu driven program to implement a deque using list.
Call the two ends of the deque left and right and write four C functions, remvLeft,
remvRight, insrtLeft, insrtRight to remove and insert elements at the left and right
ends of the deque. Make sure that the routines work properly for empty deque and
that they detect overflow and underflow
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

class Deque<T> {
	
	int right;
	int left;
	int size;
	ArrayList<T> deque;
	
	Deque() {
		right = -1;
		left = -1;
		deque = new ArrayList<>();
	}
	
	void insrtLeft(T val) throws OverflowException {
		if(left == -1)
			left = 0;
		
		deque.add(left, val);
	}
	
	void remvRight() throws UnderflowException {
		if(left == 0 || right == 0)
			throw new UnderflowException();
		
		if(left == right) {
			left = -1;
			right = -1;
		}
		
		else
			deque.remove(--right);
	}
	
	void insrtRight(T val) throws OverflowException {
		right++;    
		deque.add(val);    	 
	}
	
	void remvLeft() throws UnderflowException {
		 if(left == -1 && right == -1)
			 throw new UnderflowException();
		 
		 else if(left == right) {
			 left = -1;
			 right = -1;
		 }    
		
		  else
			  deque.remove(++left);
	}
	
	public ArrayList<T> getDeque() {
		return deque;
	}
}

public class Prog3<T> {

	public static void main(String[] args) throws OverflowException, UnderflowException {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("1. Input Restriction" + "\n2. Output Restriction" + "\n\nEnter your choice: ");
		int n = sc.nextInt();
		
		switch(n) {
		case 1: Deque<Integer> deque1 = new Deque<>();
				deque1.insrtRight(1);
				deque1.insrtRight(2);
				deque1.insrtRight(3);
				deque1.insrtRight(4);
				deque1.remvLeft();
				deque1.remvRight();
				deque1.remvRight();
				deque1.remvRight();
				
				System.out.print("Elements: " + deque1.getDeque());
				break;
		
		case 2: Deque<Integer> deque2 = new Deque<>();
				deque2.insrtLeft(1);
				deque2.insrtLeft(2);
				deque2.insrtRight(3);
				deque2.insrtRight(4);
				deque2.remvLeft();
				deque2.remvLeft();
				deque2.remvLeft();
				deque2.remvLeft();
				
				System.out.println("Elements: " + deque2.getDeque());
				break;
				
		default: System.out.println("Enter valid choice");
		
		}
	}
}
