package stack;

/*
 * 1. Write a program to implement a Stack class (use a Array to store the elements of the stack).
		[Implement Stack Overflow and Underflow by user defined Exception]. 
		Write a method to check two stack are carrying similar elements or not.
		(Repetition of the elements are not consider)
 */

class StackOverflowException extends Exception {

	String msg;

	StackOverflowException() {
		this.msg = "Stack Overflow";
	}

	StackOverflowException(String msg) {
		this.msg = msg;
	}
}

class StackUnderflowException extends Exception {

	String msg;

	StackUnderflowException() {
		this.msg = "Stack Underflow";
	}

	StackUnderflowException(String msg) {
		this.msg = msg;
	}
}

class Stack<T>{

	private T[] data;
	private int size;
	private int top = -1;
	private String name = null;

	public Stack(int size) {
		this.data = (T[]) new Object[size];
		this.size = size;
	}
	
	public Stack(int size, String name) {
		this.data = (T[]) new Object[size];
		this.size = size;
		this.name = name;
	}

	public void push(T elem) throws StackOverflowException {
		if(this.top == this.data.length - 1)
			throw new StackOverflowException();

		else {
			top++;
			this.data[top] = elem;
		}
	}

	public T pop() throws StackUnderflowException {
		if(this.top < 0)
			throw new StackUnderflowException();

		T elem = this.data[top];
		top--;
		
		return elem;
	}

	public T peek() throws StackUnderflowException {
		if(this.top < 0)
			throw new StackUnderflowException();
		
		return this.data[top];
	}

	public boolean equals(Stack that) {
		if(this.top != that.top)
			return false;
		
		else {
			for(int i = 0; i < this.size; i++) {
				if(this.data[i] == that.data[i])
					continue;
				else
					return false;
			}
		}
		
		return true;
	}
	
	public boolean isEmpty() {
		if(this.top < 0) {
			return true;
		}
		
		return false;
	}

	public int getSize() {
		return size;
	}

	public int getTop() {
		return top;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

public class Prog1 {

	public static void main(String[] args) throws StackOverflowException, StackUnderflowException {

		Stack ob1 = new Stack(5, "Stack1");
		Stack ob2 = new Stack(5, "Stack2");
		
		ob1.push(1);
		ob1.push(2);
		ob1.push(3);
		System.out.println("Deleted element: " + ob1.pop());

		ob2.push(4);
		ob2.push(5);
		ob2.push(6);

		System.out.println("\nAre two stacks equal? ");
		System.out.println(ob1.equals(ob2));
	}
}