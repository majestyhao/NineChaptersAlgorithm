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
		Stack<Integer> stack = new Stack<Integer>();
		int[] tmp = new int[height.length + 1];
		for (int i = 0; i < height.length; i++) {
			tmp[i] = height[i];
		}
		tmp[height.length] = -1;
		height = tmp;

		int res = 0;
		stack.push(0);
		for (int i = 1; i < height.length; i++) {
			while (!stack.isEmpty() && height[i] < height[stack.peek()]){
				int index = stack.pop();
				int size = (i - index) * height[index];
				res = Math.max(res, size);
			}
			stack.push(i);
		}

		return res;
	}

}
