package DataStructure.Stack;

import java.util.Stack;

public class ImplementQueuebyTwoStacks {
	private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    /*
     * stack1 for push
     * stack2 for pop
     */
    public ImplementQueuebyTwoStacks() {
    	stack1 = new Stack<Integer>();
    	stack2 = new Stack<Integer>();
    }
    
    public void push(int element) {
    	stack1.push(element);
    }
    
    private void stack1ToStack2() {
    	while (!stack1.isEmpty()) {
    		//for (int i = 0; i < stack1.size(); i++) {
    			//stack2.push(stack1.peek());
    			//stack1.pop();
    			stack2.push(stack1.pop());
    		
    	}
    }

    public int pop() {
    	if (stack2.isEmpty()) {
    		stack1ToStack2();
    	}
    	
    	return stack2.pop();
    }

    public int top() {
    	if (stack2.isEmpty()) {
    		stack1ToStack2();
    	}
    	
    	return stack2.peek();
    }

	// Return whether the queue is empty.
	public boolean empty() {
		return stack1.isEmpty() && stack2.isEmpty();
	}

}
