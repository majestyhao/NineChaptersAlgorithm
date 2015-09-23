package DataStructure;

import java.util.Stack;

public class MinStack {
	
	Stack<Integer> stack; 
	Stack<Integer> minSeq;
	
	public MinStack() {
		stack = new Stack<Integer>();
		minSeq = new Stack<Integer>();
    }

    public void push(int number) {
    	stack.push(number);
    	if (minSeq.isEmpty() || number < minSeq.peek()) {
    		minSeq.push(number);
    	} else {
    		minSeq.push(minSeq.peek());
    	}
    }

    public int pop() {
    	minSeq.pop();
    	return stack.pop();
    }

    public int min() {
    	return minSeq.peek();
    }

}
