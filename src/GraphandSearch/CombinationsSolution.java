package GraphandSearch;

import java.util.List;
import java.util.ArrayList;


public class CombinationsSolution {
	/**
     * @param n: Given the range of numbers
     * @param k: Given the numbers of combinations
     * @return: All the combinations of k numbers out of 1..n
     */
    public List<List<Integer>> combine(int n, int k) {
    	if (n < 1 || k < 1) {
    		return new ArrayList<List<Integer>>();
    	}
    	int[] nums = new int[n];
    	for (int i = 0; i < n; i++) {
    		nums[i] = i + 1;
    	}
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	List<Integer> list = new ArrayList<Integer>();
    	combineHelper(result, list, 0, nums, k);
    	return result;
    }
    
    private void combineHelper(List<List<Integer>> result, List<Integer> list,
    		int pos, int[] nums, int k) {
    	if (list.size() == k) {
    		result.add(new ArrayList<Integer>(list));
    	}
    	for (int i = pos; i < nums.length; i++) {
    		list.add(nums[i]);
    		combineHelper(result, list, i + 1, nums, k);
    		list.remove(list.size() - 1);
    	}
    }

}
