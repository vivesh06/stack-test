package com.bmw.test.stack;
import java.util.Arrays;

/**
 * Stack implementation
 * 
 *
 */
public class Stack<T> {
	
	private static final int DEFAULT_LENGTH  = 10;
	private static final int MAX_STACK  = 15;
	
	private int topIndex = -1; //holds the index of recently pushed element
	
	private Object[] data; //actual data
	
	public Stack() {
		this.data = new Object[DEFAULT_LENGTH]; //initial size of 10;
	}
	
	/**
	 * Adds element to the array. increase array size if it exceeds current limit.
	 * Synchronzed - to make it thread safe.
	 * 
	 * @param e
	 */
	public synchronized void push(T e) { 
		
		if(topIndex >= MAX_STACK-1) throw new IllegalStateException("Stack overflown");
		
		if(this.topIndex >= this.data.length-1) { //if the array full, grow the array size
			this.data = Arrays.copyOf(this.data, this.data.length + DEFAULT_LENGTH);
		}
		this.data[++topIndex] = e; //incrment topIndex and add the element at that position.
	}
	
	/**
	 * Remove top element
	 * Synchronized - to make it thread safe.
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public synchronized T pop() {
		
		if(this.isEmpty()) throw new IllegalStateException("Can't pop as the stack is empty.");
		
		T popped = (T) this.data[this.topIndex]; //get the most recently pushed
		this.data[topIndex--] = null; //remove the elment at the top index and decrment topIndxe
		
		System.out.println("pop -> " + popped);
		
		return popped;
	}
	
	/**
	 * if top is negative, there are no elemts.
	 * 
	 * @return
	 */
	public boolean isEmpty() {
		return this.topIndex < 0;
	}
	
	/**
	 * returns the size of the stack.
	 * 
	 * @return
	 */
	public int count() {
		return this.topIndex + 1;
	}

}
