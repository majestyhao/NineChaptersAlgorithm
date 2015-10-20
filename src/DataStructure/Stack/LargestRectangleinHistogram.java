package DataStructure.Stack;

import java.util.ArrayList;
import java.util.Stack;

public class LargestRectangleinHistogram {
	/**
	 * O(n): amortized push pop ops
     * @param height: A list of integer
     * @return: The area of largest rectangle in the histogram
     */
    public int largestRectangleArea(int[] height) {
    	if (height.length == 0) {
    		return 0;
    	}
    	    	
    	int[] newHeight = new int[height.length + 2];
    	newHeight[0] = -2;
    	for (int i = 0; i < height.length; i++) {
    		newHeight[i + 1] = height[i];
    	}
    	newHeight[newHeight.length - 1] = -1;
    	Stack<Integer> stack = new Stack<Integer>();
    	stack.push(0);
    	ArrayList<Integer> result = new ArrayList<Integer>();
    	for (int i = 1; i < newHeight.length; i++) {
    		while (newHeight[i] < newHeight[stack.peek()]) {
    			int tmpHeight = newHeight[stack.pop()];
    			//System.out.println(tmpHeight);
    			//System.out.println(stack.peek());
    			//System.out.println((i - stack.peek() + 1) );
    			result.add((i - stack.peek() - 1) * tmpHeight); 
    			//System.out.println(result);
    		}
    		stack.push(i);
    		//System.out.println(stack);
    	}
    	
    	int max = 0;
    	for (int i = 0; i < result.size(); i++) {
    		if (result.get(i) > max) {
    			max = result.get(i);
    		}
    	}
    	
    	return max;
    }

}
