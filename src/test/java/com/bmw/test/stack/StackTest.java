package com.bmw.test.stack;

import org.junit.Assert;
import org.junit.Test;

public class StackTest {
	
	@Test
	public void whenPushed() {
		Stack<Integer> stack = new Stack<>();
		stack.push(42);
		stack.push(66);
		stack.push(99);
		Assert.assertEquals(3, stack.count());
		Assert.assertFalse(stack.isEmpty());
	}

	@Test
	public void whenPopped() {
		Stack<Integer> stack = new Stack<>();
		stack.push(42);
		stack.push(66);
		stack.push(99);
		Assert.assertEquals(99, stack.pop().intValue());
		Assert.assertEquals(66, stack.pop().intValue());
		Assert.assertEquals(42, stack.pop().intValue());
	}
	
	@Test
	public void whenPushedMorethanArrayInitialSizeItMustResize() {
		Stack<Integer> stack = new Stack<>();
		stack.push(42);
		stack.push(66);
		stack.push(99);
		stack.push(33);
		stack.push(44);
		stack.push(78);
		stack.push(57);
		stack.push(98);
		stack.push(25);
		stack.push(84);
		stack.push(26);
		stack.push(24);
		Assert.assertEquals(12, stack.count()); //more than 10 elements
	}
	
	@Test(expected=IllegalStateException.class)
	public void whenNoElemtsaAndPoppedItMustThrowError() {
		Stack<Integer> stack = new Stack<>();
		Assert.assertEquals(null, stack.pop());
	}
	
	@Test(expected=IllegalStateException.class)
	public void whenMoreElementsThanStackMaxPushedThrowError() {
		Stack<Integer> stack = new Stack<>();
		stack.push(42);
		stack.push(66);
		stack.push(99);
		stack.push(33);
		stack.push(44);
		stack.push(78);
		stack.push(57);
		stack.push(98);
		stack.push(25);
		stack.push(84);
		stack.push(26);
		stack.push(24);
		stack.push(20);
		stack.push(30);
		stack.push(50);
		stack.push(70); //16th element
	}
	
}
