package DataStructure;

import java.util.PriorityQueue;

public class DataStreamMedian {
	/**
     * @param nums: A list of integers.
     * @return: the median of numbers
     */
    public int[] medianII(int[] nums) {
    	median = nums[0];
    	int[] result = new int[nums.length];
    	result[0] = median;
    	
    	for (int i = 1; i < nums.length; i++) {
    		if (nums[i] < median) {
    			maxHeap.add(-nums[i]);
    			median = balancing();
    		} else {
    			//System.out.print(i);
    			//System.out.println(':');
    			//System.out.print(median);
    			//System.out.print(' ');
    			minHeap.add(nums[i]);
    			median = balancing();
    		}
    		result[i] = median;
    	}
    	
    	return result;
    }
    
	PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(); // the right
	PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(); // the left
	int median;
    
    private int balancing() {
    	if (maxHeap.size() == minHeap.size() || maxHeap.size() == minHeap.size() - 1) {
    		System.out.println(median);
    		return median;
    	} else {
    		if (maxHeap.size() < minHeap.size()) {
    			maxHeap.add(-median);
    			median = minHeap.remove();
    		} else {
    			minHeap.add(median);
    			median = -maxHeap.remove();
    		}
    	}
    	return median;
    }
    
    
}
