package queue;

/*
 * 1. Write a program to implement a Queue class (use a list to store the elements of the
Queue). [Implement Queue Overflow and Underflow by Exception]. Write a
method to check two Queue are carrying similar elements or not. (Repetition of the
elements are not consider)
 */

import java.util.ArrayList;

class UnderflowException extends Exception {

	String msg;

	UnderflowException() {
		this.msg = "Stack Overflow";
	}

	UnderflowException(String msg) {
		this.msg = msg;
	}
}

class GenericQueue<T> {
	
	int rear;
	int front;
	ArrayList<T> queue;

	GenericQueue() {
		rear=0;
		front=0;
		queue=new ArrayList<>();
	}

	public ArrayList<T> getQueue() {
		return queue;
	}

	boolean isEmpty() {
		return rear==front;
	}

	void insert(T data) {
		queue.add(data);
		rear++;
	}

	T serve() throws UnderflowException {
		if(isEmpty())
			throw new UnderflowException();
		
		else {
			queue.remove(front);
			front++;
		}
		return null;
	}
	
	public boolean equals(GenericQueue that) {
		if(this.queue.size() != that.queue.size())
			return false;
		
		else {
			for(int i = 0; i < this.queue.size(); i++) {
				if(this.queue.get(i) == that.queue.get(i)) {
					continue;
				}
				else
					return false;
			}
			return true;
		}
	}
	
	public static boolean duplicate(GenericQueue ob) {
		for(int i = ob.front; i <= ob.rear; i++) {
			for(int j = i + 1; j < ob.queue.size(); j++) {
				if(ob.queue.get(i) == ob.queue.get(j))
					return true;
			}
		}
		
		return false;
	}
}

public class Prog1 {
	
	public static void main(String[] args) throws UnderflowException {
		GenericQueue<Integer> q1=new GenericQueue<>();
		
		q1.insert(1);
		q1.insert(2);
		q1.insert(3);
		q1.insert(4);
		q1.serve();
		if(!q1.duplicate(q1))
			System.out.println("Queue: "+q1.getQueue());
		else
			System.out.println("Duplicate element exists");
		
		GenericQueue<Integer> q2=new GenericQueue<>();
		
		q2.insert(5);
		q2.insert(6);
		q2.insert(7);
		q2.insert(8);
		q2.serve();
		if(!q2.duplicate(q2))
			System.out.println("Queue: "+q2.getQueue());
		else
			System.out.println("Duplicate element exists");
		
		if(q1.equals(q2)) 
			System.out.println("Both queues are equal");
		else
			System.out.println("Boths queues are not equal");
	}
}