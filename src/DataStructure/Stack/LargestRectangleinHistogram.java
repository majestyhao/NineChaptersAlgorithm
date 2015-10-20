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
		int[] tmp = new int[height.length + 2];
		tmp[0] = -2;
		for (int i = 1; i <= height.length; i++) {
			tmp[i] = height[i - 1];
		}
		tmp[tmp.length - 1] = -1;
		height = tmp;

		int res = 0;
		stack.push(0);
		for (int i = 1; i < height.length; i++) {
			while (height[i] < height[stack.peek()]){
				int tmpHeight = height[stack.pop()];
				int size = (i - stack.peek() - 1) * tmpHeight;
				res = Math.max(res, size);
			}
			stack.push(i);
		}

		return res;
	}

}
